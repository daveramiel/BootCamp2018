package com.company;

public class Proxy {

    DataBase dataBase = null;

    public Proxy(){
        System.out.println("Creating your Proxy, execute method createProxy");
    }

    public void createProxy(){
        if (dataBase == null) {
            dataBase = new DataBase();
        } else{
            System.out.println("Data Base connection already exists");
        }

    }

}
