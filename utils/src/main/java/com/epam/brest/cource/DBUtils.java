package com.epam.brest.cource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private final String DBUrl = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(DBUrl, "sa", "");

        return connection;
    }
}
