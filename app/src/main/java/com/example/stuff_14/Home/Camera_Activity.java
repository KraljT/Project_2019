package com.example.stuff_14.Home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.stuff_14.R;

public class Camera_Activity extends AppCompatActivity {
    Button btn_camera;
    ImageView camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btn_camera = findViewById(R.id.btn_camera);
        camera = findViewById(R.id.imageView_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile());
                startActivityForResult(intent,1);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        Bundle extras = data.getExtras();
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)extras.get("data");
        camera.setImageBitmap(bitmap);
    }
