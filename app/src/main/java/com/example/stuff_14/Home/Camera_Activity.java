package com.example.stuff_14.Home;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


import com.example.stuff_14.R;


public class Camera_Activity extends AppCompatActivity {
    Button camera;
    ImageView original;
    ImageView pixel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        camera = findViewById(R.id.btn_camera);
        original = findViewById(R.id.imageView_original);
        pixel = findViewById(R.id.imageView_pixel);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile());
                startActivityForResult(intent, 1);

            }
        });


    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap original_bitmap = (Bitmap) data.getExtras().get("data");
        original.setImageBitmap(original_bitmap);
        int width= original_bitmap.getWidth();
        int heght = original_bitmap.getHeight();
        //Bitmap pixels = Bitmap.createScaledBitmap(original_bitmap, 10, 10, false);
        Bitmap pixels = Bitmap.createScaledBitmap(original_bitmap,(int)(original_bitmap.getWidth()*.20),(int)(original_bitmap.getHeight()*.20),false);
        Bitmap pixels2 = Bitmap.createScaledBitmap(pixels,width,heght,false);
       //Bitmap pixels;
      //pixels = BITMAP_RESIZER(original_bitmap,10,10);
       // pixels = filter(original_bitmap);
        pixel.setImageBitmap(pixels2);

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
   /*public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
       int width = bm.getWidth();
       int height = bm.getHeight();
       float scaleWidth = ((float) newWidth) / width;
       float scaleHeight = ((float) newHeight) / height;
       // CREATE A MATRIX FOR THE MANIPULATION
       Matrix matrix = new Matrix();
       // RESIZE THE BIT MAP
       matrix.postScale(scaleWidth, scaleHeight);

       // "RECREATE" THE NEW BITMAP
       Bitmap resizedBitmap = Bitmap.createBitmap(
               bm, 0, 0, width, height, matrix, false);
       bm.recycle();
       return resizedBitmap;
   }*/
  /* public Bitmap BITMAP_RESIZER(Bitmap bitmap,int newWidth,int newHeight) {
       Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);

       float ratioX = newWidth / (float) bitmap.getWidth();
       float ratioY = newHeight / (float) bitmap.getHeight();
       float middleX = newWidth / 2.0f;
       float middleY = newHeight / 2.0f;

       Matrix scaleMatrix = new Matrix();
       scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

       Canvas canvas = new Canvas(scaledBitmap);
       canvas.setMatrix(scaleMatrix);
       canvas.drawBitmap(bitmap, middleX - bitmap.getWidth() / 2, middleY - bitmap.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

       return scaledBitmap;

   }
   */
  /*  public Bitmap filter(Bitmap bmIn) {
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
}
