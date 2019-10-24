package com.google.fcmtesting;

import com.google.fcmtesting.Remote.ApiService;
import com.google.fcmtesting.Remote.Client;

public class Common {

    public static String currentToken="";
    public static String baseUrl="https://fcm.googleapis.com/";


    public static ApiService getFCM(){

        //to return Call contains all response and all information about message body
        return Client.getClient(baseUrl).create(ApiService.class);

    }

}
