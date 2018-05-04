package com.company;

///This class creates and returns the  types of connections that we would need

public class ConnectFactory extends AbstractFactory {

    public ConnectFactory(){
    }


    @Override
    IDataBase getConnection(String connect) {
        String aux = connect.toLowerCase();

        if (aux.equals("mysql")){
            return new MySQL();
        }
        if (aux.equals("mongodb")){
            return new MongoDB();
        }

        return null;
    }

}

