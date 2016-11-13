package com.hack.hb.buddycar;

import android.widget.DatePicker;

/**
 * Created by michaelriley on 11/12/16.
 */


public class RideShare {

    public String myTripID;

    public String FK_ID;

    public String myStartCity;

    public String myEndCity;

    public String myDate;

    boolean myIsDriver;




    //ctor
    public RideShare (String tripId, String FK_Id, String startCity, String endCity, String date,
                      boolean isDriver) {
        myTripID = tripId;
        FK_ID = FK_Id;
        myStartCity = startCity;
        myEndCity = endCity;
        myIsDriver = isDriver;
        myDate = date;

    }




}
