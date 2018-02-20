package com.epam.brest.cource;

import java.sql.*;

/**
 * Class for managing database
 */

public class DBUtils {
    /**
     * Database connection string
     */
    private final String DBUrl = "jdbc:h2:mem:test_db;"
            + "MODE=MYSQL;DB_CLOSE_DELAY=-1";
    /**
     * SQL-queries
     */

    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS app_user ("
            + "user_id INT NOT NULL AUTO_INCREMENT, "
            + "login VARCHAR (225) NOT NULL, "
            + "password VARCHAR (225) NOT NULL, "
            + "description VARCHAR (225) NULL, "
            + "PRIMARY KEY (user_id))";
    private final String ADD_NEW_USER = "INSERT INTO app_user "
            + "(login, password, description) VALUES (?, ?, ?);";
    private final String SELECT_USER = "SELECT "
            + "user_id, login, password, description FROM app_user";
    private final String DELETE_USER = "DELETE FROM app_user WHERE login = ?";

    /**
     * This method create connection to DB
     *
     * @return Connection
     * @throws ClassNotFoundException - some exception
     * @throws SQLException           - some exception
     */
    public Connection getConnection()
            throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(DBUrl, "sa", "");
        return connection;
    }

    /**
     * Method for creating new table.
     * @param connection - current connection with DB
     * @throws SQLException - some exception
     */
    public void createUserTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_TABLE);
        } finally {
            System.out.println("Create table method");
        }
    }

    /**
     * Method for adding new write into table
     *
     * @param connection  - current connection with DB
     * @param login       - content of login column
     * @param password    - content of password column
     * @param description - content of description column
     * @throws SQLException - some exception
     */
    public void addUser(
            Connection connection, final String login, final String password, final String description)
            throws SQLException {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(ADD_NEW_USER)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, description);
            preparedStatement.executeUpdate();
        } finally {
            System.out.println(String.format("Add user %s", login));
        }
    }

    /**
     * Method for showing all writes in the table
     * @param connection - current connection with DB
     * @throws SQLException - some exception
     */
    public void getUsers(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_USER);
            while (resultSet.next()) {
                System.out.println(String.format("User: %s, login: %s",
                        resultSet.getInt("user_id"),
                        resultSet.getString("login")));
            }
        }
    }

    /**
     * Method for deleting required write
     *
     * @param connection - current connection with DB
     * @param login      - content of login column
     * @throws SQLException - some exception
     */
    public void deleteUser(Connection connection, final String login)
            throws SQLException {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
            System.out.println(String.format("Delete user %s", login));
        }
    }
}
