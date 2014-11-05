package org.senecajs.seneca_java_driver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testClientInitializationWithParams()
    {
        SenecaDriver client = new SenecaDriver("localhost", 10101);
        assertTrue( client != null );
    }

    @Test
    public void testClientInitializationWithoutParams()
    {
        SenecaDriver client = new SenecaDriver();
        assertTrue( client != null );
    }

    @Test
    public void testActWithString() throws Exception {
        SenecaDriver client = new SenecaDriver();
        String responseString = client.act("{\"cmd\": \"config\", \"prop\": \"rate\"}");

        System.out.println(responseString);
        assertTrue(responseString != "{\"value\":0.23}");
    }
}
