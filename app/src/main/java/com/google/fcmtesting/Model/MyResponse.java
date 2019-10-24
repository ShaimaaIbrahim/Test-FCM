package com.google.fcmtesting.Model;

public class MyResponse {

    public int success;

    public MyResponse(int success) {
        this.success = success;
    }

    public MyResponse() {
    }

    public int getSuccess() {
        return success;
    }

    public MyResponse setSuccess(int success) {
        this.success = success;
        return this;
    }
}
