package com.example.andrew.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        if (LoginSignUp.home.emptyBookings()) {
            TextView noBooking = findViewById(R.id.booking1);
            noBooking.setVisibility(View.VISIBLE);
        } else if (LoginSignUp.home.bookingSize() == 1) {
            TextView booking = findViewById(R.id.booking2);
            booking.setVisibility(View.VISIBLE);
            String book1 = LoginSignUp.home.bookingNumber(0);
            booking.setText(book1);
        } else if (LoginSignUp.home.bookingSize() == 2) {
            TextView booking = findViewById(R.id.booking2);
            booking.setVisibility(View.VISIBLE);
            String book1 = LoginSignUp.home.bookingNumber(0);
            booking.setText(book1);

            TextView booking1 = findViewById(R.id.booking3);
            booking1.setVisibility(View.VISIBLE);
            String book2 = LoginSignUp.home.bookingNumber(1);
            booking1.setText(book2);

        } else if (LoginSignUp.home.bookingSize() == 3) {
            TextView booking = findViewById(R.id.booking2);
            booking.setVisibility(View.VISIBLE);
            String book1 = LoginSignUp.home.bookingNumber(0);
            booking.setText(book1);

            TextView booking1 = findViewById(R.id.booking3);
            booking1.setVisibility(View.VISIBLE);
            String book2 = LoginSignUp.home.bookingNumber(1);
            booking1.setText(book2);

            TextView booking2 = findViewById(R.id.booking4);
            booking2.setVisibility(View.VISIBLE);
            String book3 = LoginSignUp.home.bookingNumber(2);
            booking2.setText(book3);
        } else if (LoginSignUp.home.bookingSize() == 4) {
            TextView booking = findViewById(R.id.booking2);
            booking.setVisibility(View.VISIBLE);
            String book1 = LoginSignUp.home.bookingNumber(0);
            booking.setText(book1);

            TextView booking1 = findViewById(R.id.booking3);
            booking1.setVisibility(View.VISIBLE);
            String book2 = LoginSignUp.home.bookingNumber(1);
            booking1.setText(book2);

            TextView booking2 = findViewById(R.id.booking4);
            booking2.setVisibility(View.VISIBLE);
            String book3 = LoginSignUp.home.bookingNumber(2);
            booking2.setText(book3);

            TextView booking3 = findViewById(R.id.booking5);
            booking3.setVisibility(View.VISIBLE);
            String book4 = LoginSignUp.home.bookingNumber(3);
            booking3.setText(book4);
        } else if (LoginSignUp.home.bookingSize() == 5) {
            TextView booking = findViewById(R.id.booking2);
            booking.setVisibility(View.VISIBLE);
            String book1 = LoginSignUp.home.bookingNumber(0);
            booking.setText(book1);

            TextView booking1 = findViewById(R.id.booking3);
            booking1.setVisibility(View.VISIBLE);
            String book2 = LoginSignUp.home.bookingNumber(1);
            booking1.setText(book2);

            TextView booking2 = findViewById(R.id.booking4);
            booking2.setVisibility(View.VISIBLE);
            String book3 = LoginSignUp.home.bookingNumber(2);
            booking2.setText(book3);

            TextView booking3 = findViewById(R.id.booking5);
            booking3.setVisibility(View.VISIBLE);
            String book4 = LoginSignUp.home.bookingNumber(3);
            booking3.setText(book4);

            TextView booking4 = findViewById(R.id.booking6);
            booking4.setVisibility(View.VISIBLE);
            String book5 = LoginSignUp.home.bookingNumber(4);
            booking4.setText(book5);
        }
    }
}