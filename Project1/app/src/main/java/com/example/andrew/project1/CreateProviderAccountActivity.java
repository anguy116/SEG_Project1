package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CreateProviderAccountActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextCompany, editTextPhone, editTextEmail, editTextPassword, editTextConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_provider_account);
        findViewById(R.id.saveInfo).setOnClickListener(this);
        editTextCompany = (EditText)findViewById(R.id.companyName);
        editTextPhone = (EditText)findViewById(R.id.phoneNumber);
        editTextEmail = (EditText)findViewById(R.id.email);
        editTextPassword = (EditText)findViewById(R.id.password);
        editTextConfirmPassword = (EditText)findViewById(R.id.confirmPassword);
    }
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.saveInfo:
                if (registerUser()){

                    startActivity(new Intent(this, LoggedInActivity.class));
                }

                break;
        }
    }

    private boolean registerUser() {
        boolean validCompany = true;
        String company = editTextCompany.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();


        if (company.isEmpty()){
            editTextCompany.setError("Company name is required");
            editTextCompany.requestFocus();
            validCompany = false;
        }
        if (phone.isEmpty()){
            editTextPhone.setError("Phone number is required");
            editTextPhone.requestFocus();
            validCompany = false;
        }
        if (!phone.matches("^[0-9]+$")) {
            editTextPhone.setError("Phone number must be valid");
            editTextPhone.requestFocus();
            validCompany = false;
        }
        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            validCompany = false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email must be valid");
            editTextEmail.requestFocus();
            validCompany = false;
        }
        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            validCompany = false;
        }
        if (!password.equals(confirmPassword)){
            editTextConfirmPassword.setError("Passwords must match");
            editTextConfirmPassword.requestFocus();
            validCompany = false;
        }

        if (validCompany == true){
            ServiceProviderUser newComp = new ServiceProviderUser(email, password, company, phone);
            UserList.providers.add(newComp);
            UserList.welcome = "Welcome "+newComp.getName()+", you are signed in as a service provider";
        }

        return validCompany;
    }
}
