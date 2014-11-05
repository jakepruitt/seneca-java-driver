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

import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;
// import org.apache.http.client.ClientProtocolException;

	/**
	
		TODO:
		- [ ] Write description of use case
		- [ ] Handle various .act() exceptions
		- [ ] Configure maven to automatically start config-server.js
		- [ ] Create an override for .act() that accepts any object and parses to JSON
		- [ ] Create .add() and .listen() functionality
	
	**/

public class SenecaDriver {
	private int remotePort = 10101;
	private String remoteHost = "localhost";
	private String remoteURL = "http://" + remoteHost + ":" + remotePort + "/act";

	public SenecaDriver() {}

	public SenecaDriver(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		this.remoteURL = "http://" + remoteHost + ":" + remotePort + "/act";
	}

	public void client() {}
	
	public void client(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		this.remoteURL = "http://" + remoteHost + ":" + remotePort + "/act";
	}

	public String act(String json) throws Exception {
		String responseString = Request.Post(this.remoteURL.toString())
            .bodyString(json, ContentType.APPLICATION_JSON)
            .execute().returnContent().asString();

    return responseString;
	}
}

