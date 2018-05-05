package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Proxy theProxy = new Proxy();

        DataBase mySql=new MySql();

        theProxy.createProxy();

    }
}
