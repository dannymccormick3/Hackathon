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

    //Alt Constructor
    //Pre: The data must be in the order as follows, with only spaces in between
    //myTripId FK_ID myStartCity myEndCity isDriverToString() myDate
    RideShare(String rsData){
        int endtripIDIndex = rsData.indexOf("?-?");
        myTripID = rsData.substring(0, endtripIDIndex);

        String IDnum = rsData.substring(endtripIDIndex+3, rsData.length()-3);
        int IDnumIndex =IDnum.indexOf("?-?");
        FK_ID =rsData.substring(endtripIDIndex+3, IDnumIndex);

        String startCity = rsData.substring(IDnumIndex+3, rsData.length()-3);
        int startCityIndex =startCity.indexOf("?-?");
        myStartCity = rsData.substring(IDnumIndex+3, startCityIndex);

        String endCity = rsData.substring(startCityIndex+3, rsData.length()-3);
        int endCityIndex =endCity.indexOf("?-?");
        myEndCity = rsData.substring(startCityIndex+3, endCityIndex);

        String isDriver = rsData.substring(endCityIndex+3, rsData.length()-3);
        int isDriverIndex =isDriver.indexOf("?-?");
        String checkDriver = rsData.substring(endCityIndex+3, isDriverIndex);
        myIsDriver = checkDriver.equals("passenger");

        String date = rsData.substring(isDriverIndex+3, rsData.length()-3);
        int dateIndex =date.indexOf("?-?");
        myDate = rsData.substring(isDriverIndex+3, dateIndex);
    }

    public String myTripIDtoString(){
        return myTripID;
    }
    public String FK_IDtoString(){
        return FK_ID;
    }
    public String startToString(){
        return myStartCity;
    }
    public String endToString(){
        return myEndCity;
    }
    public String isDriverToString(){
        if(myIsDriver){
            return "driver";
        }else{
            return "passenger";
        }
    }
    public String dateToString(){
        return myDate;
    }

    public String toString(){
        String toReturn = myTripID + ' ' + FK_ID + ' ' + myStartCity;
        toReturn = toReturn + ' ' + myEndCity + isDriverToString() + ' ' + myDate;
        return toReturn;
    }



}
