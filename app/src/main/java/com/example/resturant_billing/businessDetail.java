package com.example.resturant_billing;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class businessDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.businessdetail);
        AppCompatButton setBdetail=(AppCompatButton) findViewById(R.id.SetBussinessDetail);

        setBdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoMainLayout=new Intent(businessDetail.this,MainLayout.class);
                startActivity(gotoMainLayout);
            }
        });
    }
}
