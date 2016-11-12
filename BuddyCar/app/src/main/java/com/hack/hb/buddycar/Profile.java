package com.hack.hb.buddycar;

/**
 * Created by Harrison on 11/12/16.
 */

public class Profile {

    public int id;

    public String name;

    public int stars;

    public int numRatings;

    public double rating;

    public Profile (String profName, int idNum) {
        id = idNum;
        name = profName;
        stars = 0;
        numRatings = 0;
        rating = 0;
    }

    public void modifyRating (int newStars) {
        stars = stars + newStars;
        numRatings++;
        rating = stars / numRatings;
    }

}


