package com.ja.mlproject.conn;

import java.io.DataInputStream;
import java.io.InputStream;

public class InputThread extends Thread{
	public InputStream in;
	public boolean isExit = false;
	
	public void run() {
		DataInputStream dis = new DataInputStream(in);
		
		while(true) {
			if(isExit == true)
				break;
			
			try {
				String learningLog = dis.readUTF();
				System.out.println(learningLog);
				
			} catch(Exception e) {
				e.printStackTrace();
				
			} 
		}
	}
}
