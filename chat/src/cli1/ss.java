package cli1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ss extends Thread{
	private Socket clientsocket;
	
public ss (Socket clientSocket) {
	this.clientsocket=clientSocket;
}
@Override
public void run() {
	try {
		DataInputStream input=new DataInputStream(clientsocket.getInputStream());
		DataOutputStream output=new DataOutputStream(clientsocket.getOutputStream());
		
		output.writeUTF("connected.");
		
		output.writeUTF("Send your request or close to close the connection");
		while(true) {
		String Request =input.readUTF();
		System.out.println("client:"+Request);
		
		if(Request.equalsIgnoreCase("close")){
			
			clientsocket.close();
			System.out.println("Connection with this server is closed.");
			break;
		}
		
		Scanner scanner=new Scanner(System.in);
		String Response=scanner.nextLine();
		output.writeUTF(Response);
		}}catch (IOException e) {
			System.out.println("Problem in IO of server socket");		}
	}


}
