package com.google.fcmtesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.fcmtesting.Model.MyResponse;
import com.google.fcmtesting.Model.Notification;
import com.google.fcmtesting.Model.Sender;
import com.google.fcmtesting.Remote.ApiService;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Common.currentToken = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(MainActivity.this, "" + Common.currentToken, Toast.LENGTH_LONG).show();

        apiService = Common.getFCM();
        Notification notification = new Notification("jj", "nj");

        // send notification to yourSelf.......because your currentToken
        Sender sender = new Sender(Common.currentToken, notification);
        apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.body().success == 1) {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        //to send notification to multiPle Devices
      /*  FirebaseMessaging.getInstance().subscribeToTopic("MyTopic");

        Notification notification1=new Notification("jj","nj");

        Sender sender1=new Sender("/topics/MyTopic", notification1);

        apiService.sendNotification(sender1).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.body().success==1){
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }*/
    }
}
