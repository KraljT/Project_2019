package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stuff_14.MainActivity;
import com.example.stuff_14.R;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;

public class Settings_Activity extends AppCompatActivity {

    private Button btn_logout;
    private FirebaseAuth mAuth;
    private  Button conf;
    private EditText text;
    private Button btn_ach;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    private Button btn_coll;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        conf = findViewById(R.id.btn_confirm);
        text= findViewById(R.id.editText_change_username);
        btn_logout = findViewById(R.id.btn_logout);
        mAuth = FirebaseAuth.getInstance();
        btn_home = findViewById(R.id.btn_home2);
        btn_gps = findViewById(R.id.btn_gps2);
        btn_shop = findViewById(R.id.btn_shop2);
        btn_ach = findViewById(R.id.btn_achievement2);
        btn_coll = findViewById(R.id.btn_collection2);
        textView = findViewById(R.id.textView4);
        ////////////////////////////////////////////////////
        btn_coll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings_Activity.this,Collection_Activity.class);
                startActivity(intent);
            }
        });
        ///////////////////////////////////////////////////
        btn_ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings_Activity.this,Achievement_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings_Activity.this,Shop_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings_Activity.this,GPS_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings_Activity.this,Home_Activity.class);
                startActivity(intent);
            }
        });
        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Settings_Activity.this,MainActivity.class));
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = text.getText().toString();
                Change_Username event = new Change_Username();
                event.setUsername(username);
                EventBus.getDefault().post(event);
                Algorith_v4 test = new Algorith_v4();
                test.setUsername(username);
                test.ConvertToInt();
                textView.setText(test.ToString());

            }
        });
    }

}