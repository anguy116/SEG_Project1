package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
    }

    public void homeOwnerButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
        startActivityForResult (intent,0);
    }

    public void providerButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), CreateProviderAccountActivity.class);
        startActivityForResult (intent,0);
    }
}
