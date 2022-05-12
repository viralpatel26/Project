package clients;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTwo {
	 public static void main(String args[]) throws UnknownHostException, IOException  
	    { 
	    	Integer id = 0;
	    	ObjectOutputStream oos = null;
	    	// Open a connection to my server listening on port 5555
			Socket socket = new Socket( InetAddress.getLocalHost(), 5556);
			
			
			// Creating an output stream to send text to the server
			OutputStream os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(os);
			
			InputListener lis = new InputListener(socket,id);
			Thread t1 = new Thread(lis);
			t1.start();
			
	    }

}
