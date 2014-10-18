/* ==================================================
= Seneca Java Driver                                =
=                                                   =
= For any questions about the Seneca or this Java   =
= driver, check out the docs at                     =
=  https://github.com/jrpruit1/seneca-java-driver   =
= or feel free to contact me on twitter:            = 
=  @thejakepruitt                                   =
===================================================*/
package org.senecajs.seneca_java_driver;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;

public class SenecaDriver {
	private int remotePort;
	private String remoteHost;
	private GenericUrl remoteURL;

	static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	static final JsonFactory JSON_FACTORY = new JacksonFactory();

	public SenecaDriver(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;

		try {
			this.remoteURL  = new GenericUrl("http://" + remoteHost + ":" + remotePort + "/index.html");
		} catch(IllegalArgumentException ex) {
			throw new IllegalArgumentException("Host or Port parameters could not be converted to URL", ex);
		}
		
	}

	public static class Message {
		@Key
		public String cmd;

		@Key
		public String role;
	}

	public Message sendJson(Object data) {

		HttpRequestFactory requestFactory = 
			HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
				@Override
				public void initialize(HttpRequest request) {
					request.setParser(new JsonObjectParser(JSON_FACTORY));
				}
			});

		JsonHttpContent jsonContent = new JsonHttpContent(JSON_FACTORY, data);

		try {
			System.out.println("URL Requesting: " + this.remoteURL.toString());
			HttpRequest request = requestFactory.buildPostRequest(this.remoteURL, jsonContent);
			Message message = request.execute().parseAs(Message.class);
			return message;
		} catch(IOException ex) {
			System.err.println("Caught IOException: " + ex.getMessage());
			return null;
		}
	}

}

