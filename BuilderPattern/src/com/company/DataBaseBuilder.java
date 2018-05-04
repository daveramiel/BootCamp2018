package com.company;


///Simple interfacce.. since everything is a String there is a method to return an string and not a Database.
public interface DataBaseBuilder {

    public void buildConnection();

    public String getConnection();

}
