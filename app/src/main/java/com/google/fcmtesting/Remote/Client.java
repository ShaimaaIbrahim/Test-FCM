package com.google.fcmtesting.Remote;

import com.google.fcmtesting.Model.Sender;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit=null;


    public static Retrofit getClient(String  BaseUrl){

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
