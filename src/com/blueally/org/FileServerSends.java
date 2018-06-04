package com.blueally.org;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerSends {
	public static void main(String[] args) throws Exception{
		ServerSocket ss= new ServerSocket(9999);
		//Server Wait client Accepts connections
		Socket s= ss.accept();
		System.out.println("connection established");
		// Accept file name from client
		BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
		//to send file content to the client
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		//Read the file name from the client 
		String fname=in.readLine();
		FileReader fr=null;
		BufferedReader file=null;
		boolean flag;
		//create file object
		File f=new File(fname);
		//test file Exit or not
		if(f.exists())
			flag=true;
		else
			flag=false;
		//if file Exits send yes to client ,else send no 
		if(flag ==true)
			out.writeBytes("yes");
		else 
			out.writeBytes("no");
		if(flag==true)
		{
			//Attach to the file reader
			fr=new FileReader(fname);
			//attach File to the BufferReader 
			file =new BufferedReader(fr);
			String str;
			while((str=file.readLine())!=null)
			
			{
				out.writeBytes(str+"/n");
			}
			file.close();
			out.close();
			in.close();
			fr.close();
			s.close();
			ss.close();
		}
	}
}
			
				
		
