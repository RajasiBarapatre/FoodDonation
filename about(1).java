package dbms;





import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

public class about extends JFrame {

	private JPanel contentPane;



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
	public about(int q1,int q2,int q3) {
		
		int numDonors=q1;
		int numReceiver=q2;
		int numOrder=q3;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(2, 2));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

				// Load the image
				ImageIcon imageIcon = new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\mainframebg.jpg");

				// Create a new image icon with the scaled image
				Image scaledImage = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
				ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

				// Create the label and set its bounds to the size of the screen
				JLabel i4 = new JLabel(scaledImageIcon);
				i4.setBounds(0, 0, screenSize.width, screenSize.height);

				// Add the label to the panel
				panel.add(i4);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(107, 142, 35,100));
		i4.add(panel1, BorderLayout.CENTER);
		panel1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		panel1.setBounds(90, 200, 202, 126);
//		
//		JLabel label = new JLabel("Donors: " + numDonors);
//		label.setFont(new Font("Tahoma", Font.BOLD, 18));
//		label.setForeground(Color.BLACK);
//
//		// Add the label to the panel
//		panel1.add(label);
//		
//		//panel1.setLayout(null);
//		
//		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(107, 142, 35,100));
		panel2.setBounds(300, 200, 202, 126);
		i4.add(panel2, BorderLayout.CENTER);
		panel2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(107, 142, 35,100));
		panel3.setBounds(160, 350, 262, 100);
		i4.add(panel3, BorderLayout.CENTER);
		panel3.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		
//		
//		JLabel label_1 = new JLabel("Receivers: " + numReceiver);
//		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
//		label_1.setForeground(Color.BLACK);
//
//		// Add the label to the panel
//		panel2.add(label_1);
				
				
				JLabel donorLabel = new JLabel("DONORS  " );
				JLabel donorLabel1 = new JLabel(numDonors+" ");

				
				donorLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
				donorLabel.setForeground(Color.BLACK);
				donorLabel1.setFont(new Font("Tahoma", Font.BOLD, 35));
				donorLabel1.setForeground(Color.BLACK);

				// Create a JLabel for receivers and set its text to the query result
				JLabel receiverLabel = new JLabel("RECEIVERS " );
				JLabel receiverLabel1 = new JLabel(numReceiver+" ");

				
				receiverLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
				receiverLabel.setForeground(Color.BLACK);
				receiverLabel1.setFont(new Font("Tahoma", Font.BOLD, 35));
				receiverLabel1.setForeground(Color.BLACK);
		
				
				JLabel ordLabel = new JLabel("Successful Donations"  );
				JLabel ordLabel1 = new JLabel(numOrder+" ");

				
				ordLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
				ordLabel.setForeground(Color.BLACK);
				ordLabel1.setFont(new Font("Tahoma", Font.BOLD, 35));
				ordLabel1.setForeground(Color.BLACK);
		
	
				JLabel abts = new JLabel("ABOUT US  " );
				abts.setFont(new Font("Tahoma", Font.BOLD, 30));
				abts.setForeground(Color.BLACK);
				abts.setBounds(800, 71, 262, 100);
				i4.add(abts);
				
				JLabel abts1 = new JLabel("<html>Food waste refers to the decrease in the quantity or quality of food resulting from decisions and actions by retailers, food service providers and consumers. Food is wasted in many ways."
					    + "<br>"
					    + "<br>"
					    + "Large quantities of wholesome edible food are of unused or left over and discarded from household kitchens and esting establishments."
					    + "<br>"
					    + "<br>"

					    + "Less food loss and waste would lead to more efficient land use and better water resource management with positive impacts on climate change and livelihoods.");

				abts1.setFont(new Font("Tahoma", Font.BOLD, 16));
				abts1.setForeground(Color.BLACK);
				abts1.setBounds(680, 90, screenSize.width-680, 500);
				i4.add(abts1);

				 //Add the labels to the panel
				panel1.add(donorLabel);
				panel1.add(donorLabel1);
				panel2.add(receiverLabel);
				panel2.add(receiverLabel1);
				
				panel3.add(ordLabel);
				panel3.add(ordLabel1);

				
				
				JButton btnNewButton = new JButton("<----");
				btnNewButton.setBounds(1180, 550, 80, 50);
				i4.add(btnNewButton);
				btnNewButton.setForeground(new Color(0, 0, 0));
				btnNewButton.setBackground(new Color(197, 227, 132));
				btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new intro().setVisible(true);
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		
		
		
		
		
		
		
		
		
		
	}



protected void JOptionPane(ActionListener actionListener, String string) {
	// TODO Auto-generated method stub
	
}
}
