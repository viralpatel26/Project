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

public class window2 extends JFrame {

	static String username2;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window2 frame = new window2();
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
	public window2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea display2 = new JTextArea();
		display2.setBounds(12, 53, 408, 133);
		contentPane.add(display2);
		
		JTextArea text2 = new JTextArea();
		text2.setBounds(12, 203, 247, 37);
		contentPane.add(text2);
		
		JButton send2 = new JButton("send");
		send2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text2.getText();
				if(s.equals("")) {return;}
				display2.append(username2+":"+s+"\n");
				window1.sendText();
				text2.setText("");
			}
		});
		send2.setBounds(323, 203, 97, 37);
		contentPane.add(send2);
		
		JLabel lable2 = new JLabel("New label");
		lable2.setBounds(24, 13, 56, 16);
		contentPane.add(lable2);
		
		JButton clear = new JButton("clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display2.setText("");
			}
		});
		clear.setBounds(323, 13, 97, 25);
		contentPane.add(clear);
	}
	public static void  sendText() {
		String s = window1.text1.getText();
		if(s.equals("")) {return;}
		display2.append(window1.username1+":"+s+"\n");
	}
	private javax.swing.JLabel label2;
	private static javax.swing.JTextArea display2;
	private javax.swing.JButton send2;
	public static javax.swing.JTextArea text2;

}
