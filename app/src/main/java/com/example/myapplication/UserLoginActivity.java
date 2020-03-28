package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView registerButton;
    Button loginButton;
    TextView phoneText;
    TextView passText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerButton = findViewById(R.id.register);
        loginButton = findViewById(R.id.loginButton);
        phoneText=findViewById(R.id.phoneText);
        passText=findViewById(R.id.passText);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.loginButton:
                intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;

            case R.id.register:
                intent= new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
