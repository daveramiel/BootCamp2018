package com.company;

public class mySqlBuilder implements DataBaseBuilder {

    ///I don-t know about this one, supposedly should be a DataBase object, but everything is a String!
    private DataBase mySql;


    @Override
    public void buildConnection() {
        this.mySql.setStringConnection("Let's do something fishy");
    }

    @Override
    public String getConnection() {
        return this.mySql.getStringConnection();
    }
}
