package com.topic1;

public class JUnitTestingClass {

    private String userName;

    public String getUserName(){
        return this.userName;
    }

    public String getMessage(String name) {
        String hey;
        if (name == null || name == "") {
            hey = "Hello person without a name!";
        } else {
            this.setUserName(name);
            hey = "Hey " + this.getUserName() + "! sup?!";
        }

        return hey;
    }

    public void setUserName(String name){
        this.userName = name;
    }

}
