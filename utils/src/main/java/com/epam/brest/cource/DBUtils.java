package com.epam.brest.cource;

import java.sql.*;

public class DBUtils {
    private final String DBUrl = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(DBUrl, "sa", "");

        return connection;
    }

    public void createUserTable(Connection connection) throws SQLException {
        System.out.println("Create table method");
        Statement statement = null;
        String createTable =
                "CREATE TABLE app_user (" +
                        "user_id INT NOT NULL AUTO_INCREMENT, " +
                        "login VARCHAR (225) NOT NULL, " +
                        "password VARCHAR (225) NOT NULL, " +
                        "description VARCHAR (225) NULL, " +
                        "PRIMARY KEY (user_id))";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(createTable);
        } finally {
            statement.close();
        }


    }

    public void addUser(Connection connection, String login, String password, String description) throws SQLException {
        String newUser =
                "INSERT INTO app_user (login, password, description) VALUES (?, ?, ?);";
        System.out.println(String.format("Add user is %s", login));

        PreparedStatement preparedStatement = connection.prepareStatement(newUser);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, description);
        preparedStatement.executeUpdate();


    }

    public void getUsers(Connection connection) throws SQLException {
        String getRecords = "SELECT user_id, login, password, description FROM app_user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRecords);
        while (resultSet.next()) {
            System.out.println(String.format("User: %s, login: %s", resultSet.getInt("user_id"),
                    resultSet.getString("login")));
        }
    }
}
