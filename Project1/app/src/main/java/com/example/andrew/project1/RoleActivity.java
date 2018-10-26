package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        findViewById(R.id.homeOwnerButton).setOnClickListener(this);
        findViewById(R.id.serviceProviderButton).setOnClickListener(this);
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
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.homeOwnerButton:
                startActivity(new Intent(this, CreateAccountActivity.class));
                break;
            case R.id.serviceProviderButton:
                startActivity(new Intent(this, CreateProviderAccountActivity.class));
                break;
        }
    }
}
