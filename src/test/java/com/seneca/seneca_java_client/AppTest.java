package com.seneca.seneca_java_client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
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

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080); // No-args constructor defaults to port 8080
    
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
        stubFor(get(urlEqualTo("/index.html"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content Type", "text")
                .withBody("Hello Boston")));

        SenecaDriver client = new SenecaDriver("localhost", 8080);
        Object objectToSend = new Object();
        SenecaDriver.Message message = client.sendJson(new Object());
        assertTrue( message == null );
    }

}
