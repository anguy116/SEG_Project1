package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextFirstName, editTextLastName, editTextPhone, editTextAddress, editTextEmail, editTextPassword, editTextConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        findViewById(R.id.saveInfo).setOnClickListener(this);
        editTextFirstName = (EditText)findViewById(R.id.accountCreation);
        editTextLastName = (EditText)findViewById(R.id.lastName);
        editTextPhone = (EditText)findViewById(R.id.phoneNumber);
        editTextAddress = (EditText)findViewById(R.id.address);
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
        boolean validUser = true;
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        if (firstName.isEmpty()){
            editTextFirstName.setError("First name is required");
            editTextFirstName.requestFocus();
            validUser = false;
        }
        if (!firstName.matches("[a-zA-Z]+")) {
            editTextFirstName.setError("First name must be valid");
            editTextFirstName.requestFocus();
            validUser = false;
        }
        if (lastName.isEmpty()){
            editTextLastName.setError("Last name is required");
            editTextLastName.requestFocus();
            validUser = false;
        }
        if (!lastName.matches("[a-zA-Z]+")) {
            editTextLastName.setError("Last name must be valid");
            editTextLastName.requestFocus();
            validUser = false;
        }
        if (phone.isEmpty()){
            editTextPhone.setError("Phone number is required");
            editTextPhone.requestFocus();
            validUser = false;
        }
        if (!phone.matches("^[0-9]+$")) {
            editTextPhone.setError("Phone number must be valid");
            editTextPhone.requestFocus();
            validUser = false;
        }
        if (address.isEmpty()){
            editTextAddress.setError("Address is required");
            editTextAddress.requestFocus();
            validUser = false;
        }
        if (address.matches("^([A-Za-z]|[0-9])+$")){
            editTextAddress.setError("Address must be valid");
            editTextAddress.requestFocus();
            validUser = false;
        }
        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            validUser = false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email must be valid");
            editTextEmail.requestFocus();
            validUser = false;
        }
        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            validUser = false;
        }
        if (!password.equals(confirmPassword)){
            editTextConfirmPassword.setError("Passwords must match");
            editTextConfirmPassword.requestFocus();
            validUser = false;
        }

        if (validUser == true){
            HomeOwnerUser newComp = new HomeOwnerUser(email, password, firstName, lastName, address, phone);
            UserList.users.add(newComp);
        }

        return validUser;
    }
}
