package com.hack.hb.buddycar;
import android.content.Context;
import android.util.Log;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.util.List;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;

/**
 * Created by Danny on 11/12/2016.
 */
public class Database {


    private MobileServiceClient mClient;
    private Context context;

    public Database(Context mContext){
        context = mContext;
        try {
            mClient = new MobileServiceClient("https://buddycar.azurewebsites.net", mContext);
        }
        catch (Exception ex){
            Log.e("EXCEPTION",ex.toString());
        }
    }

    public void saveRideShare(RideShare r){
        mClient.getTable(RideShare.class).insert(r, new TableOperationCallback<RideShare>() {
            @Override
            public void onCompleted(RideShare entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                    Log.d("SUCCESS","SUCCESS");

                } else {
                    // Insert failed
                    Log.e("FAILURE",exception.toString());
                }
            }
        });
    }

    public RideShare getRideShareByID(String id){
        try {
            List<RideShare> mRides = mClient.getTable(RideShare.class).where().field("id").eq(val(id)).execute().get();
            return mRides.iterator().next();
        }
        catch (Exception ex){
            Log.e("EX",ex.toString());
        }
        return new RideShare();
    }

    public List<RideShare> getAllRideShares(){
        try {
            List<RideShare> mRides = mClient.getTable(RideShare.class).execute().get();
            return mRides;
        }
        catch (Exception ex){
            Log.e("EX",ex.toString());
        }
        return null;
    }
}

