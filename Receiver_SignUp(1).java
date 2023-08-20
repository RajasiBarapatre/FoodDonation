package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

//import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Receiver_SignUp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model ;
	private JTextField nm;
	private JTextField ph;
	private JTextField email;
	private JTextField type;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField f1;
	private JTextField f3;
	private JTextField f4;
	private JTable table_1;
	private JTextField f2;
	private JTextField tf2,tf1,tf3,tf4,tf5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiver_SignUp frame = new Receiver_SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public Receiver_SignUp() {
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
		panel_2.setBounds(200, 71, 850, 550);
		i4.add(panel_2);



		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setSize(new Dimension(10, 0));
		lblNewLabel.setBounds(438, 260, 159, 35);

		i4.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Phone No. ");
		lblNewLabel_1.setSize(new Dimension(10, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(438, 310, 142, 35);
		i4.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1= new JLabel("Email_ID");
		lblNewLabel_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(438, 360, 132, 35);
		i4.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(438, 410, 122, 35);
		i4.add(lblNewLabel_1_1_1);


		//
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf1.setBounds(626, 250, 217, 40);
		tf1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf2.setBounds(626, 310, 217, 40);
		tf2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf2);

		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf3.setBounds(626, 360, 217, 40);
		tf3.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf3);

		tf4 = new JPasswordField();
		tf4.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf4.setBounds(626, 410, 217, 40);
		tf4.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf4);



		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128,128,128));
		//btnNewButton.setMargin(new Insets(10,10,10,10));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));


		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				ResultSet rs1=null;

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					System.out.println("Connection Succeded..............................");
					Statement stmt=conn.createStatement();

					String nm = tf1.getText();
					String ph = tf2.getText();
					String mail=tf3.getText();
					String pwd=tf4.getText();
					String query = "Insert into receiver(Name,Phno,Email_id,password) values(?,?,?,?)";
					PreparedStatement ps2 = conn.prepareStatement(query);
					ps2.setString(1,nm);
					ps2.setString(2,ph);
					ps2.setString(3,mail);
					ps2.setString(4,pwd);

					ps2.execute();

					JOptionPane.showMessageDialog(null,"Sign Up Successfull !!");


				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"User already exists !!");
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(330, 524, 187, 57);

		i4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Clear form");
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
		btnNewButton_1.setBounds(576, 524, 187, 57);

		i4.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(new Color(128,128,128));
		btnNewButton_1_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dbms_User().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(818, 524, 187, 57);
		i4.add(btnNewButton_1_1);

		ImageIcon icon=new ImageIcon("C:\\Users\\dhamp\\eclipse-workspace\\Miniproject_dbms\\images\\logokhanaval.jpg");
		JLabel logo = new JLabel(icon);
		logo.setBounds(1,0,190,115);
		i4.add(logo);

		JLabel lblAdminLogin = new JLabel("Receiver SignUp");
		lblAdminLogin.setFont(new Font(" Serif", Font.BOLD|Font.ITALIC, 70));
		lblAdminLogin.setBounds(410, 100, 567, 90);
		i4.add(lblAdminLogin);

	}

	protected void JOptionPane(ActionListener actionListener, String string)
	{
		// TODO Auto-generated method stub

	}
}



