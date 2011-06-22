package annotation.webservice;

import javax.xml.ws.Endpoint;

public class HelloServicePublisher implements Runnable {

	public void run() {
		Endpoint.publish("http://localhost:8888/tuchb/HelloService", new HelloServicePrivider());
	}

}
