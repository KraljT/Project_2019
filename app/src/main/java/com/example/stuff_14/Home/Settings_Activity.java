package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stuff_14.MainActivity;
import com.example.stuff_14.R;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;

public class Settings_Activity extends AppCompatActivity {

    private Button btn_logout;
    private FirebaseAuth mAuth;
    private  Button conf;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = findViewById(R.id.editText_change_username);
        setContentView(R.layout.activity_settings);
        btn_logout = findViewById(R.id.btn_logout);
        mAuth = FirebaseAuth.getInstance();
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
        conf = findViewById(R.id.btn_confirm);
        text= findViewById(R.id.editText_change_username);
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = text.getText().toString();
                Change_Username event = new Change_Username();
                event.setUsername(username);
                EventBus.getDefault().post(event);
                finish();
            }
        });
    }

}