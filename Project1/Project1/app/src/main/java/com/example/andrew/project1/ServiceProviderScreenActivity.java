package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceProviderScreenActivity extends AppCompatActivity {
    TextView nameTextView, addressTextView, numberTextView, descriptionTextView, serviceTextView;
    public static final String EXTRA_MESSAGE =
            "com.example.andrew.project1.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_screen);

        nameTextView = (TextView) findViewById(R.id.title);
        String name = LoginSignUp.prov.getName();
        nameTextView.setText(name);

        addressTextView = (TextView) findViewById(R.id.address);
        String address = LoginSignUp.prov.getAddress();
        String fullA = "Address: "+ address;
        addressTextView.setText(fullA);

        numberTextView = (TextView) findViewById(R.id.phone);
        String phoneN = LoginSignUp.prov.getPhoneNumber();
        String fullP = "Phone: "+phoneN;
        numberTextView.setText(fullP);

        if (!LoginSignUp.prov.getDescription().equals("")) {
            descriptionTextView = (TextView) findViewById(R.id.description);
            descriptionTextView.setVisibility(View.VISIBLE);
            String fullD = "Description: "+ LoginSignUp.prov.getDescription();
            descriptionTextView.setText(fullD);
        }

        serviceTextView = (TextView) findViewById(R.id.services);
        String serve = LoginSignUp.prov.getServices();
        String fullS = "Services: " + serve;
        serviceTextView.setText(fullS);

    }

    public void editServicesButton(View view){
        Intent intent = new Intent(getApplicationContext(), ProviderEditServiceActivity.class);
        //String message = serviceTextView.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult (intent,0);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView service = (TextView) findViewById(R.id.services);
        String reply = data.getStringExtra(ProviderEditServiceActivity.EXTRA_REPLY);
        service.setText(reply);
    }
}
