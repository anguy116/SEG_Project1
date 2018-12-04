package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    CheckBox rating4, rating3, rating2, rating1, sun, mon, tues, wed, thurs, fri, sat;
    Button filter, viewProfile;

    public static ArrayList<String> searches=new ArrayList<String>();
    public static ArrayList<String> serveList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        serveList.clear();
        for (int a =0; a<ServiceActivity.serviceNames.size(); a++){
            Log.d("name", Integer.toString(ServiceActivity.serviceNames.size()));
            serveList.add(ServiceActivity.serviceNames.get(a));
        }
        serveList.add(0,"ANY");

        serviceSpin = (Spinner)findViewById(R.id.serviceList1);
        adapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serveList);
        serviceSpin.setAdapter(adapters);

        sResultSpin = (Spinner)findViewById(R.id.sResult);
        otherAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, searches);
        sResultSpin.setAdapter(otherAdapter);

        rating4 = (CheckBox) findViewById(R.id.over4);

        rating4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset4();
            }
        });

        rating3 = (CheckBox) findViewById(R.id.over3);

        rating3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset3();
            }
        });

        rating2 = (CheckBox) findViewById(R.id.over2);

        rating2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset2();
            }
        });

        rating1 = (CheckBox) findViewById(R.id.over1);

        rating1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset1();
            }
        });

        sun = findViewById(R.id.sunday);
        mon = findViewById(R.id.monday);
        tues = findViewById(R.id.tuesday);
        wed = findViewById(R.id.wednesday);
        thurs = findViewById(R.id.thursday);
        fri = findViewById(R.id.friday);
        sat = findViewById(R.id.saturday);

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        tues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        thurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRatingUnclickable();
            }
        });


        filter = findViewById(R.id.filterResults);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterAll();
            }
        });
        viewProfile = findViewById(R.id.viewProfile);
    }
    Spinner serviceSpin, sResultSpin;
    ArrayAdapter<String> adapters, otherAdapter;

    private void makeDaysUnclickable(){
        sun.setEnabled(false);
        mon.setEnabled(false);
        tues.setEnabled(false);
        wed.setEnabled(false);
        thurs.setEnabled(false);
        fri.setEnabled(false);
        sat.setEnabled(false);
    }

    private void makeRatingUnclickable(){
        if (sun.isChecked()||mon.isChecked()||tues.isChecked()||wed.isChecked()||thurs.isChecked()||fri.isChecked()||sat.isChecked()){
            rating1.setEnabled(false);
            rating2.setEnabled(false);
            rating3.setEnabled(false);
            rating4.setEnabled(false);
        } else {
            rating1.setEnabled(true);
            rating2.setEnabled(true);
            rating3.setEnabled(true);
            rating4.setEnabled(true);
        }
    }

    private void reset4(){

        if (rating4.isChecked()){
            rating1.setChecked(false);
            rating2.setChecked(false);
            rating3.setChecked(false);
        }
        makeDaysUnclickable();
    }

    private void reset3(){

        if (rating3.isChecked()){
            rating1.setChecked(false);
            rating2.setChecked(false);
            rating4.setChecked(false);
        }
        makeDaysUnclickable();
    }

    private void reset2(){

        if (rating2.isChecked()){
            rating1.setChecked(false);
            rating4.setChecked(false);
            rating3.setChecked(false);
        }
        makeDaysUnclickable();
    }

    private void reset1(){

        if (rating1.isChecked()){
            rating4.setChecked(false);
            rating2.setChecked(false);
            rating3.setChecked(false);
        }
        makeDaysUnclickable();
    }

    public void viewProfileButton(View view) {
        String selected = sResultSpin.getSelectedItem().toString();
        for (int a =0; a < UserList.providers.size(); a++){
            if (UserList.providers.get(a).getName().equals(selected)){
                LoginSignUp.prov = UserList.providers.get(a);
                //Log.d("this shouldn't be wrong", LoginSignUp.prov.getName());
            }
        }

        Intent intent = new Intent(getApplicationContext(), ServiceProviderUserScreenActivity.class);
        startActivityForResult (intent,0);
    }

    private void filterAll(){
        searches.clear();

        if ((rating1.isEnabled())||rating2.isEnabled()||rating3.isEnabled()||rating4.isEnabled()){
            if (rating1.isChecked()){
                for (int a=0; a < UserList.providers.size(); a++){
                    double rating;
                    rating = UserList.providers.get(a).getRating();
                    if (rating >= 1){
                        if (!searches.contains(UserList.providers.get(a).getName())){
                            otherAdapter.add(UserList.providers.get(a).getName());
                        }
                    }
                }
            } else if (rating2.isChecked()) {
                for (int b = 0; b < UserList.providers.size(); b++) {
                    double rating1;
                    rating1 = UserList.providers.get(b).getRating();
                    if (rating1 >= 2) {
                        if (!searches.contains(UserList.providers.get(b).getName())){
                            otherAdapter.add(UserList.providers.get(b).getName());
                        }

                    }
                }

            } else if (rating3.isChecked()){
                for (int c=0; c < UserList.providers.size(); c++){
                    double rating2;
                    rating2 = UserList.providers.get(c).getRating();
                    if (rating2 >= 3){
                        if (!searches.contains(UserList.providers.get(c).getName())){
                            otherAdapter.add(UserList.providers.get(c).getName());
                        }

                    }
                }

            } else if (rating4.isChecked()){
                for (int d=0; d < UserList.providers.size(); d++){
                    double rating3;
                    rating3 = UserList.providers.get(d).getRating();
                    if (rating3 >= 4){
                        if (!searches.contains(UserList.providers.get(d).getName())){
                            otherAdapter.add(UserList.providers.get(d).getName());
                        }
                    }
                }
            }
        }



        if (sun.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(0)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }

                }
            }
        }
        if (mon.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(1)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }
        if (tues.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(2)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }
        if (wed.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(3)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }
        if (thurs.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(4)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }
        if (fri.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(5)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }
        if (sat.isChecked()){
            for (int a=0; a < UserList.providers.size(); a++){
                if (UserList.providers.get(a).getAvailable(6)){
                    if (!searches.contains(UserList.providers.get(a).getName())){
                        otherAdapter.add(UserList.providers.get(a).getName());
                    }
                }
            }
        }

        otherAdapter.notifyDataSetChanged();
        if (searches.isEmpty()){
            Toast.makeText(getApplicationContext(), "No Results Found", Toast.LENGTH_SHORT).show();
        } else {
            sResultSpin.setVisibility(View.VISIBLE);
            viewProfile.setVisibility(View.VISIBLE);
        }

    }
}


