package com.satyamcompany.app.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.satyamcompany.app.exceptions.SystemException;

public class DBUtil{
    private static Connection connection;

    private static String JDBC_URL= "jdbc:mysql://localhost:3306/food_db";
    private static String USER_NAME= "root";
    private static String PASSWORD= "Satyam@123";

    public static Connection getConnection() throws SystemException {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
        }catch(SQLException e) {
            throw new SystemException(e.getMessage());

        }
        return connection;
    }
}
