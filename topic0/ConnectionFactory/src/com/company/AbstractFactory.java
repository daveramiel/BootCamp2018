package com.company;

///A Factory for factories

public abstract class AbstractFactory {

    abstract IDataBase getConnection(String connect);

}
