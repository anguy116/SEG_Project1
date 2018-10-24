package com.example.andrew.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class LoginSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
    }

    public void createAccountButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), RoleActivity.class);
        startActivityForResult (intent,0);
    }

    public void logInButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), LoggedInActivity.class);
        startActivityForResult (intent,0);
    }
}
