package com.blueally.org;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient {
	 public static void main(String args[]) {
	        byte[] aByte = new byte[1];
	        int bytesRead;

	        Socket clientSocket = null;
	        InputStream is = null;

	        try {
	            clientSocket = new Socket("192.168.43.175", 3248);
	            is = clientSocket.getInputStream();
	        } catch (IOException ex) {
	            // Do exception handling
	        }

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        if (is != null) {

	            FileOutputStream fos = null;
	            BufferedOutputStream bos = null;
	            try {
	                fos = new FileOutputStream("D:\new.txt");
	                bos = new BufferedOutputStream(fos);
	                bytesRead = is.read(aByte, 0, aByte.length);
	                System.out.println("file uploaded");

	                do {
	                        baos.write(aByte);
	                        bytesRead = is.read(aByte);
	                } while (bytesRead != -1);

	                bos.write(baos.toByteArray());
	                bos.flush();
	                bos.close();
	                clientSocket.close();
	            } catch (IOException ex) {
	                // Do exception hanling
	            }
	        }
	    }
	}



