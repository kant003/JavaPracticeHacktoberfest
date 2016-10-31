package com.hacktoberfest;/*
// *************************************************************************************************
// PROJECT : JavaPracticeHacktoberfest
// *************************************************************************************************
// Author : chikaslocalhost
// Date : 10/28/16
// Since : version 1.0
// ****************************************************************************************************
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressZipFormat {

    public CompressZipFormat() throws IOException {
        compressToZipFile();
    }

    private void compressToZipFile() throws IOException{

        byte[] buffer = new byte[1024];

            FileOutputStream fos = new FileOutputStream("htb_certificate.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry("htb_certificate_chinthaka_dinadasa.pdf");
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream("/media/chikaslocalhost/A0D24D84D24D5FA0/htb_certificate.pdf");

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            //remember close it
            zos.close();

            System.out.println("Done");

    }

    public static void main(String[] args) {
    try {
        new CompressZipFormat();
    }catch (IOException e){
        e.printStackTrace();
    }


    }

}
