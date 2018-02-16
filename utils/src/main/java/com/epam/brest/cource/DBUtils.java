package com.epam.brest.cource;

import java.sql.*;

public class DBUtils {
    private final String DBUrl = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";
    /*
    SQL-queries
     */
    private String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS app_user (" +
            "user_id INT NOT NULL AUTO_INCREMENT, " +
            "login VARCHAR (225) NOT NULL, " +
            "password VARCHAR (225) NOT NULL, " +
            "description VARCHAR (225) NULL, " +
            "PRIMARY KEY (user_id))";
    private String ADD_NEW_USER = "INSERT INTO app_user (login, password, description) VALUES (?, ?, ?);";
    private String SELECT_USER = "SELECT user_id, login, password, description FROM app_user";
    private String DELETE_USER = "DELETE FROM app_user WHERE login = ?";
    private String REMOVE_TABLE = "DROP TABLE app_user";

    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(DBUrl, "sa", "");
        return connection;
    }

    public void createUserTable(Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE);
        } finally {
            System.out.println("Create table method");
            statement.close();
        }
    }

    public void addUser(Connection connection, String login, String password, String description) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(ADD_NEW_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, description);
            preparedStatement.executeUpdate();
        } finally {
            System.out.println(String.format("Add user %s", login));
            //preparedStatement.close();
        }
    }

    public void getUsers(Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USER);
            while (resultSet.next()) {
                System.out.println(String.format("User: %s, login: %s", resultSet.getInt("user_id"),
                        resultSet.getString("login")));
            }
        } finally {
            statement.close();
        }
    }

    public void deleteUser(Connection connection, String login) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
            System.out.println(String.format("Delete user %s", login));
        } finally {
            // preparedStatement.close();
        }
    }
}
