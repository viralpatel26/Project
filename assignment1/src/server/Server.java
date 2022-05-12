package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args)
	{
		try 
		{
			
			ServerSocket serverSocket = new ServerSocket(5555);
			ArrayList <Socket> sockets = new ArrayList<>();
			while (true)
			{
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				if (sockets.size() == 2)
				{
				ClientHandler clientHandler =new ClientHandler(sockets.get(0), sockets.get(1));
						Thread thread = new Thread(clientHandler);
				thread.start();
				sockets.clear();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
