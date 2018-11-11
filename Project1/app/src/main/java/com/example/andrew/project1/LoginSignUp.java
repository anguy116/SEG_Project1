package com.example.andrew.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LoginSignUp extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmailEnter, editTextPasswordEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        findViewById(R.id.createAccountButton).setOnClickListener(this);
        findViewById(R.id.LogIn).setOnClickListener(this);
        editTextEmailEnter = (EditText)findViewById(R.id.EmailEnter);
        editTextPasswordEnter = (EditText)findViewById(R.id.PasswordEnter);
    }

    public void createAccountButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), RoleActivity.class);
        startActivityForResult (intent,0);
    }

    public void logInButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), LoggedInActivity.class);
        startActivityForResult (intent,0);
    }

    public void onClick(View view){
        switch(view.getId()) {
            case R.id.createAccountButton:
                startActivity(new Intent(this, RoleActivity.class));
                break;

            case R.id.LogIn:
                if (verifyUser()){
                    startActivity(new Intent(this, LoggedInActivity.class));
                }

                break;

        }
    }
    private boolean verifyUser(){
        boolean flag = false;
//        Iterator<HomeOwnerUser> itr = UserList.users.iterator();
//        Iterator<ServiceProviderUser> it = UserList.providers.iterator();
        String element = editTextEmailEnter.getText().toString();
        //String company = editTextCompany.getText().toString()
        String pass = editTextPasswordEnter.getText().toString();

        for (int a = 0; a< UserList.users.size();a++){

            if (UserList.users.get(a).getEmail().equals(element)){
                if(!UserList.users.get(a).getPassword().equals(pass)){
                    editTextPasswordEnter.setError("incorrect username or password");
                    editTextPasswordEnter.requestFocus();
                    return false;
                } else {
                    UserList.current = UserList.users.get(a);
                    UserList.welcome = "Welcome "+((HomeOwnerUser) UserList.current).getFirstName()+", you are signed in as a home owner";
                    return true;
                }
            }
        }

        for (int b = 0; b< UserList.providers.size();b++){

            if (UserList.providers.get(b).getEmail().equals(element)){
                if(!UserList.providers.get(b).getPassword().equals(pass)){
                    editTextPasswordEnter.setError("incorrect username or password");
                    editTextPasswordEnter.requestFocus();
                    return false;
                } else {
                    UserList.current = UserList.providers.get(b);
                    UserList.welcome = "Welcome "+((ServiceProviderUser) UserList.current).getName()+", you are signed in as a service provider";
                    return true;
                }
            }
        }

        if (element.equals("admin")){
            if (pass.equals("admin123")){
                UserList.welcome = "You are logged in as admin";

                return true;
            } else {
                return false;
            }
        }


        if (flag == false){
            editTextEmailEnter.setError("incorrect username or password");
            editTextEmailEnter.requestFocus();
            editTextPasswordEnter.requestFocus();

        }

        return flag;
    }
}
