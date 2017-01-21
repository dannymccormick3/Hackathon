package com.hack.hb.buddycar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.UUID;

public class InputRide extends AppCompatActivity {

    public final static String START_CITY = "com.hack.hb.buddycar.startCity";
    public final static String END_CITY = "com.hack.hb.buddycar.endCity";
    public final static String DATE = "com.hack.hb.buddycar.myDate";
    public final static String PROFILE = "com.hack.hb.buddycar.profile";
    public final static String RIDESHARE = "com.hack.hb.buddycar.rideshare";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_ride);
        final Button b = (Button) findViewById(R.id.button8);
        final Button c = (Button) findViewById(R.id.button9);
        String profileString = getIntent().getStringExtra("PROFILE");
        if(profileString == null) {
            Log.e("Bad Log message", "I'm a legend");

            profileString = "";
        }
        final String profileStr = profileString;
        Log.e("XXXXXXXXXXXXXXX",profileStr);
        final Profile profile = new Profile(profileStr);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uniqueID = UUID.randomUUID().toString();


                Intent intent = new Intent(InputRide.this, BuddySelection.class);
                EditText startCityText = (EditText) findViewById(R.id.editText8);
                EditText endCityText = (EditText) (findViewById(R.id.editText9));
                DatePicker datePickerTxt = (DatePicker) findViewById(R.id.datePicker);
                String startCityStr = startCityText.getText().toString();
                startCityStr = startCityStr.toLowerCase();
                String endCityStr = endCityText.getText().toString();
                endCityStr = endCityStr.toLowerCase();

                String datePickerStr = dateToString(datePickerTxt);

                RideShare rideShare = new RideShare(uniqueID, profile.getID(), startCityStr, endCityStr,
                        datePickerStr, false);
                String rideShareStr = rideShare.toString();

                intent.putExtra(START_CITY, startCityStr);
                intent.putExtra(END_CITY, endCityStr);
                intent.putExtra(DATE, datePickerStr);
                intent.putExtra(PROFILE, profileStr);

                //RIDESHARE IS THE KEY
                intent.putExtra(RIDESHARE, rideShareStr);

                //create database object
                //call d.hook(Rideshare, intent, getApplicationContext());

                startActivity(intent);
            }
        });

        //COPY ABOVE CODE INTO THIS METHOD
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uniqueID = UUID.randomUUID().toString();


                Intent intent = new Intent(InputRide.this, BuddySelection.class);
                EditText startCityText = (EditText) findViewById(R.id.editText8);
                EditText endCityText = (EditText) (findViewById(R.id.editText9));
                DatePicker datePickerTxt = (DatePicker) findViewById(R.id.datePicker);
                String startCityStr = startCityText.getText().toString();
                startCityStr = startCityStr.toLowerCase();
                String endCityStr = endCityText.getText().toString();
                endCityStr = endCityStr.toLowerCase();

                String datePickerStr = dateToString(datePickerTxt);

                RideShare rideShare = new RideShare(uniqueID, profile.getID(), startCityStr, endCityStr,
                        datePickerStr, false);
                String rideShareStr = rideShare.toString();

                intent.putExtra(START_CITY, startCityStr);
                intent.putExtra(END_CITY, endCityStr);
                intent.putExtra(DATE, datePickerStr);
                intent.putExtra(PROFILE, profileStr);

                //RIDESHARE is the key to everything
                intent.putExtra(RIDESHARE, rideShareStr);

                //create database object
                //call d.hook(Rideshare, intent, getApplicationContext());

                startActivity(intent);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    //go to BuddySelect activity.
    public void goBuddySelect(View view) {
        Intent intent = new Intent(this, BuddySelection.class);
        EditText startCityText = (EditText) findViewById(R.id.editText8);
        EditText endCityText = (EditText) findViewById(R.id.editText9);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        String startCityStr = startCityText.getText().toString();
        String endCityStr = endCityText.getText().toString();
        String date = dateToString(datePicker);
        intent.putExtra(START_CITY, startCityStr);
        intent.putExtra(END_CITY, endCityStr);
        intent.putExtra(DATE, date);
        startActivity(intent);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("InputRide Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public String dateToString (DatePicker datePicker) {
        return datePicker.getMonth() + "-" + datePicker.getDayOfMonth()
                + "-" + datePicker.getYear();
    }
}
