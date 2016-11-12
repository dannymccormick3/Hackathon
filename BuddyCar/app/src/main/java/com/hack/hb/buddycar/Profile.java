package com.hack.hb.buddycar;

/**
 * Created by Harrison on 11/12/16.
 */

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


}

