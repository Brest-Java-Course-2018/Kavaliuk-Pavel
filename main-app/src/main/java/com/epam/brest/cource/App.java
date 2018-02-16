package com.epam.brest.cource;

import com.epam.brest.cource.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello World!");

        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "admin", "admin", "this is admin");
        dbUtils.addUser(connection, "admin", "admin", "this is admin");
        dbUtils.addUser(connection, "admin", "admin", "this is admin");
        dbUtils.getUsers(connection);
    }
}
