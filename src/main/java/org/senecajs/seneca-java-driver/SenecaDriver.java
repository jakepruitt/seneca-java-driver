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

public class SenecaDriver {
	private int remotePort;
	private String remoteHost;
	private String remoteURL;

	public SenecaDriver(String remoteHost, int remotePort) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		this.remoteURL = "http://" + remoteHost + ":" + remotePort + "/act";
	}

	/**
	
		TODO:
		- Make sure to change Exception to ClientProtocolException
		- Second todo item
	
	**/
	public String act(String json) throws Exception {
		String responseString = Request.Post(this.remoteURL.toString())
            .bodyString(json, ContentType.APPLICATION_JSON)
            .execute().returnContent().asString();

    return responseString;
	}
}

