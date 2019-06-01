package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.stuff_14.R;

public class Achievement_Activity extends AppCompatActivity {
    private Button btn_col;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    ////////////////////////////////////// recycleView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        btn_col = findViewById(R.id.btn_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        btn_shop = findViewById(R.id.btn_shop);
        ////////////////////////////////////////////////
        //////////////////////////////////////////////////
        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Achievement_Activity.this,Collection_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Achievement_Activity.this,Shop_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Achievement_Activity.this,GPS_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Achievement_Activity.this,Home_Activity.class);
                startActivity(intent);
            }
        });

    }

}
