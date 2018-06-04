package com.blueally.org;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String args[]) {

        while (true) {
            ServerSocket welcomeSocket = null;
            Socket connectionSocket = null;
            BufferedOutputStream outToClient = null;
        
            System.out.println("file uploaded succefully");
            try {
                welcomeSocket = new ServerSocket(3248);
                connectionSocket = welcomeSocket.accept();
                outToClient = new BufferedOutputStream(connectionSocket.getOutputStream());
            } catch (IOException ex) {
            }

            if (outToClient != null) {
                File myFile = new File("D:\new.txt");
                byte[] mybytearray = new byte[(int) myFile.length()];

                FileInputStream fis = null;

                try {
                    fis = new FileInputStream(myFile);
                } catch (FileNotFoundException ex) {
                   
                }
                BufferedInputStream bis = new BufferedInputStream(fis);

                try {
                    bis.read(mybytearray, 0, mybytearray.length);
                    outToClient.write(mybytearray, 0, mybytearray.length);
                    outToClient.flush();
                    outToClient.close();
                    connectionSocket.close();

                    return;
                } catch (IOException ex) {
                }
            }
        }
    }
}


