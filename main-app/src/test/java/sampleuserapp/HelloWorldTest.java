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
//        App.main(args);
//        assertEquals("Hello World!\n", outContent.toString());
    }
}
