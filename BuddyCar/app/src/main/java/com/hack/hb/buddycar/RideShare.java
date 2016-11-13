package com.hack.hb.buddycar;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedQueryList;

import java.util.ArrayList;

/**
 * Created by michaelriley on 11/12/16.
 */

@DynamoDBTable(tableName = "RideShare")
public class RideShare {

    public String ID;

    public String FK_ID;

    public String myStartCity;

    public String myEndCity;

    public String myDate;

    boolean myIsDriver;

    @DynamoDBHashKey(attributeName = "ID")
    public String getID()
    {
        return ID;
    }

    @DynamoDBAttribute(attributeName = "FK_ID")
    public String getFK_ID(){
        return FK_ID;
    }

    @DynamoDBIndexHashKey(attributeName = "myStartCity")
    public String getMyStartCity(){
        return myStartCity;
    }

    @DynamoDBIndexHashKey(attributeName = "myEndCity")
    public String getMyEndCity(){
        return myEndCity;
    }

    @DynamoDBAttribute(attributeName = "myDate")
    public String getMyDate(){
        return myDate;
    }


    //ctor
    public RideShare (String tripId, String FK_Id, String startCity, String endCity, String date,
                      boolean isDriver) {
        ID = tripId;
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
        ID = rsData.substring(0, endtripIDIndex);

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
        return ID;
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
        String toReturn = ID + ' ' + FK_ID + ' ' + myStartCity;
        toReturn = toReturn + ' ' + myEndCity + isDriverToString() + ' ' + myDate;
        return toReturn;
    }

    public String listToString(PaginatedQueryList<RideShare> myList){
        String s = "";
        for (RideShare r: myList) {
            s = r.toString() + "!?n?!";
        }
        return s;
    }
    public ArrayList<RideShare> stringToList(String s){
        ArrayList<RideShare> myRides = new ArrayList<>();
        int index = 0;
        while (s.length() > 0){
            index = s.indexOf("!?n?!");
            RideShare temp = new RideShare(s.substring(0,index-1));
            myRides.add(temp);
            s=s.substring(index + 5);
        }

        return myRides;
    }
}
