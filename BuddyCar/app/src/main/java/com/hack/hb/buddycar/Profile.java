package com.hack.hb.buddycar;

/**
 * Created by Harrison on 11/12/16.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Profile")
public class Profile {

    public String ID;

    public String name;

    public double rating;

    public int numRatings;

    public String bio;

    public int age;

    public String gender;

    public Profile(){

    }
    //Constructor
    Profile(String profName, String profBio, int profAge, String profGender) {
        name = profName;
        bio = profBio;
        age = profAge;
        gender = profGender;

        numRatings = 0;
        rating = 0;
    }

    //Alt Constructor
    //Pre: The data must be in the order as follows, with only spaces in between
    //ID name rating numRatings bio age gender
    Profile(String profileData){
        int endIDIndex = profileData.indexOf(' ');
        ID = profileData.substring(0, endIDIndex);

        String endName = profileData.substring(endIDIndex+1, profileData.length()-1);
        int endNameIndex =endName.indexOf(' ');
        name = profileData.substring(endIDIndex+1, endNameIndex);

        String endRating = profileData.substring(endNameIndex+1, profileData.length()-1);
        int endRatingIndex =endRating.indexOf(' ');
        rating = Double.parseDouble(profileData.substring(endNameIndex+1, endRatingIndex));

        String endNumRatings = profileData.substring(endRatingIndex+1, profileData.length()-1);
        int endNumRatingsIndex =endNumRatings.indexOf(' ');
        numRatings = Integer.parseInt(profileData.substring(endRatingIndex+1, endNumRatingsIndex));

        String endBio = profileData.substring(endNumRatingsIndex+1, profileData.length()-1);
        int endBioIndex =endBio.indexOf(' ');
        bio = profileData.substring(endNumRatingsIndex+1, endBioIndex);

        String endAge = profileData.substring(endBioIndex+1, profileData.length()-1);
        int endAgeIndex =endAge.indexOf(' ');
        age = Integer.parseInt(profileData.substring(endBioIndex+1, endAgeIndex));

        String endGender = profileData.substring(endAgeIndex+1, profileData.length()-1);
        int endGenderIndex =endGender.indexOf(' ');
        gender = profileData.substring(endAgeIndex+1, endGenderIndex);
    }


    public void modifyRating (int newStars) {
        rating = rating + newStars;
        numRatings++;
        rating = rating / numRatings;
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

    public String IDtoString(){return ID;}

    public String nameToString(){return name;}

    public String ratingToString(){return rating + "";}

    public String numRatingsToString(){return numRatings+"";}

    public String bioToString(){return bio;}

    public String ageToString(){return age+"";}

    public String genderToString(){return gender;}

    public String toString(){
        String toBeReturned = IDtoString() + ' ';
        toBeReturned = toBeReturned + nameToString() + ' ';
        toBeReturned = toBeReturned + ratingToString() + ' ';
        toBeReturned = toBeReturned + numRatingsToString() + ' ';
        toBeReturned = toBeReturned + bioToString() + ' ';
        toBeReturned = toBeReturned + ageToString() + ' ';
        toBeReturned = toBeReturned + genderToString();
        return toBeReturned;
    }

}

