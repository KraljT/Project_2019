package com.example.stuff_14.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stuff_14.R;

import java.util.ArrayList;

public class Collection_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button btn_ach;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    ////////////////////////////////////// recycleView
    private static final String TAG = "Shop_Activity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        btn_shop = findViewById(R.id.btn_shop);
        btn_ach = findViewById(R.id.btn_achievement);
        ////////////////////////////////////////
        Log.d(TAG,"oncreate: started");
        initImageBitmaps();
        //////////////////////////////////////////////////
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
    private void initImageBitmaps()
    {
        Log.d(TAG,"initImageBitmaps: prepering bitmaps");
        mImageUrls.add("https://www.dropbox.com/s/wk0bzsch7kcv9mh/shop_icon.png?dl=1");
        mNames.add("Shopping cart");
        mPrice.add("");
        mImageUrls.add("https://www.dropbox.com/s/30nzzo5lvmycxcq/home_icon.png?dl=1");
        mNames.add("House");
        mPrice.add("");
        mImageUrls.add("https://www.dropbox.com/s/1g4cdbkvgv24w6p/achiments_icon.png?dl=1");
        mNames.add("Trophy");
        mPrice.add("");.
        mImageUrls.add("https://www.dropbox.com/s/y4n6v50erizwinj/camera_icon.png?dl=1");
        mNames.add("Camera");
        mPrice.add("");
        mImageUrls.add("https://www.dropbox.com/s/yflo8dzj8es56mh/medalija.png?dl=1");
        mNames.add("Medal");
        mPrice.add("");
        mImageUrls.add("https://www.dropbox.com/s/4elknb4gt8uznwy/settings.png?dl=1");
        mNames.add("Cogwheel");
        mPrice.add("");
        mImageUrls.add("https://www.dropbox.com/s/hq5m3onfiic8bkz/power_up.png?dl=1");
        mNames.add("Power up");
        mPrice.add("");

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            int resid = bundle.getInt("res");
            mImageUrls.add(Integer.toString(resid));
            mNames.add("Your pic");
        }



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
