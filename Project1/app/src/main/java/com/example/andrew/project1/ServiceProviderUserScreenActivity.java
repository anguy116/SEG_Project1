package com.example.andrew.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ServiceProviderUserScreenActivity extends AppCompatActivity {
    TextView nameVTextView, addressVTextView, numberVTextView, descriptionVTextView, serviceVTextView, licenseVTextView, ratingVTextView;
    CheckBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_user_screen);

        nameVTextView = (TextView) findViewById(R.id.title);
        String name = LoginSignUp.prov.getName();
        nameVTextView.setText(name);

        addressVTextView = (TextView) findViewById(R.id.address);
        String address = LoginSignUp.prov.getAddress();
        String fullA = "Address: "+ address;
        addressVTextView.setText(fullA);

        numberVTextView = (TextView) findViewById(R.id.phone);
        String phoneN = LoginSignUp.prov.getPhoneNumber();
        String fullP = "Phone: "+phoneN;
        numberVTextView.setText(fullP);

        if (!LoginSignUp.prov.getDescription().equals("")) {
            descriptionVTextView = (TextView) findViewById(R.id.descriptionV);
            descriptionVTextView.setVisibility(View.VISIBLE);
            String fullD = "Description: "+ LoginSignUp.prov.getDescription();
            descriptionVTextView.setText(fullD);
        }

        serviceVTextView = (TextView) findViewById(R.id.servicesV);
        String serve = LoginSignUp.prov.getServices();
        String fullS = "Services: " + serve;
        serviceVTextView.setText(fullS);

        licenseVTextView = (TextView) findViewById(R.id.license);
        if (LoginSignUp.prov.isLicensed()==true){
            String lic = "We are licensed!";
            licenseVTextView.setText(lic);
        } else if (LoginSignUp.prov.isLicensed()==false){
            String lic = "Not licensed";
            licenseVTextView.setText(lic);
        }

        sunday = (CheckBox) findViewById(R.id.sunday);
        sunday.setChecked(LoginSignUp.prov.getAvailable(0));

        monday = (CheckBox) findViewById(R.id.monday);
        monday.setChecked(LoginSignUp.prov.getAvailable(1));

        tuesday = (CheckBox) findViewById(R.id.tuesday);
        tuesday.setChecked(LoginSignUp.prov.getAvailable(2));


        wednesday = (CheckBox) findViewById(R.id.wednesday);
        wednesday.setChecked(LoginSignUp.prov.getAvailable(3));

        thursday = (CheckBox) findViewById(R.id.thursday);
        thursday.setChecked(LoginSignUp.prov.getAvailable(4));

        friday = (CheckBox) findViewById(R.id.friday);
        friday.setChecked(LoginSignUp.prov.getAvailable(5));

        saturday = (CheckBox) findViewById(R.id.saturday);
        saturday.setChecked(LoginSignUp.prov.getAvailable(6));
    }
}
