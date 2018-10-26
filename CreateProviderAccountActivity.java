package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class CreateProviderAccountActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextCompany, editTextPhone, editTextEmail, editTextPassword, editTextConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_provider_account);
        editTextCompany = (EditText)findViewById(R.id.companyName);
        editTextPhone = (EditText)findViewById(R.id.phoneNumber);
        editTextEmail = (EditText)findViewById(R.id.email);
        editTextPassword = (EditText)findViewById(R.id.password);
        editTextConfirmPassword = (EditText)findViewById(R.id.confirmPassword);
    }
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.saveInfo:
                registerUser();
                startActivity(new Intent(this, LoggedInActivity.class));
                break;
        }
    }
    private void registerUser() {
        String company = editTextCompany.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        if (company.isEmpty()){
            editTextCompany.setError("Company name is required");
            editTextCompany.requestFocus();
            return;
        }
        if (phone.isEmpty()){
            editTextPhone.setError("Phone number is required");
            editTextPhone.requestFocus();
            return;
        }
        if (!phone.matches("^[0-9]+$")) {
            editTextPhone.setError("Phone number must be valid");
            editTextPhone.requestFocus();
            return;
        }
        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email must be valid");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (!password.equals(confirmPassword)){
            editTextConfirmPassword.setError("Passwords must match");
            editTextConfirmPassword.requestFocus();
            return;
        }
    }
}
