package com.nappdeveloper.juff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nappdeveloper.juff.Fragments.homeFragment;
import com.nappdeveloper.juff.Fragments.profileFragment;
import com.nappdeveloper.juff.Fragments.restaurantsFragment;
import com.nappdeveloper.juff.Fragments.snapsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RelativeLayout relativeLayout_main;
    View v1, v2, v3, v4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        v1 = findViewById(R.id.view1);
        v2 = findViewById(R.id.view2);
        v3 = findViewById(R.id.view3);
        v4 = findViewById(R.id.view4);

        relativeLayout_main = (RelativeLayout) findViewById(R.id.main_layout);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNavigationView);
        bottomNavigationView.setBackground(null);
        Menu menuNav = bottomNavigationView.getMenu();
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, new homeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnavMethod);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomnavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment = null;
                    switch (item.getItemId()) {

                        case R.id.homeMenu:
                            fragment = new homeFragment();
                            v1.setBackgroundColor(getResources().getColor(R.color.pale_pink));
                            v2.setBackgroundColor(getResources().getColor(R.color.white));
                            v3.setBackgroundColor(getResources().getColor(R.color.white));
                            v4.setBackgroundColor(getResources().getColor(R.color.white));
                            relativeLayout_main.setBackgroundColor(getResources().getColor(R.color.white));
                            break;
                        case R.id.restaurantMenu:
                            fragment = new restaurantsFragment();
                            v2.setBackgroundColor(getResources().getColor(R.color.pale_pink));
                            v1.setBackgroundColor(getResources().getColor(R.color.white));
                            v3.setBackgroundColor(getResources().getColor(R.color.white));
                            v4.setBackgroundColor(getResources().getColor(R.color.white));
                            relativeLayout_main.setBackgroundColor(getResources().getColor(R.color.white));
                            break;
                        case R.id.snapsMenu:
                            fragment = new snapsFragment();
                            v3.setBackgroundColor(getResources().getColor(R.color.pale_pink));
                            v1.setBackgroundColor(getResources().getColor(R.color.white));
                            v2.setBackgroundColor(getResources().getColor(R.color.white));
                            v4.setBackgroundColor(getResources().getColor(R.color.white));
                            relativeLayout_main.setBackgroundColor(getResources().getColor(R.color.white));
                            break;
                        case R.id.profileMenu:
                            fragment = new profileFragment();
                            v4.setBackgroundColor(getResources().getColor(R.color.pale_pink));
                            v1.setBackgroundColor(getResources().getColor(R.color.white));
                            v2.setBackgroundColor(getResources().getColor(R.color.white));
                            v3.setBackgroundColor(getResources().getColor(R.color.white));
                            relativeLayout_main.setBackgroundColor(getResources().getColor(R.color.white));
                            break;

                        default:
                            Toast.makeText(getApplicationContext(), "Unknown Location", Toast.LENGTH_SHORT).show();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer, fragment).commit();
                    return true;
                }

            };

}