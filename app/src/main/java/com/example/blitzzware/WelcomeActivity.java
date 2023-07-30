package com.example.blitzzware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.blitzzware.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    ActivityWelcomeBinding welcomeBinding;
    SharedPreferences sharedPref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);
        welcomeBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        View view = welcomeBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init(){
        sharedPref1 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
        welcomeBinding.txtWelcome.setText("Welcome " + sharedPref1.getString("USER_ID", null) +"!" + "\n"+ sharedPref1.getString("EMAIL_ID", null) );

    }
}