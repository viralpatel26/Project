package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import clients.InputListener;

//import ex2.Message;

public class Server {
	/**
	 * @param args
	 */
	static ArrayList<Socket>sockets = new ArrayList<>();
	static Vector<ClientHandler> ar = new Vector<>();
	static int i = 0;
	public static void main( String[] args )
	{
		ServerSocket ss = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket socket = null;
		
		// Bind our server to port 5555
		try
		{
			ss = new ServerSocket( 5556 );
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while( true )
		{
			try
			{
				System.out.println( "Server is up and running!" );
				// Blocking statement - sits and listens for connection
				socket = ss.accept();
				sockets.add(socket);
				if(sockets.size()==2) {
					ClientHandler clientHandler = new ClientHandler(sockets.get(0),sockets.get(1));
					Thread t = new Thread(clientHandler);
					t.start();
					
				}
				
				i++;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
