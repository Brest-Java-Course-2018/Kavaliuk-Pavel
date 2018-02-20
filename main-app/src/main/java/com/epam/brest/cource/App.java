package com.epam.brest.cource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {

    /**
     * @param args - state of application
     * @throws SQLException           - some exception
     * @throws ClassNotFoundException - some exception
     */
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        System.out.println("Hello World!");
        App app = new App();
        app.dbHandler();
    }

    /**
     * @throws SQLException           - some exception
     * @throws ClassNotFoundException - some exception
     */
    private void dbHandler() throws SQLException, ClassNotFoundException {

        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnection();

        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "admin", "admin", "this is admin");
        dbUtils.addUser(connection, "anton", "admin", "this is admin");
        dbUtils.addUser(connection, "vlad", "admin", "this is admin");
        dbUtils.getUsers(connection);
        dbUtils.deleteUser(connection, "admin");
        dbUtils.getUsers(connection);
    }
}
