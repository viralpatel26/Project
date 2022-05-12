package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClientHandler implements Runnable {

	    private String name; 
	    Socket s1,s2; 
	    boolean isloggedin; 
	      
	    // constructor 
	    public ClientHandler(Socket s1,Socket s2) { 
	   
			this.s1 = s1; 
	        this.s2 = s2;
	        this.isloggedin=true; 
	    } 
	
		@Override
	    public void run() { 
	  
			OutputStream os1 = s1.getOutputStream();
			ObjectOutputStream oos1 = new ObjectOutputStream(os1);
			oos1.writeObject(os1);
			OutputStream os2 = s2.getOutputStream();
			ObjectOutputStream oos2 = new ObjectOutputStream(os2);
			oos2.writeObject(os2);
	        String received; 
	        while (true)  
	        { 
	            try
	            { 
	                // receive the string 
	                //received = dis.readUTF(); 
	                  
	                System.out.println(received); 
	                  
	                if(received.equals("logout")){ 
	                    this.isloggedin=false; 
	                    this.s1.close(); 
	                    this.s2.close(); 
	                    break; 
	                } 
	                  
	               
	              
	            } catch (IOException e) { 
	                  
	                e.printStackTrace(); 
	            } 
	              
	        } 
	    } 
}
