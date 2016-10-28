package com.hacktoberfest;/*
// *************************************************************************************************
// PROJECT : JavaPracticeHacktoberfest
// *************************************************************************************************
// Author : chikaslocalhost
// Date : 10/28/16
// Since : version 1.0
// ****************************************************************************************************
*/

import java.io.File;

public class DiskSpaceDetailExtractor {

    public DiskSpaceDetailExtractor() {

        File file = new File("/media/chikaslocalhost/A0D24D84D24D5FA0");
        long totalSpace = file.getTotalSpace(); //total disk space in bytes.
        long usableSpace = file.getUsableSpace(); ///unallocated / free disk space in bytes.
        long freeSpace = file.getFreeSpace(); //unallocated / free disk space in bytes.

        System.out.println(" === Partition Detail ===");

        System.out.println(" === bytes ===");
        System.out.println("Total size : " + totalSpace + " bytes");
        System.out.println("Space free : " + usableSpace + " bytes");
        System.out.println("Space free : " + freeSpace + " bytes");

        System.out.println(" === mega bytes ===");
        System.out.println("Total size : " + totalSpace /1024 /1024 + " mb");
        System.out.println("Space free : " + usableSpace /1024 /1024 + " mb");
        System.out.println("Space free : " + freeSpace /1024 /1024 + " mb");

    }

    public static void main(String[] args) {
        new DiskSpaceDetailExtractor();
    }
}
