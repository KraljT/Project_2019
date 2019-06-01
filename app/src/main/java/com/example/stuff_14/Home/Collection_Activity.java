package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stuff_14.R;

public class Collection_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button btn_ach;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        btn_shop = findViewById(R.id.btn_shop);
        //////////////////////////////////////////////////
        Spinner spinner =findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.num,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ///////////////////////////////////////////////////
        btn_ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_Activity.this,Achievement_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_Activity.this,Shop_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_Activity.this,GPS_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Collection_Activity.this,Home_Activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
