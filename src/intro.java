package dbms;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import java.awt.Component;

public class intro extends JFrame {

	private JPanel contentPane;
	private Connection conn;



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

			System.out.println("Database contains:");
			String query = "select * from admins" ;
			System.out.println("");
			rs=stmt.executeQuery(query);

			while(rs.next())
			{
				int id=rs.getInt("UserId");

				String pwd=rs.getString("Password");
				String loca=rs.getString("Location");
				String email=rs.getString("Email_Id");

				System.out.println("Id : "+id+" \npwd : "+pwd+"\n Location : "+loca+"\n Email_id"+email);

			}
		}
		catch(Exception e) {

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro frame = new intro();
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
	public intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	
		

    
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Load the image
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\intro1.jpg");

		// Create a new image icon with the scaled image
		Image scaledImage = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

		// Create the label and set its bounds to the size of the screen
		JLabel i4 = new JLabel(scaledImageIcon);
		i4.setBounds(0, 0, screenSize.width, screenSize.height);

		// Add the label to the panel
		panel.add(i4);


		JLabel nameLabel = new JLabel("Plate2Palate");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setBounds(250, 40, 250, 30);
		i4.add(nameLabel);
		
				

		ImageIcon img=new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\logo4.jpg");
		int w=img.getIconWidth();
		int h=img.getIconHeight();
		setPreferredSize(new Dimension(w,h));
		JLabel i3 = new JLabel(img);
		//i3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		i3.setBackground(Color.GRAY);
		i3.setBounds(0, 0, 178, 100);
		i4.add(i3);

	
		
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setLayout(null);
		buttonPanel.setOpaque(false); // make the panel transparent
		buttonPanel.setBounds(screenSize.width - 380, 40, 350, 100);
		
		
		JButton feedback = new JButton("Feedback");
		feedback.setBounds(210, 50, 120, 40);
		feedback.setForeground(new Color(0, 0, 0));
		feedback.setBackground(new Color(197, 227, 132));
		feedback.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black));
		feedback.setFont(new Font("Tahoma", Font.BOLD, 22));
	//	feedback.setLayout(null);

		feedback.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Handle feedback button click
		    	
		    	 new feedback().setVisible(true);
		    }
		});
		
		
		
		
		JButton review= new JButton("Contact Us");
		review.setBounds(110, 40, 100, 30);
		review.setForeground(new Color(0, 0, 0));
		review.setBackground(new Color(197, 227, 132));
		review.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black));
		review.setFont(new Font("Tahoma", Font.BOLD, 22));
		review.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Handle feedback button click
		        new review().setVisible(true);


		    }
		});

		   
		
		
		
		JButton abt = new JButton("About");
		abt.setBounds(0, 40, 90, 30);
		abt.setForeground(new Color(0, 0, 0));
		abt.setBackground(new Color(197, 227, 132));
		abt.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.black));
		abt.setFont(new Font("Tahoma", Font.BOLD, 22));
		abt.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Handle feedback button click
		    	
		    	
		    	int numDonors = 0; // initialize the variable to 0
		    	int numReceiver = 0;
		    	
		    	int numOrder = 0;

		    	try {
		    		try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					System.out.println("Connection Succeded..............................");
					//stmt=conn.createStatement();
					Statement stmt = conn.createStatement();
					String query = "SELECT (SELECT COUNT(*) FROM donor) AS num_donors, (SELECT COUNT(*) FROM receiver) AS num_receivers,(SELECT COUNT(*) FROM order_completed) AS num_ord";
					
					
					ResultSet rs = stmt.executeQuery(query);
					

					
					if (rs.next()) {
						 numDonors = rs.getInt("num_donors");
					     numReceiver = rs.getInt("num_receivers");// store the query result in the variable
					     numOrder = rs.getInt("num_ord");// store the query result in the variable

				        new about(numDonors,numReceiver,numOrder).setVisible(true);

				    }

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		    	
			}
		});


		
	

		
		
		
		
		
		

//		JButton review = new JButton("");
//		review.setBounds(110, 40, 90, 30);
//		review.setForeground(new Color(0, 0, 0));
//		review.setBackground(new Color(230, 230, 250,90));
//		review.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));
//
//		review.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//new Dbms_Page1().setVisible(true);
//
//			
//				
//				
//				
//			}
//		});
//		review.setFont(new Font("Tahoma", Font.BOLD, 22));
//		
//		
//		JLabel label1 = new JLabel("Review");
//		label1.setBounds(10, 5, 100, 20); // set the position of the label
//
//        review.add(label1);
//        
//
//		JButton abt = new JButton("");
//		abt.setBounds(0, 40, 90, 30);
//		abt.setForeground(new Color(0, 0, 0));
//		abt.setBackground(new Color(230, 230, 250,90));
//		abt.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));
//
//		abt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//new Dbms_Page1().setVisible(true);
//			}
//		});
//		abt.setFont(new Font("Tahoma", Font.BOLD, 22));
//		JLabel label2 = new JLabel("About");
//		label2.setBounds(10, 5, 100, 20); // set the position of the label
//
//        abt.add(label2);
//        
//
//
//		// Add the buttons to the button panel
		
		buttonPanel.add(review);
		buttonPanel.add(abt);
		buttonPanel.add(feedback);
		i4.add(buttonPanel);

		
		
		
		
		
		
		






		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBounds(500, 550, 208, 80);
		i4.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(197, 227, 132));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dbms_Page1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));

		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.setBounds(800, 550, 208, 80);
		i4.add(btnUserLogin);
		btnUserLogin.setForeground(new Color(0, 0, 0));
		btnUserLogin.setBackground(new Color(197, 227, 132));
		btnUserLogin.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						new Dbms_User().setVisible(true);
			}
		});
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		//	


	}
}























