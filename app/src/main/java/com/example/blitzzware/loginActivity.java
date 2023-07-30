package com.example.blitzzware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.blitzzware.databinding.ActivityLoginBinding;
import com.example.blitzzware.databinding.ScreenSplashBinding;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityLoginBinding loginBinding;
    Intent intent2;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        loginBinding= ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);
        init();
    }

    public void init(){
        loginBinding.btnLogin.setOnClickListener(this);
        sharedPref= getSharedPreferences("login_details", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==loginBinding.btnLogin.getId()){
            if (loginBinding.edtUserId.getText().toString().trim().equals("Jil") && loginBinding.edtPasswd.getText().toString().trim().equals("test")){
                intent2 = new Intent(this, NavigationBar.class);
//                User objUser = new User(loginBinding.edtUserId.getText().toString().trim(), loginBinding.edtEmailid.getText().toString().trim());
//                intent2.putExtra("USER_DETAILS", objUser);
                SharedPreferences.Editor editor1 = sharedPref.edit();
                editor1.putString("USER_ID", loginBinding.edtUserId.getText().toString().trim());
//                editor1.putString("EMAIL_ID", loginBinding.edtEmailid.getText().toString().trim());
                editor1.commit();
                startActivity(intent2);
            }else {
                Toast.makeText(getApplicationContext(), "Invalid user is or password", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void btn_Login(View v){
        if (loginBinding.edtUserId.getText().toString().trim().equals("Jil") && loginBinding.edtPasswd.getText().toString().trim().equals("test")){
            intent2 = new Intent(this, NavigationBar.class);
//                User objUser = new User(loginBinding.edtUserId.getText().toString().trim(), loginBinding.edtEmailid.getText().toString().trim());
//                intent2.putExtra("USER_DETAILS", objUser);
            SharedPreferences.Editor editor1 = sharedPref.edit();
            editor1.putString("USER_ID", loginBinding.edtUserId.getText().toString().trim());
//                editor1.putString("EMAIL_ID", loginBinding.edtEmailid.getText().toString().trim());
            editor1.commit();
            startActivity(intent2);
        }else {
            Toast.makeText(getApplicationContext(), "Invalid user is or password", Toast.LENGTH_LONG).show();
        }
    }
}