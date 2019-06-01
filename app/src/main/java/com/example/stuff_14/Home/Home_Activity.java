package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stuff_14.MainActivity;
import com.example.stuff_14.Register_Activity;
import com.example.stuff_14.R;
import com.google.firebase.auth.FirebaseAuth;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_logout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_logout = findViewById(R.id.btn_Logout);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        btn_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_logout)
        {
            mAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
