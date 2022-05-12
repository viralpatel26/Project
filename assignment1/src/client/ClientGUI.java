package client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.InputListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBoxMenuItem;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class ClientGUI extends JFrame implements PropertyChangeListener {
	private javax.swing.JLabel label1;
	private javax.swing.JTextArea display1;
	public javax.swing.JTextArea text1;

	static String username1;
	private JPanel contentPane;
	private ObjectOutputStream oos;
	private InputListener listener;
	private JButton[] buttons;
	private Boolean flag;

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
	
	public ClientGUI()   {
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
		setBounds(100, 100, 896, 415);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(500, 60, 400, 300);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 10,0,0));
		buttons = new JButton[100];
		//buttons = new JButton("String");
		//panel.add(buttons);
		ArrayList<Integer> ships  = new ArrayList<Integer>(); 
		ActionListener listener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					
					int index = Integer.parseInt(e.getActionCommand());
					buttons[index].setBackground(Color.blue);
					ships.add(index);
					try {
						oos.writeObject(index);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (ships.size() == 5) {
						JOptionPane.showMessageDialog(contentPane , "You Have Placed Your Ships, Start Game");	
					}
				}
				}
		};
		for (int i = 0; i < 100; i++ ) {
			buttons[i]= new JButton(String.valueOf(i));
			buttons[i].addActionListener(listener2); 
			panel.add(buttons[i]);			
		}
		contentPane.setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object object = evt.getNewValue();
		if (object instanceof String) {
				display1.append((String) evt.getNewValue());
				}
		else if (object instanceof Integer) {
				flag = true;
				buttons[(int)object].setBackground(null);
				}
	}
}

	
	
	


	
