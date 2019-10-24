package com.google.fcmtesting.Service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceId extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseInstanceId";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        String string=FirebaseInstanceId.getInstance().getToken();

    }



}
