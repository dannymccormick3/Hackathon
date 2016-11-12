package com.hack.hb.buddycar;

/**
 * Created by Harrison on 11/12/16.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Profile")
public class Profile {

    public int ID;

    public String name;

    public int stars;

    public int numRatings;

    public double rating;

    public String bio;

    public int age;

    public String gender;


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

    @DynamoDBIndexRangeKey(attributeName = "ID")
    public int getID(){
        return ID;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName(){
        return name;
    }

    @DynamoDBAttribute(attributeName = "bio")
    public String getBio(){
        return bio;
    }

    @DynamoDBAttribute(attributeName = "age")
    public int getAge(){
        return age;
    }

    @DynamoDBAttribute(attributeName = "gender")
    public String getGender(){
        return gender;
    }

    @DynamoDBAttribute(attributeName = "stars")
    public int getStars(){
        return stars;
    }

    @DynamoDBAttribute(attributeName = "numRatings")
    public int getNumRatings(){
        return numRatings;
    }

    @DynamoDBAttribute(attributeName = "rating")
    public Double getRating(){
        return rating;
    }

}

