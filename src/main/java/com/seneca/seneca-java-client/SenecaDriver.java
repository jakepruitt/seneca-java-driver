/* ==================================================
= Seneca Java Client                                =
=                                                   =
= For any questions about the Seneca or this Java   =
= driver, check out the docs at                     =
=  https://github.com/jrpruit1/seneca-java-client   =
= or feel free to contact me on twitter:            = 
=  @thejakepruitt                                   =
===================================================*/
package com.seneca.seneca-java-client;

import java.net.URL;
import java.net.MalformedURLException;

public class SenecaDriver {
	private int remotePort;
	private String remoteHost;
	private URL remoteURL;

	public SenecaDriver(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;

		try {
			this.remoteURL  = new URL("http", remoteHost, remotePort, null);
		} catch(MalformedURLException ex) {
			throw new IllegalArgumentException("Host or Port parameters could not be converted to URL", ex);
		}
		
	}

	public void receiveJSON() {}

	public void sendJSON() {}
}

