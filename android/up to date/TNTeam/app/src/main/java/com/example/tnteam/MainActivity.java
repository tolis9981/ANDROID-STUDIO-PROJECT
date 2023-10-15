//PROGIOS
package com.example.tnteam;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static MyDB myAppDatabase;
    public static FragmentManager fragmentManager;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private sharedPreferenceConfig sharedPreferencesConf;
    TextInputEditText Agency_Login_Id, Agency_Login_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        /*  Local DataBase */
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class,
                "MYDB").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        /*  Navigation tool bar */
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //For delete or create a new activity with Login in toolbar
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
                        drawerLayout.closeDrawers();
                        finishAffinity();
                        return true;
                }
                return false;
            }
        });
/*  Pause this part of code, because login and new Activity start with methos loginAgency
        //  Login button action
        Button btn = findViewById(R.id.agency_login_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInt = new Intent(getApplicationContext(), AgencyActivity.class);
                startActivity(myInt);
            }
        });
*/
/*
        //  Fragment Login
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class,"reservesBD").allowMainThreadQueries().build();
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().
                    add(R.id.fragment_container, new LoginFragment()).commit();
        }
 */
        /*  SharedPrefeerence  */
        sharedPreferencesConf = new sharedPreferenceConfig(getApplicationContext());
        Agency_Login_Id = findViewById((R.id.agency_login_id));
        Agency_Login_Name = findViewById(R.id.agency_login_name);
        if (sharedPreferencesConf.readLoginStatus()) {
            startActivity(new Intent(this, AgencyActivity.class));
            finish();
        }
    }
    public void loginAgency(View view) {
        String varId = Agency_Login_Id.getText().toString();
        String varName = Agency_Login_Name.getText().toString();
        if (varId.equals(getResources().getString(R.string.agency_id)) &&
                varName.equals(getResources().getString(R.string.agency_name))){
            startActivity(new Intent(this, AgencyActivity.class));
            sharedPreferencesConf.writeLoginStatus(true);
            finish();
        }else{
            Toast.makeText(this,
                    "Loging Failed! Check input data and Try again ", Toast.LENGTH_LONG).show();
            Agency_Login_Id.setText("");
            Agency_Login_Name.setText("");
    }
}
    void displayMessage(String message){Toast.makeText(this, message, Toast.LENGTH_LONG).show();}
    @Override
    protected void onStart(){super.onStart();Toast.makeText(getApplicationContext(), "Welcome !", Toast.LENGTH_LONG).show();}
}