package com.learn.sample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

//import java.net.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class AddController {

	
	@GetMapping("/systeminfo")
	String hello() {
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());



		System.out.println("\n");
		System.out.println(timeStamp);
		SystemInfo systemInfo = new SystemInfo();
		//System.out.println("Os Name: " + systemInfo.osName());
		

		for(String s : systemInfo.osInfo().split("<br/>")) {
			System.out.println(s);
		}
		System.out.println("\n");

		System.out.println("Os Total Memory: " + systemInfo.totalMem() / 1024.0 + " KB");
		System.out.println("\n");

		System.out.println("Os Used Memory: " + systemInfo.usedMem()/ 1024.0 + " KB");
		System.out.println("\n");

		
		System.out.println("OS Version" + systemInfo.osVersion());
		System.out.println("\n");
		
		System.out.println("Os info" );
		for(String sys : systemInfo.memInfo().split("<br/>")) {
			System.out.println(sys);
		}
		System.out.println("\n");
		System.out.println("Disk Informtion");
		for(String Mem : systemInfo.diskInfo().split("<br/>")) {
			System.out.println(Mem);
		}
//	
//		System.out.println("Disk Information");
//	  System.out.println("Os info" + systemInfo.info());
		
	//	System.out.println(systemInfo.diskInfo.root.getAbsolutePath());
	    return "hello";
	 }     
}
