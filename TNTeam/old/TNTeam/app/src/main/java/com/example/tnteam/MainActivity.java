//PROGIOS
package com.example.tnteam;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {

    public users userToCheck;

    public static MyDB myAppDatabase;    public static FragmentManager fragmentManager;
    public static FirebaseFirestore firestoreDB;
    Toolbar toolbar;    DrawerLayout drawerLayout;    NavigationView navigationView;
    private sharedPreferenceConfig sharedPreferencesConf;    TextInputEditText Agency_Login_Id, Agency_Login_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        /*  Local DataBase */
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDB.class,
                "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        /*  Remote DataBase  */
        firestoreDB = FirebaseFirestore.getInstance();

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
                    case R.id.exit:
                        menuItem.setChecked(true);
                        displayMessage("Close app");
                        drawerLayout.closeDrawers();
                        createNotif("TNTeam","Just Finish All Activity");
                        finishAffinity();
                        return true;
                }
                return false;
            }
        });

        /*  SharedPreference  */
        sharedPreferencesConf = new sharedPreferenceConfig(getApplicationContext());
        Agency_Login_Id = findViewById((R.id.agency_login_id));
        Agency_Login_Name = findViewById(R.id.agency_login_name);
        if (sharedPreferencesConf.readLoginStatus()) {
            startActivity(new Intent(this, AgencyActivity.class));
            finish();
        }
    }
    public void loginAgency(View view) {

        DocumentReference checkUser = firestoreDB.collection("users").document("0001");

        checkUser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    userToCheck = documentSnapshot.toObject(users.class);
                    Integer id  = userToCheck.getId();
                    String name = userToCheck.getName();
                    String password = userToCheck.getPassword();
                    Integer rights =userToCheck.getRights();
                } else {
                    //Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getActivity(), "query failed", Toast.LENGTH_LONG).show();
            }
        });

        String varId = Agency_Login_Id.getText().toString();
        String varName = Agency_Login_Name.getText().toString();
        if (varId.equals(userToCheck.getId()) && varName.equals(userToCheck.getName())){
            createNotif("TNTeam","Login success");
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
    private void createNotif(String Title, String Description) {

        String id = "my_apk";
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null) {
                channel = new NotificationChannel(id, "Channel Title", NotificationManager.IMPORTANCE_HIGH);
                //config nofication channel
                channel.setDescription("[Channel description]");
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{100, 1000, 200, 340});
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                manager.createNotificationChannel(channel);
            }
        }
        Intent notificationIntent = new Intent(this, NoficationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.ihu_mini)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_mini))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ihu_large))
                        .bigLargeIcon(null))
                .setContentTitle(Title)
                .setContentText(Description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100, 1000, 200, 340})
                .setAutoCancel(false) //true touch on notificaiton menu dismissed, but swipe to dismiss
                .setTicker("Notification");
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(getApplicationContext());
        //id o generate new notification in tlist notification
        m.notify(5, builder.build());
    }

}
