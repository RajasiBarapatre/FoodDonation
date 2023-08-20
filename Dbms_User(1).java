package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.Component;

public class Dbms_User extends JFrame
{
	private JPanel contentPane;
	public static void main(String[] args)
	{

		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		PreparedStatement pst=null;
		JTable table;
		Statement stmt = null;

		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
		}
		catch(Exception e)  
		{

		}

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Dbms_User frame = new Dbms_User();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Dbms_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(800, 1000, 1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Load the image
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\loginpage.jpg");

		// Create a new image icon with the scaled image
		Image scaledImage = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

		// Create the label and set its bounds to the size of the screen
		JLabel i4 = new JLabel(scaledImageIcon);
		i4.setBounds(0, 0, screenSize.width, screenSize.height-120);

		// Add the label to the panel
		panel.add(i4);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 100));//green wala
		panel_2.setBounds(400, 71, 552, 526);
		i4.add(panel_2);
		



//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(255,255,255));
//		panel.setBounds(0, 0, 1362, 808);
//		contentPane.add(panel);
//		panel.setLayout(null);

		JButton btnNewButton = new JButton("Signup as Donor");
		btnNewButton.setBounds(560, 150, 260, 60);
		i4.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Donor_SignUp().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
	
		
		
		
		JButton btnUserLogin = new JButton("Login as Donor");
		btnUserLogin.setBounds(560, btnNewButton.getY() + btnNewButton.getHeight() + 30, 260, 60);
		i4.add(btnUserLogin);
		btnUserLogin.setForeground(new Color(0, 0, 0));
		btnUserLogin.setBackground(new Color(230, 230, 250));
		btnUserLogin.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 24));


		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Donor().setVisible(true);

			}
		});
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		

		JButton btnNewButton_1 = new JButton("Signup as Receiver");
		btnNewButton_1.setBounds(560, btnUserLogin.getY() + btnUserLogin.getHeight() + 30, 260, 60);
		i4.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Receiver_SignUp().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		
		JButton btnUserLogin_1 = new JButton("Login as Receiver");
		btnUserLogin_1.setBounds(560, btnNewButton_1.getY() + btnNewButton_1.getHeight() + 30, 260, 60);
		i4.add(btnUserLogin_1);
		btnUserLogin_1.setForeground(new Color(0, 0, 0));
		btnUserLogin_1.setBackground(new Color(230, 230, 250));
		btnUserLogin_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));

		btnUserLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Receiver().setVisible(true);
  
			}
		});
		btnUserLogin_1.setFont(new Font("Tahoma", Font.BOLD, 24));

	}
}

