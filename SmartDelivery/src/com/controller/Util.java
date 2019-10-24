package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.web.multipart.MultipartFile;


public class Util extends Thread {
	static ServerSocket serverSocket;
	boolean flag = true;
	boolean rflag = true;
	public static void saveFile(MultipartFile mf, String dir) {
		try {
			serverSocket = new ServerSocket(50001);
			System.out.println("Ready Server...");
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		byte [] data;
		String imgname=mf.getOriginalFilename();
		
		try {
			data=mf.getBytes();
			System.out.println(dir);
			FileOutputStream fo = new FileOutputStream(dir+imgname);
			fo.write(data);
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(flag) {
			
			try {
				System.out.println("Ready Accept");
				Socket socket = serverSocket.accept();
				new Receiver(socket).start();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
	class Receiver extends Thread{
		//InputStream in;
		FileInputStream fin;
		Socket socket;
		String ip;
		
		byte buffer[] = new byte[2048];
		public Receiver(Socket socket) {
			try {
				this.socket = socket;
				//in = socket.getInputStream();
				fin = new FileInputStream("file:///storage/emulated/0/cameratest.jpg");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}//end Receiver
		
		@Override
		
		public void run() {
			try {
				while(rflag) {
					if(socket.isConnected() && fin != null && fin.available() >0) {
						int str = fin.read(buffer);
						System.out.println(str);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
