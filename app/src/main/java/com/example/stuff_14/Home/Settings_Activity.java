package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stuff_14.MainActivity;
import com.example.stuff_14.R;
import com.google.firebase.auth.FirebaseAuth;

public class Settings_Activity extends AppCompatActivity {

    private Button btn_logout;
    private FirebaseAuth mAuth;
    private  Button conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}