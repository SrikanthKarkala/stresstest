package com.homedepot.stresstest;

public class CustomNotFoundException extends  Throwable{

    private String message;

    public CustomNotFoundException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
