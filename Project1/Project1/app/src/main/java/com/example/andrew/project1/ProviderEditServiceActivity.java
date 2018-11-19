package com.example.andrew.project1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ProviderEditServiceActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.andrew.project1.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_edit_service);

        spin2 = (Spinner)findViewById(R.id.ServiceL);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ServiceActivity.serviceNames);
        spin2.setAdapter(adapter2);
    }

    Spinner spin2;
    ArrayAdapter<String> adapter2;

    public void addButton(View view) {
        if (!LoginSignUp.prov.getServices().equals("no services")) {
            for (int a = 0; a < LoginSignUp.prov.numberOfService(); a++) {
                if (LoginSignUp.prov.serviceAt(a).equals(spin2.getSelectedItem().toString())) {
                    Intent data = new Intent();
                    String newService = LoginSignUp.prov.getServices();
                    data.putExtra (EXTRA_REPLY, newService);
                    setResult(RESULT_OK, data);
                    Log.d("ok", "here?");
                    finish();
                    return;
                }
            }

            LoginSignUp.prov.addServices(spin2.getSelectedItem().toString());
            Intent data = new Intent();
            String newService = LoginSignUp.prov.getServices();
            data.putExtra (EXTRA_REPLY, newService);
            setResult(RESULT_OK, data);
            finish();
            Log.d("ok", "here?");

        } else {
            Log.d("ok", "doi");
           ;
//
            LoginSignUp.prov.addServices(spin2.getSelectedItem().toString());
            Intent data = new Intent();
            String newService = LoginSignUp.prov.getServices();
            data.putExtra (EXTRA_REPLY, newService);
            setResult(RESULT_OK, data);
            finish();
//
//            TextView serviceTextView = (TextView) findViewById(R.id.services);
//            String serve = LoginSignUp.prov.getServices();
//            String fullS = "Services: " + serve;
//            serviceTextView.setText(fullS);
        }
    }

//    public void whatever (TextView mTextView){
//
//
//    }
    public void removeButton(View view) {
        if (LoginSignUp.prov.getServices().equals("no services")) {
            Intent data = new Intent();
            String newService = LoginSignUp.prov.getServices();
            data.putExtra (EXTRA_REPLY, newService);
            setResult(RESULT_OK, data);
            finish();
            return;
        } else {
            LoginSignUp.prov.removeServices(spin2.getSelectedItem().toString());
            Intent data = new Intent();
            String newService = LoginSignUp.prov.getServices();
            data.putExtra (EXTRA_REPLY, newService);
            setResult(RESULT_OK, data);
            finish();
            return;
        }
    }
}
