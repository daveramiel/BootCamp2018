package com.company;

///This guy will construct my connection and make sure that everything is alright

public class DataBaseDirector {

    private DataBaseBuilder dataBaseBuilder = null;

    public DataBaseDirector(DataBaseBuilder dataB){
        this.dataBaseBuilder = dataB;
    }

    public void construcDataBase(){
        dataBaseBuilder.buildConnection();
    }

    public String getConnection(){
        return this.dataBaseBuilder.getConnection();
    }

}
