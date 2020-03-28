package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAllUsersActivity extends AppCompatActivity implements View.OnClickListener {

    Button usersButton, HelpersButton;
    RecyclerView recyclerView;
    ViewAllUserRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        usersButton = findViewById(R.id.users);
        HelpersButton = findViewById(R.id.helpers);

        usersButton.setOnClickListener(this);
        HelpersButton.setOnClickListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new ViewAllUserRecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.users:
                intent = new Intent(this, ViewAllUsersActivity.class);
                startActivity(intent);
                break;
            case R.id.helpers:
                intent = new Intent(this, ViewAllHelpersActivity.class);
                startActivity(intent);
                break;


        }
    }
}
