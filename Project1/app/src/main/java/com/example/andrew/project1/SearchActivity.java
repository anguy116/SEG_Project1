package com.example.andrew.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    CheckBox rating4, rating3, rating2, rating1;
    Button filter;
    public static ArrayList<String> searches=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        serviceSpin = (Spinner)findViewById(R.id.serviceList);
        adapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ServiceActivity.serviceNames);
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

        filter = findViewById(R.id.filterResults);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterAll();
            }
        });
    }
    Spinner serviceSpin, sResultSpin;
    ArrayAdapter<String> adapters, otherAdapter;

    private void reset4(){

        if (rating4.isChecked()){
            rating1.setChecked(false);
            rating2.setChecked(false);
            rating3.setChecked(false);
        }
    }

    private void reset3(){

        if (rating3.isChecked()){
            rating1.setChecked(false);
            rating2.setChecked(false);
            rating4.setChecked(false);
        }
    }

    private void reset2(){

        if (rating2.isChecked()){
            rating1.setChecked(false);
            rating4.setChecked(false);
            rating3.setChecked(false);
        }
    }

    private void reset1(){

        if (rating1.isChecked()){
            rating4.setChecked(false);
            rating2.setChecked(false);
            rating3.setChecked(false);
        }
    }

    private void filterAll(){
        //yeet
    }
}


