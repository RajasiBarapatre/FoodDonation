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
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Component;

public class feedback extends JFrame {

	private JPanel contentPane;
	private Connection conn;
	private JTextField tf1;



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
	public feedback() {
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
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\mainframebg.jpg");

		// Create a new image icon with the scaled image
		Image scaledImage = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

		// Create the label and set its bounds to the size of the screen
		JLabel i4 = new JLabel(scaledImageIcon);
		i4.setBounds(0, 0, screenSize.width, screenSize.height);

		// Add the label to the panel
		panel.add(i4);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 60));//green wala
		panel_2.setBounds(400, 71, 552, 526);
		i4.add(panel_2);
		
		JLabel l = new JLabel("Any Suggestion");
		l.setFont(new Font("Tahoma", Font.BOLD, 30));
		l .setBackground(new Color(128, 0, 128,60));
		panel_2.add(l);
		

		
		JTextArea ta = new JTextArea();
		ta.setFont(new Font("Tahoma", Font.BOLD, 16));
		ta.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		ta.setBackground(new Color(255,255,255));

		ta.setBounds(480, 140, 400, 400);
		ta.setLineWrap(true); // enable line wrapping
		ta.setWrapStyleWord(true); // wrap at word boundaries

		i4.add(ta);
		
		//400, 71, 552, 526
		JButton ok = new JButton("OK");
		i4.add(ok);
		ok.setBounds(600, 601, 70, 40);
		ok.setForeground(new Color(0, 0, 0));
		ok.setBackground(new Color(255, 255, 255));
		ok.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		new Dbms_User().setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Feedback Submitted ");
				ta.setText("");
			}
		});
		ok.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		

		// add the panel to another container (such as a JFrame)
		//.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("<----");
		btnNewButton.setBounds(1180, 601, 80, 40);
		i4.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new intro().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		
	}
}
