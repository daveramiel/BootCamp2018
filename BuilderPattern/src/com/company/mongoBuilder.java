package com.company;

public class mongoBuilder implements DataBaseBuilder {

    ///Same as mySql...I don-t know about this one, supposedly should be a DataBase object, but everything is a String!
    private DataBase mongoDB;

    @Override
    public void buildConnection() {
        this.mongoDB.setStringConnection("Now with Mongo");
    }

    @Override
    public String getConnection() {
        return this.getConnection();
    }
}
