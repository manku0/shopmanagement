package com.maya.shopdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.maya.shopdetails.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      binding.cementtab.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
              replacefragment(new CementFragment());
          }
      });
        binding.irontab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                replacefragment(new IronFragment());
            }
        });
        binding.cementplates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacefragment(new AsbestusFragment());
            }
        });
        binding.pvcproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacefragment(new pvcFragment());
            }
        });


        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.moving_object);

        binding.wlcmtxt.startAnimation(animSlideDown);

    }
    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}