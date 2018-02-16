package sampleuserapp;

import com.epam.brest.cource.DBUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class AddUserTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String EXPECTED_RESULT_1 = "Create table method\n";
    private final String EXPECTED_RESULT_2 = EXPECTED_RESULT_1 + "Add user ivan\n";

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
    public void addUserTest() throws SQLException, ClassNotFoundException {
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "ivan", "admin", "this is a test");
        assertEquals(EXPECTED_RESULT_2, outContent.toString());
    }

    @Test
    public void createTableTest() throws SQLException, ClassNotFoundException {

        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        assertEquals(EXPECTED_RESULT_2 + EXPECTED_RESULT_1, outContent.toString());

    }

}