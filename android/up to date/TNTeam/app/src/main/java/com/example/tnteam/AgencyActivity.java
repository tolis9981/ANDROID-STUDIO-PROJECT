/*    PROGIOS    */
package com.example.tnteam;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class AgencyActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;    public static MyDB myAppDatabase;
    Toolbar toolbar;    DrawerLayout drawerLayout;    NavigationView navigationView;
    private sharedPreferenceConfig sharedPreferenceConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);

        sharedPreferenceConfig=new sharedPreferenceConfig(getApplicationContext());

        //Navigation tool bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.location:
                        menuItem.setChecked(true);
                        displayMessage("Location");
                        drawerLayout.closeDrawers();
/*                        fragmentManager.beginTransaction().
                                replace(R.id.fragment_container, new MapFragment()).commit(); */
                        return true;
                    case R.id.edit:
                        menuItem.setChecked(true);
                        displayMessage("Edit Agencys");
                        drawerLayout.closeDrawers();
                        fragmentManager.beginTransaction().
                                replace(R.id.fragment_container, new menuFragment2()).commit();
                        return true;
                    case R.id.logout:
                        menuItem.setChecked(true);
                        displayMessage("logout");
                        drawerLayout.closeDrawers();
                        sharedPreferenceConfig.writeLoginStatus(false);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        return true;
                    case R.id.about:
                        menuItem.setChecked(true);
                        displayMessage("About");
                        drawerLayout.closeDrawers();
                        fragmentManager.beginTransaction().
                                replace(R.id.fragment_container, new AboutFragment()).commit();
                        return true;
                    case R.id.exit:
                        menuItem.setChecked(true);
                        displayMessage("Close app");
                        //drawerLayout.closeDrawers();
                        finishAffinity();
                        return true;
                }
                return false;
            }
        });
        // Data Base
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class,"reservesBD").allowMainThreadQueries().build();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().
                    add(R.id.fragment_container, new AgencyFragment()).commit();
        }
    }

    void displayMessage(String message) { Toast.makeText(this, message, Toast.LENGTH_LONG).show(); }
}