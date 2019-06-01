package com.example.stuff_14.Home;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stuff_14.MainActivity;
import com.example.stuff_14.Register_Activity;
import com.example.stuff_14.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Home_Activity extends AppCompatActivity{
    private static final String TAG = "MainAcitivty";
    private static final long START_TIME_COM = 24 * 60 * 60 * 1000;
    TextView com;
    CountDownTimer timer_com;
    ///////////////////////////////////////
    private static final long START_TIME_RARE = 7 * 24 * 60 * 60 * 1000;
    TextView rare;
    CountDownTimer timer_rare;
    //////////////////////////////////////
    private static final long START_TIME_EPIC = 21 * 24 * 60 * 60 * 1000;
    TextView epic;
    CountDownTimer timer_epic;
    ///////////////////////////////////////
    private Button btn_ach;
    private Button btn_col;
    private Button btn_home;
    private Button btn_gps;
    private Button btn_shop;
    private Button btn_set;
    private Button btn_camera;
    //////////////////////////////////////
    private TextView textView_player;
    ////////////////////////////////////ž
    ApplicationMy app;
    Change_Username data;

    /////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        com = findViewById(R.id.textView_comm);
        rare = findViewById(R.id.textView_rare);
        epic = findViewById(R.id.textView_epic);
        btn_ach = findViewById(R.id.btn_achievement);
        btn_col = findViewById(R.id.btn_collection);
        btn_home = findViewById(R.id.btn_home);
        btn_gps = findViewById(R.id.btn_gps);
        btn_shop = findViewById(R.id.btn_shop);
        btn_set = findViewById(R.id.btn_settings);
        btn_camera = findViewById(R.id.btn_camera);
        Calendar curr_time = Calendar.getInstance();
        long curr_time_mill = curr_time.getTimeInMillis();
        long tomorrow = curr_time_mill + (24 * 60 * 60 * 1000);
        long razlika = tomorrow - curr_time_mill;
        System.out.println("trenutno " + curr_time_mill);
        System.out.println("jutri " + tomorrow);
        System.out.println("razlika " + razlika);
        timer_com = new CountDownTimer(razlika, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               /* /*time_left_in_mill=millisUntilFinished;
                int h=(int) (time_left_in_mill/1000);
                int min=(int)(time_left_in_mill/1000)/60;
                int sec=(int)(time_left_in_mill/1000)%60;
                String timeLeft=String.format(Locale.getDefault(),"%02d:%02d:%02d",h,min,sec);
                */

                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d:%02d",
                        (TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

                com.setText(timeLeft);
                // timer_com.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                com.setText("DONE");
            }
        };
        timer_com.start();
        ///////////////////////////////////////////////////////7
        timer_rare = new CountDownTimer(START_TIME_RARE, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d:%02d:%02d",
                        (TimeUnit.HOURS.toDays(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                rare.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                rare.setText("DONE!");
            }
        };
        timer_rare.start();
        ////////////////////////////////////////////////////////
        timer_epic = new CountDownTimer(START_TIME_EPIC, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d:%02d:%02d",
                        (TimeUnit.HOURS.toDays(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))
                        , (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                epic.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                epic.setText("DONE!");
            }
        };
        timer_epic.start();



    }


}
