package com.example.blitzzware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.blitzzware.databinding.BarNavigationBinding;
import com.google.android.material.navigation.NavigationView;

public class NavigationBar extends AppCompatActivity implements View.OnClickListener {

    BarNavigationBinding navigationBinding;
    ActionBarDrawerToggle mToggle;
    SharedPreferences sharedPref2;
//    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        navigationBinding = BarNavigationBinding.inflate(getLayoutInflater());
        setContentView(navigationBinding.getRoot());
        init();
        getNavigationDrawer();
    }



    public void init(){

        sharedPref2 = getSharedPreferences("login_details", Context.MODE_PRIVATE);
//        mainBinding.txtWelcome.setText("Welcome" + sharedPref2.getString("USER_ID", null));

        mToggle = new ActionBarDrawerToggle(this, navigationBinding.drawerLayout, navigationBinding.materialToolbar, R.string.nav_open, R.string.nav_close);
        navigationBinding.drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        setSupportActionBar(navigationBinding.materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationDrawer();
        settingUpFragment(new HomeFragment());


    }
    public void settingUpFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
    private void setNavigationDrawer() {
        navigationBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int itemId = item.getItemId();
                if(itemId == R.id.home_nav){
                    settingUpFragment(new HomeFragment());

                }else if(itemId == R.id.notification_nav){
                    settingUpFragment(new NotificationFragment());
                }else if(itemId == R.id.settings_nav){
                    settingUpFragment(new SettingsFragment());
                }

                navigationBinding.drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getNavigationDrawer(){

    }

    @Override
    public void onClick(View v) {

    }
}