package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceProviderScreenActivity extends AppCompatActivity {
    TextView nameTextView, addressTextView, numberTextView, descriptionTextView, serviceTextView, licenseTextView;
    CheckBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    Space tempSpace;
    public static final String EXTRA_MESSAGE =
            "com.example.andrew.project1.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_screen);

        tempSpace = findViewById(R.id.tempSpace);

        nameTextView = (TextView) findViewById(R.id.title);
        String name = LoginSignUp.prov.getName();
        nameTextView.setText(name);

        addressTextView = (TextView) findViewById(R.id.address);
        String address = LoginSignUp.prov.getAddress();
        String fullA = "Address: "+ address;
        addressTextView.setText(fullA);

        numberTextView = (TextView) findViewById(R.id.phone);
        String phoneN = LoginSignUp.prov.getPhoneNumber();
        String fullP = "Phone: "+ phoneN;
        numberTextView.setText(fullP);

        if (!LoginSignUp.prov.getDescription().equals("")) {
            descriptionTextView = (TextView) findViewById(R.id.description);
            descriptionTextView.setVisibility(View.VISIBLE);
            tempSpace.setVisibility(View.VISIBLE);
            String fullD = "Description: "+ LoginSignUp.prov.getDescription();
            descriptionTextView.setText(fullD);
        }

        serviceTextView = (TextView) findViewById(R.id.services);
        String serve = LoginSignUp.prov.getServices();
        String fullS = "Services: " + serve;
        serviceTextView.setText(fullS);

        licenseTextView = (TextView) findViewById(R.id.license);
        if (LoginSignUp.prov.isLicensed()){
            String lic = "We are licensed!";
            licenseTextView.setText(lic);
        } else if (!LoginSignUp.prov.isLicensed()){
            String lic = "Not licensed";
            licenseTextView.setText(lic);
        }

        sunday = (CheckBox) findViewById(R.id.sunday);
        sunday.setChecked(LoginSignUp.prov.getAvailable(0));
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSunday();
            }
        });

        monday = (CheckBox) findViewById(R.id.monday);
        monday.setChecked(LoginSignUp.prov.getAvailable(1));
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMonday();
            }
        });

        tuesday = (CheckBox) findViewById(R.id.tuesday);
        tuesday.setChecked(LoginSignUp.prov.getAvailable(2));
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTuesday();
            }
        });


        wednesday = (CheckBox) findViewById(R.id.wednesday);
        wednesday.setChecked(LoginSignUp.prov.getAvailable(3));
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWednesday();
            }
        });

        thursday = (CheckBox) findViewById(R.id.thursday);
        thursday.setChecked(LoginSignUp.prov.getAvailable(4));
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addThursday();
            }
        });

        friday = (CheckBox) findViewById(R.id.friday);
        friday.setChecked(LoginSignUp.prov.getAvailable(5));
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriday();
            }
        });

        saturday = (CheckBox) findViewById(R.id.saturday);
        saturday.setChecked(LoginSignUp.prov.getAvailable(6));
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSaturday();
            }
        });

    }

    public void editServicesButton(View view){
        Intent intent = new Intent(getApplicationContext(), ProviderEditServiceActivity.class);
        //String message = serviceTextView.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult (intent,0);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        TextView service = (TextView) findViewById(R.id.services);
        String reply = data.getStringExtra(ProviderEditServiceActivity.EXTRA_REPLY);
        service.setText(reply);
    }

    private void addSunday(){

        if (sunday.isChecked()){
            sunday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,0);
        } else if (!sunday.isChecked()) {
            sunday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,0);
        }
    }

    private void addMonday(){

        if (monday.isChecked()){
            monday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,1);
        } else if (!monday.isChecked()) {
            monday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,1);
        }
    }

    private void addTuesday(){

        if (tuesday.isChecked()){
            tuesday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,2);
        } else if (!tuesday.isChecked()) {
            tuesday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,2);
        }
    }

    private void addWednesday(){

        if (wednesday.isChecked()){
            wednesday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,3);
        } else if (!wednesday.isChecked()) {
            wednesday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,3);
        }
    }

    private void addThursday(){

        if (thursday.isChecked()){
            thursday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,4);
        } else if (!thursday.isChecked()) {
            thursday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,4);
        }
    }

    private void addFriday(){

        if (friday.isChecked()){
            friday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,5);
        } else if (!friday.isChecked()) {
            friday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,5);
        }
    }

    private void addSaturday(){

        if (saturday.isChecked()){
            saturday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(true,6);
        } else if (!saturday.isChecked()) {
            saturday.requestFocus();
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            LoginSignUp.prov.setAvailable(false,6);
        }
    }
}
