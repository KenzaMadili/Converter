package com.example.convertertabsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.activity.OnBackPressedCallback;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayoutMain;
    private ViewPager2 viewPagerMain;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayoutMain = findViewById(R.id.tabLayoutMain);
        viewPagerMain = findViewById(R.id.viewPagerMain);

        // Adapter
        pagerAdapter = new ViewPagerAdapter(this);
        viewPagerMain.setAdapter(pagerAdapter);

        // Tabs
        new TabLayoutMediator(tabLayoutMain, viewPagerMain,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Température 🌡️");
                            break;
                        case 1:
                            tab.setText("Distance 📏");
                            break;
                    }
                }
        ).attach();

        // ✅ Back button moderne
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Quitter l'application")
                        .setMessage("Êtes-vous sûr de vouloir quitter ?")
                        .setPositiveButton("Oui", (dialog, which) -> finish())
                        .setNegativeButton("Annuler", null)
                        .setCancelable(true)
                        .show();
            }
        });
    }
}