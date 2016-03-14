package com.example.carrentalsearching.communication;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class RequestFactory {

    private static CarRentalRequest sInstance;

    private RequestFactory() {}

    public static CarRentalRequest getCarRentalRequest() {
        if (sInstance == null) {
            sInstance = buildCarRentalRequest();
        }

        return sInstance;
    }

    private static CarRentalRequest buildCarRentalRequest() {
        //Setting OkHTTPClient
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CarRentalRequest.SERVER_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CarRentalRequest.class);
    }
}
