package com.example.blitzzware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.blitzzware.databinding.ActivityMainBinding;
import com.example.blitzzware.databinding.ActivityWelcomeBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    ActivityMainBinding binding;
    int[] Layouts;
    SliderAdapter mAdapter;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        Layouts = new int[]{
                R.layout.fragment_home,
                R.layout.fragment_notification,
                R.layout.fragment_settings,
        };
        binding.btnSkip.setOnClickListener(this);
        binding.btnNext.setOnClickListener(this);

        mAdapter = new SliderAdapter(Layouts);
        binding.viewPager.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        // when clicking the next button
        if (v.getId() == binding.btnNext.getId()) {
            int current = getItem(1);
            if (current < Layouts.length) {
                binding.viewPager.setCurrentItem(current);
                if (current == Layouts.length - 1) {
                    binding.btnNext.setText(R.string.cont);
                }
            } else {
                launchLoginScreen();
            }
        } else if (v.getId() == binding.btnSkip.getId()) {
            launchLoginScreen();
        }
    }

    private void launchLoginScreen() {
        myIntent = new Intent(this, loginActivity.class);
        startActivity(myIntent);

    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }
}