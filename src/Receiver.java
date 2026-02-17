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

public class Receiver extends JFrame {

	private JPanel contentPane;
	private JTextField tf2,tf1,tf3,tf4;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiver frame = new Receiver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public Receiver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setName("Frame 1");
		//contentPane.setBorder(BorderFactory.createBevelBorder(1.,Color.black,Color.black));
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
		panel_2.setBounds(400, 71, 552, 500);
		i4.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Email ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setSize(new Dimension(10, 0));
		lblNewLabel.setBounds(438, 250, 159, 35);

		i4.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Password ");
		lblNewLabel_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(438, 330, 142, 35);
		i4.add(lblNewLabel_1_1);

		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf1.setBounds(626, 250, 159, 35);
		tf1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		i4.add(tf1);
		tf1.setColumns(10);

		tf2 = new JPasswordField();
		tf2.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf2.setBounds(626, 330, 159, 35);
		tf2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
		i4.add(tf2);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128,128,128));
		//btnNewButton.setMargin(new Insets(10,10,10,10));
		btnNewButton.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));


		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ResultSet rs1=null;
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					System.out.println("Connection Succeded..............................");
					Statement stmt=conn.createStatement();
					String email = tf1.getText();
					String pass = tf2.getText();
					if(tf1.getText().isEmpty() || tf2.getText().isEmpty() )
					{
						JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String query = "select * from receiver where Email_id = '"+email+"' and password = '"+pass+"'  ";
						rs1 = stmt.executeQuery(query);
						if(rs1.next())
						{
							JOptionPane(this,"Success");
							new LoggedIn_Receiver(email).setVisible(true);
						}
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Username or password wrong...");
					e1.printStackTrace();
					tf1.setText("");
					tf2.setText("");
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(402, 450, 150, 57);

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
		btnNewButton_1.setBounds(600, 450, 150, 57);
		i4.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(new Color(128,128,128));
		btnNewButton_1_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));

		btnNewButton_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Dbms_User().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(800, 450, 150, 57);
		i4.add(btnNewButton_1_1);

		

		JLabel lblAdminLogin = new JLabel("Receiver Login");
		lblAdminLogin.setFont(new Font(" Serif", Font.BOLD|Font.ITALIC, 70));
		lblAdminLogin.setBounds(430, 115, 567, 90);
		i4.add(lblAdminLogin);

	}

	protected void JOptionPane(ActionListener actionListener, String string) {
		// TODO Auto-generated method stub

	}
}
