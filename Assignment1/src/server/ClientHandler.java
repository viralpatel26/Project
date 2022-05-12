package server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.InputListener;

public class ClientHandler implements Runnable, PropertyChangeListener {
	private Socket socket1;
	private Socket socket2;
	private ObjectOutputStream oos1;
	private ObjectOutputStream oos2;
	private InputListener listener1;
	private InputListener listener2;
	
	
	
	public ClientHandler(Socket socket1, Socket socket2) throws IOException 
	{
		this.socket1 = socket1;
		this.socket2 = socket2;
		oos1 = new ObjectOutputStream(socket1.getOutputStream());
		oos2 = new ObjectOutputStream(socket2.getOutputStream());
	}


	@Override
	public void run() {
		listener1 = new InputListener(socket1, 1, this);
		listener2 = new InputListener(socket2, 2, this);
		new Thread(listener1).start();
		new Thread(listener2).start();
		
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		InputListener listener = (InputListener) evt.getSource();
		
		if (listener.getNumber() == 1 ) {
			try {
				oos2.writeObject(evt.getNewValue());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else {
			try {
				oos1.writeObject(evt.getNewValue());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if observable (inputListener) has getNumber() == 1
		// use oos2.writeObject (object picked up in the inputlistener)
		//else
		// use oos1.writeobject(object picked up in the inputlistener)
		
	}
	
	
	
	
	

}
