package com.epam.brest.cource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class CreateTableTest {

    private final String EXPECTED_RESULT_1 = "Create table method\n";

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
    public void createTableTest() throws SQLException, ClassNotFoundException {

        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        assertEquals(EXPECTED_RESULT_1, outContent.toString());
    }
}
