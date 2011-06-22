package annotation.webservice;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService(targetNamespace="http://tuchb",serviceName="sayHelloService")
public class HelloServicePrivider {
	@WebResult(name="HelloWorld")
	@WebMethod
	public String sayHello(@WebParam(name="userName") String name){
		return "Hello,"+name;
	}
	
	@Oneway
	@WebMethod
	public void login(){
		System.out.println("zhangfan");
	}
	
	public static void main(String[] args) {
		Thread wsPublisher = new Thread(new HelloServicePublisher());
		wsPublisher.start();
	}
}
