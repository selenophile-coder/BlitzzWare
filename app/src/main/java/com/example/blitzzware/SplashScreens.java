package com.example.blitzzware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.blitzzware.databinding.ScreenSplashBinding;

public class SplashScreens extends AppCompatActivity implements View.OnClickListener {

    ScreenSplashBinding splashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        splashBinding=ScreenSplashBinding.inflate(getLayoutInflater());
        View view = splashBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init(){
        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(2000);

                } catch (Exception e) {

                } finally {

                    try {
                            Intent intent = new Intent(SplashScreens.this, loginActivity.class);
                            startActivity(intent);
                            finish();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        timer.start();

    }


    @Override
    public void onClick(View v) {

    }
}