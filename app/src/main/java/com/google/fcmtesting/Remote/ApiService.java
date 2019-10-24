package com.google.fcmtesting.Remote;


import com.google.fcmtesting.Model.MyResponse;
import com.google.fcmtesting.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({
        "Content-Type:application/json",
        "Authorization:key=AAAAlxza3mI:APA91bGJdspI4gGURDNk4JhJJ9DceGH-AbOMJk4XRBccqIMlVFuoY5EtklVXDGGe8YR3iGkNY2E8nVBhd68NMvfI4W6DYHr4PnJwqMTFa3a_3uc4iffpyF2gA3apIiwCFnTf9V4HgViE"

    })

    @POST("fcm/send")
    Call<MyResponse>sendNotification(@Body Sender body);
}
