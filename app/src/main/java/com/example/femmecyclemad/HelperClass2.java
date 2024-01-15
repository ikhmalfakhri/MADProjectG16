package com.example.femmecyclemad;

public class HelperClass2 {

    String subject, message;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String name) {
        this.subject = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String email) {
        this.message = email;
    }



    public HelperClass2(String subject, String message) {
        this.subject = subject;
        this.message = message;

    }


}