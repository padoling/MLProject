package com.ja.mlproject.conn;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DjangoConnection {
	private String host;
	private int port;
	
	public void setConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void djangoSocket(String json) {
		Socket socket = null;
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		try {
			// 소켓 연동
			socket = new Socket(host, port);
			System.out.println("========연결 성공========");
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			dataOutputStream.writeUTF(json);
			
			InputThread inputThread = new InputThread();
			inputThread.in = socket.getInputStream();
			inputThread.start();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
