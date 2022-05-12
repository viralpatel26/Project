package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class window1 extends JFrame {

	static String username1;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window1 frame = new window1();
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
	public window1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea display1 = new JTextArea();
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
				window2.sendText();
				text1.setText("");
			}
		});
		send1.setBounds(300, 191, 97, 37);
		contentPane.add(send1);
		
		JLabel lable1 = new JLabel("New label");
		lable1.setBounds(12, 13, 56, 16);
		contentPane.add(lable1);
		
		JButton clear = new JButton("clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display1.setText("");
			}
		});
		clear.setBounds(300, 7, 97, 25);
		contentPane.add(clear);
	}
	public static void  sendText() {
		String s = window2.text2.getText();
		if(s.equals("")) {return;}
		display1.append(window2.username2+":"+s+"\n");
	}
	private javax.swing.JLabel label1;
	private static javax.swing.JTextArea display1;
	private javax.swing.JButton send1;
	public static javax.swing.JTextArea text1;
	
}
