package com.example.resturant_billing;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

//        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        drawerLayout = findViewById(R.id.drawer_layout);
//        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigationView);
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




        replaceFragment(new TablesFragment());

//        bottomNavigationView.setBackground(null);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//
//            switch (item.getItemId()) {
////                case R.id.tables:
////                    replaceFragment(new TablesFragment());
////                    break;
////                case R.id.ListItem:
////                    replaceFragment(new ItemAddFragment());
////                    break;
////                case R.id.ItemOnTable:
////                    replaceFragment(new ItemsOnTable());
//            }
//
//            return true;
//        });

//       fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showBottomDialog();
//            }
//        });



    }


    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }



//
//    private void showBottomDialog() {
//
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.bottomsheetlayout);
//
//        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
//        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
//        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
//        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);
//
//        videoLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(MainLayout.this,"Upload a Video is clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        shortsLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(MainLayout.this,"Create a short is Clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        liveLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//                Toast.makeText(MainLayout.this,"Go live is Clicked",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        dialog.getWindow().setGravity(Gravity.BOTTOM);
//
//    }


}
