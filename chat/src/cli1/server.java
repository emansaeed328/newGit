
package cli1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

	public static void main(String[] args) { 
		 
		try {
			ServerSocket serversocket=new ServerSocket(3000);
			System.out.println("Server is now booted up and waiting for client connect");
			
			while(true) {
			Socket clientsocket =serversocket.accept();
			
			System.out.println("a new client ["+clientsocket+" ]is connected to the server");
			ss client=new ss(clientsocket);
			
			client.start();
			
			}
		} catch (IOException e) {
			System.out.println("Problem in IO of server socket");		}
		
	}
}