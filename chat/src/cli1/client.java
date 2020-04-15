package cli1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class client {
	

	public static void main(String[] args) {
 
		try {
			InetAddress ip = InetAddress.getByName("localhost");
			Socket clientsocket=new Socket(ip,3000);
			DataInputStream input=new DataInputStream(clientsocket.getInputStream());
			DataOutputStream output=new DataOutputStream(clientsocket.getOutputStream());
			
			String isconnected=input.readUTF();
			System.out.println("Server:"+isconnected);
			while(true) {
			
			String askForReq=input.readUTF();
			System.out.println("Server:"+askForReq);
			 
			
			Scanner scanner = new Scanner(System.in);
			String Request=scanner.nextLine();

			output.writeUTF(Request);
			
			if(Request.equalsIgnoreCase("close")){
				
				clientsocket.close();
				System.out.println("Connection with this server is closed.");
				break;
			}
			}
					} 
					catch(UnknownHostException e) {}

		catch (IOException e) {
			
			e.printStackTrace();
		}		
	
		
	}

}