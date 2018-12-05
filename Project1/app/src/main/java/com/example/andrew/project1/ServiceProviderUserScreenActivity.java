package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceProviderUserScreenActivity extends AppCompatActivity {
    TextView nameVTextView, addressVTextView, numberVTextView, descriptionVTextView, serviceVTextView, licenseVTextView, ratingVTextView;
    Button bookButton;
    CheckBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    Spinner serves1;
    ArrayAdapter<String> adapterService;
    int rated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_user_screen);
        rated = 0;

        serves1 = (Spinner)findViewById(R.id.serviceSpinner);
        adapterService = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LoginSignUp.prov.getServicesProvided());
        serves1.setAdapter(adapterService);

        bookButton = findViewById(R.id.bookV);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book();
            }
        });

        nameVTextView = (TextView) findViewById(R.id.titleV);
        String name = LoginSignUp.prov.getName();
        nameVTextView.setText(name);

        addressVTextView = (TextView) findViewById(R.id.addressV);
        String address = LoginSignUp.prov.getAddress();
        String fullA = "Address: "+ address;
        addressVTextView.setText(fullA);

        numberVTextView = (TextView) findViewById(R.id.phoneV);
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

        licenseVTextView = (TextView) findViewById(R.id.licenseV);
        if (LoginSignUp.prov.isLicensed()==true){
            String lic = "We are licensed!";
            licenseVTextView.setText(lic);
        } else if (LoginSignUp.prov.isLicensed()==false){
            String lic = "Not licensed";
            licenseVTextView.setText(lic);
        }

        ratingVTextView = findViewById(R.id.ratingV);
        String currentRating = "Rating: "+LoginSignUp.prov.getRating();
        ratingVTextView.setText(currentRating);

        sunday = (CheckBox) findViewById(R.id.sundayV);
        sunday.setChecked(LoginSignUp.prov.getAvailable(0));
        if (sunday.isChecked()){
            sunday.setClickable(true);
        }

        monday = (CheckBox) findViewById(R.id.mondayV);
        monday.setChecked(LoginSignUp.prov.getAvailable(1));
        if (monday.isChecked()){
            monday.setClickable(true);
        }

        tuesday = (CheckBox) findViewById(R.id.tuesdayV);
        tuesday.setChecked(LoginSignUp.prov.getAvailable(2));
        if (tuesday.isChecked()){
            tuesday.setClickable(true);
        }


        wednesday = (CheckBox) findViewById(R.id.wednesdayV);
        wednesday.setChecked(LoginSignUp.prov.getAvailable(3));
        if (wednesday.isChecked()){
            wednesday.setClickable(true);
        }

        thursday = (CheckBox) findViewById(R.id.thursdayV);
        thursday.setChecked(LoginSignUp.prov.getAvailable(4));
        if (thursday.isChecked()){
            thursday.setClickable(true);
        }

        friday = (CheckBox) findViewById(R.id.fridayV);
        friday.setChecked(LoginSignUp.prov.getAvailable(5));
        if (friday.isChecked()){
            friday.setClickable(true);
        }

        saturday = (CheckBox) findViewById(R.id.saturdayV);
        saturday.setChecked(LoginSignUp.prov.getAvailable(6));
        if (saturday.isChecked()){
            saturday.setClickable(true);
        }
    }

    private void book(){
        int dayCount = 0;
        String daySelected = "";

        if (sunday.isChecked()){
            dayCount++;
            daySelected = "Sunday";
        }

        if (monday.isChecked()){
            dayCount++;
            daySelected = "Monday";
        }
        if (tuesday.isChecked()){
            dayCount++;
            daySelected = "Tuesday";
        }
        if (wednesday.isChecked()){
            dayCount++;
            daySelected = "Wednesday";
        }
        if (thursday.isChecked()){
            dayCount++;
            daySelected = "Thursday";
        }
        if (friday.isChecked()){
            dayCount++;
            daySelected = "Friday";
        }
        if (saturday.isChecked()){
            dayCount++;
            daySelected = "Saturday";
        }

        if (dayCount==1){
            String companyName=LoginSignUp.prov.getName()+ " booked for: ";
            String booking=companyName+serves1.getSelectedItem().toString()+" on "+ daySelected;
            if (LoginSignUp.home.getBookings().contains(booking)){
                Toast.makeText(getApplicationContext(), "This booking already exists!", Toast.LENGTH_SHORT).show();
            } else{
                LoginSignUp.home.addBooking(booking);
            }
        } else if ((dayCount==0)||(dayCount>1)){
            Toast.makeText(getApplicationContext(), "Please select one day", Toast.LENGTH_SHORT).show();
        }
    }

    public void rateUsButton(View view) {
        //Application Context and Activity
        rated++;

        if (rated==1){
            Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
            startActivityForResult (intent,0);
        } else{
            Toast.makeText(getApplicationContext(), "You can only rate once!", Toast.LENGTH_SHORT).show();
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;
        String reply = data.getStringExtra(RatingActivity.EXTRA_REPLY1);
        ratingVTextView.setText(reply);
    }
}
