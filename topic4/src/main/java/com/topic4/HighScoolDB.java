package com.topic4;

import java.sql.Connection;


public class HighScoolDB {

    private static HighScoolDB dbInstance;
    private Connection connect;


    public static HighScoolDB getInstance() {
        return HighScoolDB.dbInstance == null ? new HighScoolDB() : HighScoolDB.dbInstance;
    }

}
