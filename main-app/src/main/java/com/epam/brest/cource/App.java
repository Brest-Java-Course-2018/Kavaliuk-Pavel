package com.epam.brest.cource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    Connection connection = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello World!");
        App app = new App();
        app.dbHandler();

    }

    public void dbHandler() throws SQLException, ClassNotFoundException {
        DBUtils dbUtils = new DBUtils();

        connection = dbUtils.getConnection();

        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "admin", "admin", "this is admin");
        dbUtils.addUser(connection, "anton", "admin", "this is admin");
        dbUtils.addUser(connection, "vlad", "admin", "this is admin");
        dbUtils.getUsers(connection);
        dbUtils.deleteUser(connection, "admin");
        dbUtils.getUsers(connection);
    }
}
