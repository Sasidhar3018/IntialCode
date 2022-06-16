package com.learn.sample;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.learn.sample.controller.Person;
import com.learn.sample.controller.SystemInfo;

@SpringBootApplication   
public class Prototype {
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(Prototype.class, args);
				}
	
	
	
}
