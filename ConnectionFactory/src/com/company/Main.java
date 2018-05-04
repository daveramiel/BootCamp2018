package com.company;

public class Main {

    public static void main(String[] args) {

        //get DB Factory
        ConnectFactory FactoriaDelAmor = new ConnectFactory();
        //get the connection
        IDataBase aux = FactoriaDelAmor.getConnection("mysql");
        //try to connect
        aux.Connect();
        //Another test
        aux = FactoriaDelAmor.getConnection("mongoDB");
        aux.Connect();

    }
}
