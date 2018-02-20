package sampleuserapp;

import com.epam.brest.cource.App;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    private static String args[];

    private final String EXPECTED_RESULT = "Hello World!\n" +
            "Create table method\n" +
            "Add user admin\nAdd user anton\nAdd user vlad\n" +
            "User: 1, login: admin\n" +
            "User: 2, login: anton\n" +
            "User: 3, login: vlad\n" +
            "Delete user admin\n" +
            "User: 2, login: anton\n" +
            "User: 3, login: vlad\n";
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    /*
    This method will be invoked before procedure which annotated like @Test.
    It's need for catch output stream.
    */
    @Before
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }
    /*
    This method will be invoked after procedure which annotated like @Test.
    It's need to return output stream.
     */
    @After
    public void repairStream(){
        System.setOut(System.out);
    }

    /*
    This procedure compares needed string with obtained.
     */
    @Test
    public void returnTest() throws SQLException, ClassNotFoundException {
        App.main(args);
        assertEquals(EXPECTED_RESULT, outContent.toString());
    }
}
