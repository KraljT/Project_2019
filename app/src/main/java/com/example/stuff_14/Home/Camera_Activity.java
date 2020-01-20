package com.example.stuff_14.Home;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.nio.ByteBuffer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.stuff_14.R;


public class Camera_Activity extends AppCompatActivity {
    Button camera;
    ImageView original;
    ImageView pixel;
    ImageView dropbox;
    Bitmap pixels;
    Bitmap pixels2;
    private Button btn_ach;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    private Button btn_coll;
    private final int REQUEST_CODE_CAMERA=123;
    public ArrayList<Integer> slika = new ArrayList<>();
    TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        camera = findViewById(R.id.btn_camera);
        original = findViewById(R.id.imageView_original);
        pixel = findViewById(R.id.imageView_pixel);
        dropbox = findViewById(R.id.imageView_dropbox);
        btn_home = findViewById(R.id.btn_home3);
        btn_gps = findViewById(R.id.btn_gps3);
        btn_shop = findViewById(R.id.btn_shop3);
        btn_ach = findViewById(R.id.btn_achievement3);
        btn_coll = findViewById(R.id.btn_collection3);
        test2 = findViewById(R.id.textView5);
        verifyPremission();
        ////////////////////////////////////////////////////
        btn_coll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera_Activity.this,Collection_Activity.class);
                startActivity(intent);
            }
        });
        ///////////////////////////////////////////////////
        btn_ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera_Activity.this,Achievement_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera_Activity.this,Shop_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera_Activity.this,GPS_Activity.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera_Activity.this,Home_Activity.class);
                startActivity(intent);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile());
                startActivityForResult(intent, 1);


            }
        });
        pixel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Camera_Activity.this,Collection_Activity.class);
                i.putExtra("res",pixels2);
                startActivity(i);
                Toast.makeText(Camera_Activity.this, "Image send", Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(this)
                .asBitmap()
                .load("https://www.dropbox.com/s/9rs1uidam5j33kf/IMG_20190612_130447.jpg?dl=1")
                .into(new CustomTarget<Bitmap>(){
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        dropbox.setImageBitmap(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });

    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap camera_bitmap = (Bitmap) data.getExtras().get("data");
        original.setImageBitmap(camera_bitmap);
        Bitmap dropbox_bitmap = imageView2Bitmap(dropbox);
        int width= camera_bitmap.getWidth();
        int heght = camera_bitmap.getHeight();
        pixels = Bitmap.createScaledBitmap(camera_bitmap,(int)(camera_bitmap.getWidth()*.20),(int)(camera_bitmap.getHeight()*.20),false); //to deluje boljse
        pixels2 = Bitmap.createScaledBitmap(pixels,width,heght,false);
        
     // pixels = filter(original_bitmap);
       if(equals(camera_bitmap,dropbox_bitmap)) {
            Toast.makeText(Camera_Activity.this, "Sliki sta podobni", Toast.LENGTH_SHORT).show();
        }
      else
            Toast.makeText(Camera_Activity.this, "Sliki nista podobni", Toast.LENGTH_SHORT).show();

        pixel.setImageBitmap(pixels2);
        //System.out.println(slika.toString());
        for(int i = 0; i<camera_bitmap.getWidth();i++)
        {
            for(int j =0; i<camera_bitmap.getHeight();j++)
            {
                slika.add(camera_bitmap.getPixel(i,j));

            }
        }
        Algorith_v4 test = new Algorith_v4();
        test.setSlika(slika);
        test.StartAlgo();
        test2.setText(test.toString());



    }
    public boolean equals(Bitmap bitmap1, Bitmap bitmap2) {
        ByteBuffer buffer1 = ByteBuffer.allocate(bitmap1.getHeight() * bitmap1.getRowBytes());
        bitmap1.copyPixelsToBuffer(buffer1);

        ByteBuffer buffer2 = ByteBuffer.allocate(bitmap2.getHeight() * bitmap2.getRowBytes());
        bitmap2.copyPixelsToBuffer(buffer2);

        return Arrays.equals(buffer1.array(), buffer2.array());
    }

    private Bitmap imageView2Bitmap(ImageView view){
        Bitmap bitmap = ((BitmapDrawable)view.getDrawable()).getBitmap();
        return bitmap;
    }
   /* public static Bitmap resizeBitmap(Bitmap source, int maxLength) {
        try {
            if (source.getHeight() >= source.getWidth()) {
                int targetHeight = maxLength;
                if (source.getHeight() <= targetHeight) { // if image already smaller than the required height
                    return source;
                }

                double aspectRatio = (double) source.getWidth() / (double) source.getHeight();
                int targetWidth = (int) (targetHeight * aspectRatio);

                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                }
                return result;
            } else {
                int targetWidth = maxLength;

                if (source.getWidth() <= targetWidth) { // if image already smaller than the required height
                    return source;
                }

                double aspectRatio = ((double) source.getHeight()) / ((double) source.getWidth());
                int targetHeight = (int) (targetWidth * aspectRatio);

                Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                if (result != source) {
                }
                return result;

            }
        } catch (Exception e) {
            return source;
        }
    }
 */
   /*
    public Bitmap filter(Bitmap bmIn) {
        Bitmap bmOut = Bitmap.createBitmap(bmIn.getWidth(), bmIn.getHeight(), bmIn.getConfig());
        int pixelationAmount = 10; //you can change it!!
        int width = bmIn.getWidth();
        int height = bmIn.getHeight();
        int avR, avB, avG; // store average of rgb
        int pixel;
        int n;

        for (int x = 0; x < width; x += pixelationAmount) { // do the whole image
            for (int y = 0; y < height; y += pixelationAmount) {
                avR = 0;
                avG = 0;
                avB = 0;


                int bx = x + pixelationAmount;
                int by = y + pixelationAmount;
                if (by >= height) by = height;
                if (bx >= width) bx = width;
                for (int xx = x; xx < bx; xx++) {// YOU WILL WANT TO PUYT SOME OUT OF                                      BOUNDS CHECKING HERE
                    for (int yy = y; yy < by; yy++) { // this is scanning the colors

                        pixel = bmIn.getPixel(xx, yy);
                        avR += (int) (Color.red(pixel));
                        avG += (int) (Color.green(pixel));
                        avB += (int) (Color.blue(pixel));
                    }
                }
                avR /= pixelationAmount ^ 2; //divide all by the amount of samples taken to get an average
                avG /= pixelationAmount ^ 2;
                avB /= pixelationAmount ^ 2;

                for (int xx = x; xx < bx; xx++)// YOU WILL WANT TO PUYT SOME OUT OF BOUNDS CHECKING HERE
                    for (int yy = y; yy < by; yy++) { // this is going back over the block
                        bmOut.setPixel(xx, yy, Color.argb(255, avR, avG, avB)); //sets the block to the average color
                    }


            }

        }
        return bmOut;
    }
*/
   private void verifyPremission()
   {
       String premission = Manifest.permission.CAMERA;
       final AlertDialog.Builder builder = new AlertDialog.Builder(this);
       if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
       {
           builder.setMessage("This application requires Camera premission to work properly, do you want to enable it?")
                   .setCancelable(false)
                   .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Intent intent = new Intent(Camera_Activity.this,Home_Activity.class);
                           startActivity(intent);
                       }
                   })
                   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                           ActivityCompat.requestPermissions(Camera_Activity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);
                       }
                   });

           final AlertDialog alert = builder.create();
           alert.show();
       }
       else
       {
           ActivityCompat.requestPermissions(Camera_Activity.this,new String[]{android.Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);
       }
   }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CODE_CAMERA)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(Camera_Activity.this, "Premission granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(Camera_Activity.this, "Premission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
