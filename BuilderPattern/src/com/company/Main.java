package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataBaseBuilder dataBaseBuilder = new mySqlBuilder();
        DataBaseDirector dataBdirector = new DataBaseDirector(dataBaseBuilder);
        dataBdirector.construcDataBase();
        String data = dataBdirector.getConnection();
        System.out.println(data);
    }
}
