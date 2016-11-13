package com.hack.hb.buddycar;

/**
 * Created by Harrison on 11/12/16.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Profile")
public class Profile {

    public String ID;

    public String name;

    public int stars;

    public int numRatings;

    public double rating;

    public String bio;

    public int age;

    public String gender;

    public Profile(){

    }

    public Profile (String profName, String profBio, int profAge, String profGender) {
        name = profName;
        bio = profBio;
        age = profAge;
        gender = profGender;
        stars = 0;
        numRatings = 0;
        rating = 0;
    }

    public void modifyRating (int newStars) {
        stars = stars + newStars;
        numRatings++;
        if(numRatings == 0){
            rating = 0;
        }else {
            rating = stars / numRatings;
        }
    }

    @DynamoDBHashKey(attributeName = "ID")
    public String getID(){
        return ID;
    }

    public void setID(String mID){
        ID = mID;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName(){
        return name;
    }

    public void setName(String mName){
        name = mName;
    }

    @DynamoDBAttribute(attributeName = "bio")
    public String getBio(){
        return bio;
    }

    public void setBio(String mBio){
        bio = mBio;
    }

    @DynamoDBAttribute(attributeName = "age")
    public int getAge(){
        return age;
    }

    public void setAge(int mAge){
        age = mAge;
    }

    @DynamoDBAttribute(attributeName = "gender")
    public String getGender(){
        return gender;
    }

    public void setGender(String mGender){
        gender = mGender;
    }

    @DynamoDBAttribute(attributeName = "stars")
    public int getStars(){
        return stars;
    }

    public void setStars(int mStars){
        stars = mStars;
    }

    @DynamoDBAttribute(attributeName = "numRatings")
    public int getNumRatings(){
        return numRatings;
    }

    public void setNumRatings(int mNumRatings){
        numRatings = mNumRatings;
    }

    @DynamoDBAttribute(attributeName = "rating")
    public Double getRating(){
        return rating;
    }

    public void setRating(Double mRating){
        rating = mRating;
    }

}

