package com.example.andrew.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class RatingActivity extends AppCompatActivity {
    RadioButton one, two, three, four, five;
    public static final String EXTRA_REPLY1 =
            "com.example.andrew.project1.extra.REPLY1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        one = findViewById(R.id.star1);
        two = findViewById(R.id.star2);
        three = findViewById(R.id.star3);
        four = findViewById(R.id.star4);
        five = findViewById(R.id.star5);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneStar();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoStar();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threeStar();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourStar();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fiveStar();
            }
        });
    }

    private void oneStar(){
        LoginSignUp.prov.updateRating(1);
        Intent data = new Intent();
        String newRating =  "Rating: "+LoginSignUp.prov.getRating();
        data.putExtra (EXTRA_REPLY1, newRating);
        setResult(RESULT_OK, data);
        finish();
        return;
    }

    private void twoStar(){
        LoginSignUp.prov.updateRating(2);
        Intent data = new Intent();
        String newRating =  "Rating: "+LoginSignUp.prov.getRating();
        data.putExtra (EXTRA_REPLY1, newRating);
        setResult(RESULT_OK, data);
        finish();
        return;
    }

    private void threeStar(){
        LoginSignUp.prov.updateRating(3);
        Intent data = new Intent();
        String newRating =  "Rating: "+LoginSignUp.prov.getRating();
        data.putExtra (EXTRA_REPLY1, newRating);
        setResult(RESULT_OK, data);
        finish();
        return;
    }

    private void fourStar(){
        LoginSignUp.prov.updateRating(4);
        Intent data = new Intent();
        String newRating =  "Rating: "+LoginSignUp.prov.getRating();
        data.putExtra (EXTRA_REPLY1, newRating);
        setResult(RESULT_OK, data);
        finish();
        return;
    }

    private void fiveStar(){
        LoginSignUp.prov.updateRating(5);
        Intent data = new Intent();
        String newRating =  "Rating: "+LoginSignUp.prov.getRating();
        data.putExtra (EXTRA_REPLY1, newRating);
        setResult(RESULT_OK, data);
        finish();
        return;
    }


}
