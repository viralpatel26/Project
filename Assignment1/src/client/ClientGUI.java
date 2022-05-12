package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.InputListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame implements PropertyChangeListener {
	private javax.swing.JLabel label1;
	private javax.swing.JTextArea display1;
	public javax.swing.JTextArea text1;

	static String username1;
	private JPanel contentPane;
	private ObjectOutputStream oos;
	private InputListener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI frame = new ClientGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Socket socket;
	public ClientGUI() {
		try {
			socket = new Socket("localhost", 5555);
			oos = new ObjectOutputStream(socket.getOutputStream());
			listener = new InputListener(socket, this);
			//listener = new InputListener(socket, ClientGUI.this); When we add the connect button
			
			new Thread(listener).start();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		display1 = new JTextArea();
		display1.setBounds(12, 45, 408, 133);
		contentPane.add(display1);
		
		JTextArea text1 = new JTextArea();
		text1.setBounds(12, 191, 247, 37);
		contentPane.add(text1);
		
		JButton send1 = new JButton("send");
		send1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = text1.getText();
				if(s.equals("")) {return;}
				display1.append(username1+":"+s+"\n");
				//window2.sendText();
				text1.setText("");
				try {
					oos.writeObject(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		send1.setBounds(300, 191, 97, 37);
		contentPane.add(send1);
		
		JLabel lable1 = new JLabel("New label");
		lable1.setBounds(12, 13, 56, 16);
		contentPane.add(lable1);
		
		JButton clear = new JButton("Connect");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*try {
					socket = new Socket("localhost", 5555);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//display1.setText("");
				//listener = new InputListener(socket, ClientGUI.this);*/
				display1.append("You are Connected Say Hi!");
			}
		});
		clear.setBounds(300, 7, 97, 25);
		contentPane.add(clear);
		contentPane.setVisible(true);
	}
	/*public static void  sendText() {
		String s = window2.text2.getText();
		if(s.equals("")) {return;}
		display1.append(window2.username2+":"+s+"\n");
	}*/

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		display1.append((String) evt.getNewValue());
		
	}
	
	
}
