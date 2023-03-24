package com.example.myprojectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meowBottomNavigation = findViewById(R.id.meow_bottom_nav);

        //add item menu
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_search_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_favorite_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_notifications_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.baseline_settings_24));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new Home();
                        break;
                    case 2:
                        fragment = new Search();
                        break;
                    case 3:
                        fragment = new Favorite();
                        break;
                    case 4:
                        fragment = new Notification();
                        break;
                    case 5:
                        fragment = new Settings();
                        break;
                }
                loadFragment(fragment);
            }
        });
        //notification count
        meowBottomNavigation.setCount(4,"10");

        //default
        meowBottomNavigation.show(1,true);

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You Clicked" + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}