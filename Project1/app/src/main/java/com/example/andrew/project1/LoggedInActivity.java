package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        TextView mTextView = (TextView) findViewById(R.id.welcomeScreen);
        mTextView.setText(UserList.welcome);

        if (UserList.welcome.equals("You are logged in as admin")){
            Button services = findViewById(R.id.serviceButton);
            services.setVisibility(View.VISIBLE);
        }

        if (UserList.welcome.contains("service")){
            Button serviceP = findViewById(R.id.serviceProfile);
            serviceP.setVisibility(View.VISIBLE);
        }

        if (UserList.welcome.contains("home")){
            Button search = findViewById(R.id.search);
            search.setVisibility(View.VISIBLE);
            Button bookings = findViewById(R.id.viewBook);
            bookings.setVisibility(View.VISIBLE);
        }
    }

    public void servicesButton(View view){
        Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
        startActivityForResult (intent,0);
    }

    public void spButton(View view){
        Intent intent = new Intent(getApplicationContext(), ServiceProviderScreenActivity.class);
        startActivityForResult (intent,0);
    }

    public void searchButton(View view){
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivityForResult (intent,0);
    }

    public void bookingsButton(View view){
        Intent intent = new Intent(getApplicationContext(), BookingsActivity.class);
        startActivityForResult (intent,0);
    }


}
