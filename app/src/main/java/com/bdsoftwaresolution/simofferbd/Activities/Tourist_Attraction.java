package com.bdsoftwaresolution.simofferbd.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.bdsoftwaresolution.simofferbd.Fragments.BarishalFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.ChittagongFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.DhakaFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.KhulnaFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.MymensinghFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.RajshahiFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.RangpurFragment;
import com.bdsoftwaresolution.simofferbd.Fragments.SylhetFragment;
import com.bdsoftwaresolution.simofferbd.R;

public class Tourist_Attraction extends AppCompatActivity {
    private CardView dhaka,chittagong,barishal,khulna,mymensingh,rajshahi,rangpur,sylhet;
    private FrameLayout frameLayout;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist__attraction);
        casting();
        clickLesener();

    }

    private void clickLesener() {
        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                DhakaFragment dhakaFragment = new DhakaFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.frame_cointainer,dhakaFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });


        chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                ChittagongFragment chittagongFragment = new ChittagongFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,chittagongFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        barishal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                BarishalFragment barishalFragment = new BarishalFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,barishalFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        khulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                KhulnaFragment khulnaFragment = new KhulnaFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,khulnaFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        mymensingh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                MymensinghFragment mymensinghFragment = new MymensinghFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,mymensinghFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        rajshahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                RajshahiFragment rajshahiFragment = new RajshahiFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,rajshahiFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                RangpurFragment rangpurFragment = new RangpurFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,rangpurFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.setVisibility(View.VISIBLE);
                SylhetFragment sylhetFragment = new SylhetFragment();
                FragmentManager fragmentManager =getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_cointainer,sylhetFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

    }

    private void casting() {
        dhaka = findViewById(R.id.dhaka_ID);
        chittagong = findViewById(R.id.chittagong_ID);
        barishal = findViewById(R.id.barishal_ID);
        khulna = findViewById(R.id.khulna_ID);
        mymensingh = findViewById(R.id.mymensingh_ID);
        rajshahi = findViewById(R.id.rajshahi_ID);
        rangpur = findViewById(R.id.rangpur_ID);
        sylhet = findViewById(R.id.sylhet_ID);
        frameLayout = findViewById(R.id.frame_cointainer);
    }


}
