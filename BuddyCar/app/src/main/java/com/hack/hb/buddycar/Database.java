package com.hack.hb.buddycar;
import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.services.dynamodbv2.model.*;
/**
 * Created by Danny on 11/12/2016.
 */
public class Database {
    CognitoCachingCredentialsProvider credentialsProvider;
    AmazonDynamoDBClient dbClient;
    DynamoDBMapper mapper;
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

    public Profile getProfile(final String ID)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mapper.load(Profile.class, ID);
            }
        }).start();
        return new Profile("a","b",1,"c");
    }

}
