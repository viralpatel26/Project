package clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//import ex2.Message;

public class InputListener implements Runnable {

	private Socket socket;
	ObjectInputStream ois = null;
	Integer id;
	//Constructors
	public InputListener(Socket socket,Integer id)
	{
		super();
		this.socket = socket;
		this.id=id;
	}
	
	//Operational Methods
	@Override
	public void run()
	{
		try {
		InputStream is = socket.getInputStream();
		ois = new ObjectInputStream(is);
		ois.readObject();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
