package com.hack.hb.buddycar;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 11/12/2016.
 */
public class Database {
    CognitoCachingCredentialsProvider credentialsProvider;
    AmazonDynamoDBClient dbClient;
    DynamoDBMapper mapper;
    Profile p = null;
    public Database(Context context){
        credentialsProvider = new CognitoCachingCredentialsProvider(
                context,
                "us-east-1:d28ef10c-29bc-42c9-ab9d-c58833c28336", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );
        dbClient = new AmazonDynamoDBAsyncClient(credentialsProvider);
        mapper = new DynamoDBMapper(dbClient);
    }

    public void saveProfile(final Profile p){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mapper.save(p);
            }
        }).start();
    }

    public void saveRideShare(final RideShare r){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mapper.save(r);
            }
        }).start();
    }

    public void getProfile(final Application a, final String ID, final Intent intent)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Profile p = mapper.load(Profile.class,ID);
                Intent i = intent;
                //TODO - Change p to parsed object
                i.putExtra("PROFILE",p.toString());
                a.startActivity(i);
            }
        }).start();
    }

    public void getRideShares(final Application a, final Intent intent, final RideShare rideshare){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String,String> myMap = new HashMap<String, String>();
                myMap.put("myStartCity",rideshare.myStartCity);
                myMap.put("myEndCity",rideshare.myEndCity);

                DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                        .withExpressionAttributeNames(myMap);
                PaginatedQueryList<RideShare> results = mapper.query(RideShare.class,queryExpression);
                Intent i = intent;

                a.startActivity(i);

            }
        }).start();
    }

}
