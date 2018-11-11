package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddService extends AppCompatActivity {
    EditText editTextNameOfNewService, editTextRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        editTextNameOfNewService = (EditText)findViewById(R.id.nameOfNewService);
        editTextRate = (EditText)findViewById(R.id.rateOfNewService);
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.saveInfo:
                if (registerService()){
                    startActivity(new Intent(this, ServiceActivity.class));
                }
                break;
        }
    }

    public void confirmNewButton(View view){
        Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
        startActivityForResult (intent,0);
    }

    public boolean registerService(){
        boolean validS = true;
        String nameOfService = editTextNameOfNewService.getText().toString().trim();
        String rate = editTextRate.getText().toString().trim();
        int correctRate = Integer.parseInt(rate);

        if (nameOfService.isEmpty()){
            editTextNameOfNewService.setError("First name is required");
            editTextNameOfNewService.requestFocus();
            validS = false;
        }

        if (!nameOfService.matches("[a-zA-Z]+")) {
            editTextNameOfNewService.setError("Service name must be valid");
            editTextNameOfNewService.requestFocus();
            validS = false;
        }

        if (correctRate < 1){
            editTextRate.setError("Rate must be greater than 0");
            editTextRate.requestFocus();
            validS = false;

        }

//        if (validS == true){
//            Services newService = new Services(nameOfService, correctRate);
//            ServiceActivity.serviceList.add(newService);
//            ServiceActivity.serviceNames.add(nameOfService);
//        }


        return validS;
    }
}
