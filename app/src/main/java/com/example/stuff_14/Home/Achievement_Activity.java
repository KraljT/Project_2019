package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.stuff_14.R;

import java.util.ArrayList;

public class Achievement_Activity extends AppCompatActivity {
    private Button btn_col;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    ////////////////////////////////////// recycleView
    private static final String TAG = "Achievemnet_Activity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        btn_col = findViewById(R.id.btn_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        btn_shop = findViewById(R.id.btn_shop);
        ////////////////////////////////////////////////
        Log.d(TAG,"oncreate: started");
        initImageBitmaps();
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
    private void initImageBitmaps()
    {
        Log.d(TAG,"initImageBitmaps: prepering bitmaps");
        mImageUrls.add("https://www.dropbox.com/s/yflo8dzj8es56mh/medalija.png?dl=1");
        mNames.add("Animal lover");
        mImageUrls.add("https://www.dropbox.com/s/yflo8dzj8es56mh/medalija.png?dl=1");
        mNames.add("Simple geometry");
        mImageUrls.add("https://www.dropbox.com/s/yflo8dzj8es56mh/medalija.png?dl=1");
        mNames.add("Now you can\ndress yourself");
        mImageUrls.add("https://www.dropbox.com/s/xnbwxd9pr8hmbuk/medalija_nedobljena.png?dl=1");
        mNames.add("??????");
        mImageUrls.add("https://www.dropbox.com/s/xnbwxd9pr8hmbuk/medalija_nedobljena.png?dl=1");
        mNames.add("??????");
        mImageUrls.add("https://www.dropbox.com/s/xnbwxd9pr8hmbuk/medalija_nedobljena.png?dl=1");
        mNames.add("??????");
        mImageUrls.add("https://www.dropbox.com/s/xnbwxd9pr8hmbuk/medalija_nedobljena.png?dl=1");
        mNames.add("??????");
        mImageUrls.add("https://www.dropbox.com/s/yflo8dzj8es56mh/medalija.png?dl=1");
        mNames.add("LOVE");


        initRecyclerView();
    }
    private void initRecyclerView()
    {
        Log.d(TAG,"initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecycleViewAdapter adapter = new RecycleViewAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
