package com.example.resturant_billing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        TextView goLogin=(TextView) findViewById(R.id.gotoLogin);
        AppCompatButton register=(AppCompatButton) findViewById(R.id.SignUpbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerNow=new Intent(registerActivity.this, otpActivity.class);
                startActivity(registerNow);
            }
        });

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(registerActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });



    }
}
