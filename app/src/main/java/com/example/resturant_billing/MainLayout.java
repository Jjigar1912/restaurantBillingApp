package com.example.resturant_billing;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainLayout extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        drawerLayout = findViewById(R.id.drawer_layout);
<<<<<<< HEAD

//        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigationView);
=======
>>>>>>> aa8459f2b762beeb6cb1a1387196b0d45b3b01a7
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new TablesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
<<<<<<< HEAD
                Log.d("J",String.valueOf(item.getItemId()));
                switch (item.getTitle().toString()){

                    case "Home":
=======
                switch (String.valueOf(item.getItemId())){
                    case "2131296593":
>>>>>>> aa8459f2b762beeb6cb1a1387196b0d45b3b01a7
                        replaceFragment( new ItemAddFragment());
                        break;
                    case "Add Item":
                        replaceFragment(new add_item_admin());
                        break;
                    case "Profile":
                        replaceFragment(new ProfileFragment());
                        break;
                    case "Logout":
                        SharedPreferences preferences = getSharedPreferences("id",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("userid",0);
                        editor.apply();
                        Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        Toast.makeText(MainLayout.this, "Please select valid menu Item", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });

        AppCompatButton gotoOrder=(AppCompatButton) findViewById(R.id.gotToOrderList);

        gotoOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ItemsOnTable());

            }
        });
<<<<<<< HEAD
        replaceFragment(new ItemAddFragment());
=======

        replaceFragment(new ItemAddFragment());





>>>>>>> aa8459f2b762beeb6cb1a1387196b0d45b3b01a7
    }


    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }



<<<<<<< HEAD
=======


>>>>>>> 21f87ddf3c750079e67b0327e4cd90052167b542
}
