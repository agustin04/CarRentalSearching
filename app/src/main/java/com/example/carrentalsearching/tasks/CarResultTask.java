package com.example.carrentalsearching.tasks;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import com.example.carrentalsearching.MainActivity;
import com.example.carrentalsearching.ResultListActivity;
import com.example.carrentalsearching.communication.RequestFactory;
import com.example.carrentalsearching.model.HotWireResult;
import com.example.carrentalsearching.model.Request;
import com.example.carrentalsearching.util.HotWireResultParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.internal.Util;
import retrofit2.Call;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class CarResultTask extends AsyncTask<Request, Void, HotWireResult> {

    private HotWireResult mHotWireResult;
    private Request mRequest;
    WeakReference<ResultListActivity> mActivity;
    public CarResultTask(ResultListActivity activity) {
        mActivity = new WeakReference<ResultListActivity>(activity);
    }

    @Override
    protected HotWireResult doInBackground(Request... params) {
        HotWireResult result = null;
        Request r = params[0];
        /*Call<HotWireResult> retrofitResponse = null;
        if (r != null) {
            retrofitResponse = RequestFactory.getCarRentalRequest().findCars(r.getDestination(), r.getStartDate(), r.getEndDate(),
                    r.getPickUpTime(), r.getDropOffTime());
        }
        if (retrofitResponse != null) {
            try {
                mHotWireResult = retrofitResponse.execute().body();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }*/

        String requestString = r.createStringRequest();
        String jsonResult = null;
        try {
            //String newRequestStr = requestString.replace(" ", "+");
            URL url = new URL(requestString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonResult = stringBuilder.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jsonResult != null) {
            mHotWireResult = HotWireResultParser.parseJson(jsonResult);
        }
        return mHotWireResult;
    }

    @Override
    protected void onPostExecute(HotWireResult hotWireResult) {
        ResultListActivity a = mActivity.get();
        if (a != null) {
            a.onLoaded(hotWireResult);
        }
    }
}