package com.topic4;

import java.sql.*;


public class HighScoolDB {

    private static HighScoolDB dbInstance;
    private Connection connection;


    public static HighScoolDB getInstance() {
        return HighScoolDB.dbInstance == null ? new HighScoolDB() : HighScoolDB.dbInstance;
    }

    private HighScoolDB() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/high-school","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  testing method
     */
    public void printName(String name) throws SQLException {
        String sql = "SELECT * FROM students WHERE first_name = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            System.out.println(rs.getString(1) + rs.getString(2)+ rs.getString(3)+ rs.getString(4));

        }

    }


    public static void main(String[] args) {
        HighScoolDB hs = HighScoolDB.getInstance();
        try {
            hs.printName("Milhouse");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
