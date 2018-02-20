package com.epam.brest.cource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DeleteUserTest {

    private final String EXPECTED_RESULT = "Create table method\n"
            + "Add user ivan\nAdd user anton\nDelete user ivan\n";
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void repairStream() {
        System.setOut(System.out);
    }

    DBUtils dbUtils = new DBUtils();


    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException {

        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "ivan", "admin", "this is a test");
        dbUtils.addUser(connection, "anton", "admin", "this is a test");
        dbUtils.deleteUser(connection, "ivan");

        assertEquals(EXPECTED_RESULT, outContent.toString());
    }
}
