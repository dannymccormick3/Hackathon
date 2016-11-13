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
        int endtripIDIndex = rsData.indexOf(' ');
        myTripID = rsData.substring(0, endtripIDIndex);

        String IDnum = rsData.substring(endtripIDIndex+1, rsData.length()-1);
        int IDnumIndex =IDnum.indexOf(' ');
        FK_ID =rsData.substring(endtripIDIndex+1, IDnumIndex);

        String startCity = rsData.substring(IDnumIndex+1, rsData.length()-1);
        int startCityIndex =startCity.indexOf(' ');
        myStartCity = rsData.substring(IDnumIndex+1, startCityIndex);

        String endCity = rsData.substring(startCityIndex+1, rsData.length()-1);
        int endCityIndex =endCity.indexOf(' ');
        myEndCity = rsData.substring(startCityIndex+1, endCityIndex);

        String isDriver = rsData.substring(endCityIndex+1, rsData.length()-1);
        int isDriverIndex =isDriver.indexOf(' ');
        String checkDriver = rsData.substring(endCityIndex+1, isDriverIndex);
        myIsDriver = checkDriver.equals("passenger");

        String date = rsData.substring(isDriverIndex+1, rsData.length()-1);
        int dateIndex =date.indexOf(' ');
        myDate = rsData.substring(isDriverIndex+1, dateIndex);
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
            return "yes";
        }else{
            return "no";
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
