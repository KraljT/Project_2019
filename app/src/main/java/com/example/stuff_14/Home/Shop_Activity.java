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

public class Shop_Activity extends AppCompatActivity {
    private Button btn_ach;
    private Button btn_col;
    private Button btn_home;
    private Button btn_gps;
    ////////////////////////////////////// recycleView
    private static final String TAG = "Shop_Activity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    ////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        btn_ach = findViewById(R.id.btn_achievement);
        btn_col = findViewById(R.id.btn_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        ////////////////////////////////////////
        Log.d(TAG,"oncreate: started");
        initImageBitmaps();
        //////////////////////////////////////////////////
        btn_ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop_Activity.this,Achievement_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop_Activity.this,Collection_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop_Activity.this,GPS_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop_Activity.this,Home_Activity.class);
                startActivity(intent);
            }
        });
    }
    private void initImageBitmaps()
    {
        Log.d(TAG,"initImageBitmaps: prepering bitmaps");
        mImageUrls.add("https://www.dropbox.com/s/nu2uqawuj5blobg/common.png?dl=1");
        mNames.add("Commmon card pack");
        mPrice.add("25 CP");
        mImageUrls.add("https://www.dropbox.com/s/3z443pepca902py/rare.png?dl=1");
        mNames.add("Rare card pack");
        mPrice.add("50 CP");
        mImageUrls.add("https://www.dropbox.com/s/ra6do8ar6v0qscj/epic.png?dl=1");
        mNames.add("Epic card pack");
        mPrice.add("100 CP");
        mImageUrls.add("https://www.dropbox.com/s/n39zjgx8v7klsbp/legendary.png?dl=1");
        mNames.add("Legendary card pack");
        mPrice.add("250 CP");
        mImageUrls.add("https://www.dropbox.com/s/i3ypxbyt3ph9z6l/unique.png?dl=1");
        mNames.add("Unique card pack");
        mPrice.add("500 CP");
        mImageUrls.add("https://www.dropbox.com/s/dh16epb0d5a03sv/power_up_common.png?dl=1");
        mNames.add("Reduce common time");
        mPrice.add("15 CP");
        mImageUrls.add("https://www.dropbox.com/s/2jjuzfmpq02j99s/power_up_rare.png?dl=1");
        mNames.add("Reduce rare time");
        mPrice.add("35 CP");
        mImageUrls.add("https://www.dropbox.com/s/9ogx06r3zf3q3s0/power_up_epic.png?dl=1");
        mNames.add("Reduce epic time");
        mPrice.add("50 CP");


        initRecyclerView();
    }
    private void initRecyclerView()
    {
        Log.d(TAG,"initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecycleViewAdapter adapter = new RecycleViewAdapter(mNames,mImageUrls,mPrice,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
