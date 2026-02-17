package dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Dbms_Page1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField tf2;
	private JTextField tf3;
	private JTextField tf4;
	//String loca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		PreparedStatement pst=null;
		JTable table;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
		}
		catch(Exception e) {
			
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dbms_Page1 frame = new Dbms_Page1();
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
	public  Dbms_Page1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setName("Frame 1");
		//contentPane.setBorder(BorderFactory.createBevelBorder(1.,Color.black,Color.blue));
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
		
		ImageIcon imageIcon_1= new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\userlogo.jpg");

		// Create a new image icon with the scaled image
		//Image scaledImage_1= imageIcon_1.getImage().getScaledInstance(420, 71, Image.SCALE_SMOOTH);
		//ImageIcon scaledImageIcon_1 = new ImageIcon(scaledImage_1);
		

		// Create the label and set its bounds to the size of the screen
		JLabel i5 = new JLabel(imageIcon_1);
		i5.setBounds(412, 268, 19, 19);
		i5.setBackground( new Color(0,0,0,100));
		
		i4.add(i5);
		ImageIcon imageIcon_2= new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\password2.jpg");
		JLabel i6 = new JLabel(imageIcon_2);
		i6.setBounds(412, 320, 19, 19);
		i6.setBackground( new Color(0,0,0));
		//panel.setLayout(null);
		i4.add(i6);
		
		
		ImageIcon imageIcon_3= new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\email_1.jpg");

		
		JLabel i7 = new JLabel(imageIcon_3);
		i7.setBounds(412, 420, 19, 19);
		i7.setBackground( new Color(0,0,0));
		
		i4.add(i7);
		
ImageIcon imageIcon_4= new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\location_2.jpg");

		
		JLabel i8 = new JLabel(imageIcon_4);
		i8.setBounds(412, 370, 19, 19);
		i8.setBackground( new Color(0,0,0));
		
		i4.add(i8);
//		
		JLabel lblNewLabel = new JLabel("USERID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setSize(new Dimension(10, 0));
		lblNewLabel.setBounds(438, 260, 159, 35);
		
		i4.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(438, 310, 142, 35);
		i4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1= new JLabel("LOCATION");
		lblNewLabel_1_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1_1_1.setBounds(438, 360, 132, 35);
		i4.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL-ID");
		lblNewLabel_1_1_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1_1.setBounds(438, 410, 122, 35);
		i4.add(lblNewLabel_1_1_1_1);
//		
//		ImageIcon img=new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\logo4.jpg");
//		int w=img.getIconWidth();
//    	int h=img.getIconHeight();
//    	setPreferredSize(new Dimension(w,h));
//		JLabel i3 = new JLabel(img);
//		//i3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		i3.setBackground(Color.GRAY);
//		i3.setBounds(0, 0, 200, 100);
//		contentPane.add(i3);
//		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.BOLD, 22));
		tf1.setBounds(626, 250, 217, 40);
		tf1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf1);
		tf1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128,128,128));
		//btnNewButton.setMargin(new Insets(10,10,10,10));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//ResultSet rs=null;
				ResultSet rs1=null;
	
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					//System.out.println("Connection Succeded..............................");
					Statement stmt=conn.createStatement();
					

					String unm = tf1.getText();
					String pwd = tf2.getText();
					String loca=tf3.getText();
					String email=tf4.getText();
					
					
					
					//String query = "Select * from admins where UserId = '"+unm+"' and Password= '"+pwd+"'";
					String query = "Select * from admins where UserId = '"+unm+"' and Password = '"+pwd+"'  and Location = '"+loca+"'   and Email_Id = '"+email+"'  ";
		            rs1 = stmt.executeQuery(query);
		            if(rs1.next()) {
		            	JOptionPane(this,"Success");
		            	new MainFrame(loca).setVisible(true);
		            	
		            }
		            else {
		            	JOptionPane(this,"Username or pswd wrong...");
		            	tf1.setText("");
		            	tf2.setText("");
		            	tf3.setText("");
		            	tf4.setText("");
		            }
		            
				}
				catch(Exception e1) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(405, 524, 157, 57);

		i4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(128,128,128));
		btnNewButton_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(600, 524, 157, 57);
		
		i4.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new intro().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(790, 524, 157, 57);
		i4.add(btnNewButton_1_1);
		
//		ImageIcon icon=new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\logokhanaval.jpg");
//		JLabel logo = new JLabel(icon);
//		logo.setBounds(1,0,190,115);
//		contentPane.add(logo);
//		
//		JLabel l1 = new JLabel("	GarsKhanaval.com");
//		contentPane.add(l1);
//    	l1.setBounds(175,0,1250,115);
//    	l1.setFont(new Font ("Serif",Font.BOLD,52));
//        l1.setForeground(Color.white);
//        l1.setOpaque(true);
//        l1.setBackground(Color.darkGray);
        
        tf2 = new JPasswordField();
		tf2.setFont(new Font("Tahoma", Font.BOLD, 22));
        tf2.setBounds(626, 310, 217, 40);
		tf2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

        i4.add(tf2);
        
        tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.BOLD, 22));
        tf3.setBounds(626, 360, 217, 40);
		tf3.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

        i4.add(tf3);
        
        tf4 = new JTextField();
        tf4.setBounds(626, 410, 217, 40);
		tf4.setFont(new Font("Tahoma", Font.BOLD, 22));
		tf4.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

        i4.add(tf4);
        
        JLabel lblAdminLogin = new JLabel("Admin Login");
        lblAdminLogin.setFont(new Font(" Serif", Font.BOLD|Font.ITALIC, 70));
        lblAdminLogin.setBounds(481, 125, 567, 90);
        i4.add(lblAdminLogin);
        
        //return loca;
        
	}

	protected void JOptionPane(ActionListener actionListener, String string) {
		// TODO Auto-generated method stub
		
	}
}
