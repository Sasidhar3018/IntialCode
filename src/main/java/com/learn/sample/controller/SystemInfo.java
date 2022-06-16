package com.learn.sample.controller;
import java.io.File;
import java.text.NumberFormat;
import oshi.*;


public class SystemInfo {

//    private static final int 1024 = 1024;
	private Runtime runtime = Runtime.getRuntime();

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.osInfo());
        sb.append(this.memInfo());
        sb.append(this.diskInfo());      
        System.out.println(sb);
        return sb.toString();
        
    }
    

    

//    public long physicalMemorysize() {
//    	return System.getTotalMemorySize();
//    }
    
    public String osName() {
        return System.getProperty("os.name");
    }

    public String osVersion() {
        return System.getProperty("os.version");
    }

    public String osArch() {
        return System.getProperty("os.arch");
    }

    public long totalMem() {
        return Runtime.getRuntime().totalMemory();
    }

    public long usedMem() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public String memInfo() {
        NumberFormat format = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
 //       long maxMemory = runtime.maxMemory();
 //       long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        sb.append("\r\n" + "RAM Allocated to Java:");
        sb.append(toMB(freeMemory));
        sb.append("MB ");
       // System.out.println("\n");
        sb.append("<br/>");
        sb.append("Allocated memory: ");
        sb.append(toMB(runtime.totalMemory()));
        sb.append("MB");
        sb.append("<br/>");
        sb.append("Max memory: ");
        sb.append(toMB(runtime.maxMemory()));
        sb.append("MB");
        sb.append("<br/>");
        sb.append("Total free memory: ");
        sb.append(toMB(runtime.freeMemory()) + (toGB(runtime.maxMemory()) - toGB(runtime.totalMemory())));
        sb.append("MB");
        sb.append("<br/>");
        return sb.toString();  

    }

    public String osInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("OS: ");
        sb.append(this.osName()); 
        sb.append("<br/>");
        sb.append("Version: ");
        sb.append(this.osVersion());
        sb.append("<br/>");
//      sb.append(": ");
        sb.append(this.osArch());
        sb.append("<br/>");
        sb.append("Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append("<br/>");
        return sb.toString();
    }

//   public String used() {
//	   used memory = new used();
//	   HardwareAbstractionLayer hardware = used.getHardware();
//    GlobalMemory globalMemory = hardware.getMemory();
//   }

    public String diskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();
        //long Total_available_space = root.getTotalSpace();
        System.out.println("\n");

        /* For each filesystem root, print some info */
        for (File root : roots) {
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append("<br/>");
            sb.append("Total space: ");
            sb.append(toGB(root.getTotalSpace()));
            sb.append(" GB");
            sb.append("<br/>");
            sb.append("Free space: ");
            sb.append(toGB(root.getFreeSpace()));
            sb.append(" GB");
            sb.append("<br/>");
            sb.append("Usable space: ");
            sb.append(toGB(root.getUsableSpace()));
            sb.append(" GB");
            sb.append("<br/>");
        }
        return sb.toString();
    }
    
//    public String Eventlog(String log) {
//    	EventLogIterator iter = new EventLogIterator("Application");         
//    	while(iter.hasNext()) { 
//    	    EventLogRecord record = iter.next(); 
//    	    System.out.println(record.getRecordNumber() 
//    	             + ": Event ID: " + record.getEventId() 
//    	            + ", Event Type: " + record.getType() 
//    	            + ", Event Source: " + record.getSource()); 
//    	} 
//    }
    
    
    private long toGB(long bytes) {
    	return bytes/(1024 * 1024 * 1024 );
    }
    
    private long toMB(long bytes) {
    	return bytes/(1024*1024);
    
    }
}