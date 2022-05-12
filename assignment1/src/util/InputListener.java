package util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class InputListener implements Runnable {

	private Socket socket;
	private int number;
	private ObjectInputStream ois;
	private ArrayList <PropertyChangeListener> observers = new ArrayList<>();
	//this gets invoked in the clientHandler
	public InputListener (Socket socket, int number, PropertyChangeListener observer)
	{
		this.socket = socket;
		this.number = number;
		observers.add(observer);
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getNumber() {
		return number;
	}
	//this gets invoked in the clientGUI
	public InputListener (Socket socket, PropertyChangeListener observer)
	{
		this.socket = socket;
		observers.add(observer);
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void run() 
	{
		while (true) {
			try {
				Object message = ois.readObject();
				notifyObservers(message);
				// notify the observers - private method where it invokes propertyChangeMethod of observer
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void notifyObservers(Object message) {
		for (PropertyChangeListener list : observers ) {
			list.propertyChange(new PropertyChangeEvent(this, null, null, message));
		
	}

}
}
