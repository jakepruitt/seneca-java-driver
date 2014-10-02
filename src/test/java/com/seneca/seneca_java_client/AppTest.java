package com.seneca.seneca_java_client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;
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
    public void testApp()
    {
        SenecaDriver client = new SenecaDriver("facebook.com", 80);
        assertTrue( client != null );
    }

    @Test
    public void testSendJson()
    {
        SenecaDriver client = new SenecaDriver("facebook", 80);
        SenecaDriver.Message message = client.sendJson(new Object());
    }
}
