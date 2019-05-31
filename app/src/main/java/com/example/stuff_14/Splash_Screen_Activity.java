package com.example.stuff_14;

        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import java.util.Timer;
        import java.util.TimerTask;

public class Splash_Screen_Activity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN);
    }

}
