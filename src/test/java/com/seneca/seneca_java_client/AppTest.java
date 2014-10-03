package com.seneca.seneca_java_client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
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
    public void testApp()
    {
        SenecaDriver client = new SenecaDriver("localhost", 8080);
        assertTrue( client != null );
    }


    @Test
    public void testSendJson()
    {
        stubFor(get(urlEqualTo("/"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content Type", "text")
                .withBody("Hello Boston")));

        SenecaDriver client = new SenecaDriver("localhost", 8080);
        SenecaDriver.Message message = client.sendJson(new Object());
        System.out.println(message);
    }

}
