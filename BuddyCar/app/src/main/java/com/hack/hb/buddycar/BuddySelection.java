package com.hack.hb.buddycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class BuddySelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_selection);

        String rideshareStr = getIntent().getStringExtra("RIDESHARE");
/*        //RideShare myRideShare = rideshareStr.toString();

        //boolean isDriver = myRideShare.isDriverToString == "driver";

        if (isDriver) {
            //Display database stuff that is only riders
        } else {
            //display database stuff that is only drivers
        }





*/
    }

    public boolean ridesAvailable(Profile[] ridesList) {
        if (ridesList == null) {
            return false;
        }
        for (Profile P: ridesList) {
            Button newButton = new Button(this);
        }
        return true;
    }
}
