package com.example.andrew.project1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);

        spin = (Spinner)findViewById(R.id.ListOfServices);
        nameTxt = (EditText) findViewById(R.id.nameTxt);
        rateTxt = (EditText) findViewById(R.id.rateTxt);
        createServiceButton = (Button) findViewById(R.id.createServiceButton);
        editButton = (Button) findViewById(R.id.editButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, serviceNames);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nameTxt.setText(serviceNames.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        createServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

    }
    Spinner spin;
    EditText nameTxt, rateTxt;
    Button createServiceButton, editButton, deleteButton;
    ArrayList<String> serviceNames=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public static ArrayList<Services> serviceList=new ArrayList<Services>();

    private void add(){
        String name = nameTxt.getText().toString();
        String rate = rateTxt.getText().toString();
        String nameAndRate = name +" ($" +rate + "/hr)";
        if (name.isEmpty()||!name.matches("[a-zA-Z]+")){
            nameTxt.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter valid name", Toast.LENGTH_SHORT).show();
        } else if (!rate.matches("^[0-9]+$")) {
            rateTxt.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter valid rate", Toast.LENGTH_SHORT).show();
        } else {
            nameTxt.setText("");
            rateTxt.setText("");
            adapter.add(nameAndRate);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
        }

    }

    private void edit(){
        String name = nameTxt.getText().toString();
        String rate = rateTxt.getText().toString();
        String nameAndRate = name +" ($" +rate + "/hr)";
        int position = spin.getSelectedItemPosition();
        if (name.isEmpty()||!name.matches("[a-zA-Z]+")){
            nameTxt.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter valid name", Toast.LENGTH_SHORT).show();
        } else if (!rate.matches("^[0-9]+$")) {
            rateTxt.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter valid rate", Toast.LENGTH_SHORT).show();
        } else if (serviceNames.size() == 0){
            Toast.makeText(getApplicationContext(), "Nothing to edit", Toast.LENGTH_SHORT).show();
        } else {
            adapter.remove(serviceNames.get(position));
            adapter.insert(nameAndRate, position);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Edited", Toast.LENGTH_SHORT).show();
        }
    }

    private void delete(){
        String name = nameTxt.getText().toString();
        String rate = rateTxt.getText().toString();
        String nameAndRate = name +" ($" +rate + "/hr)";
        int position = spin.getSelectedItemPosition();
        if (serviceNames.size() == 0){
            Toast.makeText(getApplicationContext(), "Nothing to delete", Toast.LENGTH_SHORT).show();
        }
        else if (position > -1) {
            adapter.remove(serviceNames.get(position));
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
            nameTxt.setText("");
            rateTxt.setText("");
        }
    }

}
