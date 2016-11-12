package com.hack.hb.buddycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_ride);
        final Button b = (Button) findViewById(R.id.button8);
    }


    //go to BuddySelect activity.
    public void goBuddySelect (View view) {
        Intent intent = new Intent(this, BuddySelection.class);
        startActivity(intent);
    }




}
