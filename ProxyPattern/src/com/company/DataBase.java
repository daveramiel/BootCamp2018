package com.company;

public class DataBase implements IDataBase {

    public DataBase(){
        System.out.println("All good so far");
    }

    @Override
    public void Connect() {
        System.out.println("Again connecting my friend");
    }
}
