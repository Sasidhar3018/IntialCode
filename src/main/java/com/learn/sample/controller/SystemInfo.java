package com.learn.sample.controller;
import java.io.File;
import java.text.NumberFormat;

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
        sb.append("Free memory: ");
        sb.append(format.format(freeMemory));
       // System.out.println("\n");
        sb.append("<br/>");
        sb.append("Allocated memory: ");
        sb.append(toGB(runtime.totalMemory()));
        sb.append("<br/>");
        sb.append("Max memory: ");
        sb.append(toGB(runtime.maxMemory()));
        sb.append("<br/>");
        sb.append("Total free memory: ");
        sb.append(toGB(runtime.freeMemory()) + (toGB(runtime.maxMemory()) - toGB(runtime.totalMemory())));
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
            sb.append("Total space (GB): ");
            sb.append(toGB(root.getTotalSpace()));
            sb.append("<br/>");
            sb.append("Free space (GB): ");
            sb.append(toGB(root.getFreeSpace()));
            sb.append("<br/>");
            sb.append("Usable space (GB): ");
            sb.append(toGB(root.getUsableSpace()));
            sb.append("<br/>");
        }
        return sb.toString();
    }
    
    
    private long toGB(long bytes) {
    	return bytes/(1024 * 1024 * 1024);
    }
}