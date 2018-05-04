package com.company;

public class MongoDB implements IDataBase {

    public MongoDB(){}

    @Override
    public void Connect() {
        System.out.println("Mongo Connecting");
    }
}
