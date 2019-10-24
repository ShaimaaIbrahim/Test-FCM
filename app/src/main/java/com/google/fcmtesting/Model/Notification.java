package com.google.fcmtesting.Model;

public class Notification {

    public String body;
    public String title;

    public Notification() {
    }

    public Notification(String title , String body) {
        this.title = title;
        this.body=body;
    }

    public String getBody() {
        return body;
    }

    public Notification setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notification setTitle(String title) {
        this.title = title;
        return this;
    }
}
