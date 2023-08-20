package dbms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainFrame extends JFrame {
	private JPanel tablePanel;
	private JPanel contentPane;
	private JLabel label;
	private JTextField tf1;
	private JTextField tf2;
	String arr[];
	String arr1[];
	int count,count1;
	int a,b;
	private boolean labelAdded = false;


	private Connection conn;

	public MainFrame(String loca) {
		// Set up the main JFrame
		String location=loca;
		setTitle("Donor/Receiver Table");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));//bigger one
		panel.setBounds(0, 0, 1362, 808);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel() {
		    @Override
		    protected void paintComponent(Graphics g) {
		        Graphics2D g2d = (Graphics2D) g;
		        int width = getWidth();
		        int height = getHeight();
		        Color color1 = new Color(0, 100, 0); // light green
		        Color color2 = new Color(144, 238, 144); // dark green
		        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
		        g2d.setPaint(gp);
		        g2d.fillRect(0, 0, width, height);
		    }
		};
		panel_2.setBounds(20, 21, 302, 726);
		panel.add(panel_2);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0,100));//black
		panel_3.setBounds(342, 1, 951, 746);
		panel.add(panel_3);
		panel_3.setLayout(null);


		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.pink);
		tabbedPane.setBounds(10, -22, 931, 782);
		panel_3.add(tabbedPane);

		JPanel panel_11 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_11, null);
		panel_11.setBackground(new Color(50, 205, 50));
		panel_11.setLayout(null);
		
		

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);


		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 895, 646);
		panel_7.add(scrollPane);




		// Set up the MySQL connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/dbms";
			String user = "root";
			String password = "1517";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
		JPanel buttonPanel = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        JPanel buttonPanel3 = new JPanel();
        JPanel buttonPanel4 = new JPanel();
        JPanel buttonPanel5 = new JPanel();
        JPanel buttonPanel6=new JPanel();




		JButton donorBtn = new JButton("Donor ");
		donorBtn.setBounds(0, 10, 150, 56);
		donorBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		donorBtn.setForeground(new Color(0, 0, 0));
		//donorBtn.setBackground(new Color(0, 0, 0));
       // donorBtn.setContentAreaFilled(false);



		donorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Dbms_Page1 obj=new Dbms_Page1();






					Statement stmt = conn.createStatement();
					String query = "select * from donor inner join request_donor on donor.Donor_Id=request_donor.Donor_Id where request_donor.Location='"+location+"' ";
					ResultSet rs = stmt.executeQuery(query);


					DefaultTableModel model = new DefaultTableModel();                                                   
					JTable table = new JTable(model);

					model.addColumn("Donor_Id");
					model.addColumn("Name");
					model.addColumn("Phno");
					model.addColumn("Email_id");




					while (rs.next()) {
						Object[] row = new Object[4];
						row[0] = rs.getInt("Donor_Id");
						row[1] = rs.getString("Name");
						row[2] = rs.getString("Phno");
						row[3] = rs.getString("Email_id");









						model.addRow(row);
					}

					JScrollPane scrollPane = new JScrollPane(table);
					tablePanel.removeAll();
					tablePanel.add(scrollPane);
					tablePanel.revalidate();
					tablePanel.repaint();

					//tablePanel.add(label);

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});




		JButton receiverBtn = new JButton("Receiver ");
		receiverBtn.setBounds(0, 100, 402, 565);
		receiverBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		receiverBtn.setForeground(new Color(0, 0, 0));
		//receiverBtn.setBackground(new Color(0, 0, 0));





		receiverBtn.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {

				try {



					Statement stmt = conn.createStatement();
					String query = "select * from receiver inner join request_receiver on receiver.Receiver_Id=request_receiver.Receiver_Id where request_receiver.Location='"+location+"' ";

					ResultSet rs = stmt.executeQuery(query);

					DefaultTableModel model = new DefaultTableModel();
					JTable table = new JTable(model);

					model.addColumn("Receiver_Id");
					model.addColumn("Name");
					model.addColumn("Phno");
					model.addColumn("Email_id");




					while (rs.next()) {
						Object[] row = new Object[4];
						row[0] = rs.getInt("Receiver_Id");
						row[1] = rs.getString("Name");
						row[2] = rs.getString("Phno");
						row[3] = rs.getString("Email_id");


						model.addRow(row);
					}

					JScrollPane scrollPane = new JScrollPane(table);
					tablePanel.removeAll();
					tablePanel.add(scrollPane);
					tablePanel.revalidate();
					tablePanel.repaint();


				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});



		//#########################################################

		JButton pending = new JButton("Pending");
		pending .setBounds(0, 90, 150, 56);
		pending .setFont(new Font("Tahoma", Font.BOLD, 30));
		pending.setForeground(new Color(0, 0, 0));
		//pending .setBackground(new Color(0, 0, 0));
		pending.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				try {
					Statement stmt = conn.createStatement();
					String query = "select * from request_donor ";
					ResultSet rs = stmt.executeQuery(query);

					DefaultTableModel model1 = new DefaultTableModel();
					JTable table1 = new JTable(model1);
					model1.addColumn("Request Donor Id");
					model1.addColumn("Quantity");
					model1.addColumn("Category");
					model1.addColumn("Location");


					while (rs.next()) {
						Object[] row = new Object[4];
						// row[3] = rs.getString("Quantity");
						row[0] = rs.getString("Request_Donor_Id");
						row[2] = rs.getString("Category");
						row[3] = rs.getString("Location");
						
						row[1] = rs.getString("Quantity");

						model1.addRow(row);
					}

					String query2 = "select * from request_receiver ";
					ResultSet rs2 = stmt.executeQuery(query2);

					DefaultTableModel model2 = new DefaultTableModel();
					JTable table2 = new JTable(model2);
					model2.addColumn("Request Receiver ID");
					model2.addColumn("Quantity");
					model2.addColumn("Category");
					model2.addColumn("Location");

					while (rs2.next()) {
						Object[] row = new Object[4];
						row[0] = rs2.getString("Request_Receiver_Id");
						row[2] = rs2.getString("Category");
						row[3] = rs2.getString("Location");
						row[1] = rs2.getString("Quantity");

						model2.addRow(row);


					}


					JPanel panel = new JPanel();
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					panel.add(new JScrollPane(table1));
					panel.add(new JScrollPane(table2));

					tablePanel.removeAll();
					tablePanel.add(panel);
					tablePanel.revalidate();
					tablePanel.repaint();

				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});






		//#########################################


		JButton match = new JButton("Find Matches");
		match .setBounds(0, 90, 150, 56);
		match .setFont(new Font("Tahoma", Font.BOLD, 30));
		match.setForeground(new Color(0, 0, 0));
		
		
		//match .setBackground(new Color(0, 0, 0));
		match.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = conn.createStatement();
					String query = "select * from request_donor inner join request_receiver on request_donor.Category= request_receiver.Category and  request_donor.Location =request_receiver.Location and request_receiver.Location='" + location+ "'";
					ResultSet rs = stmt.executeQuery(query);

					DefaultTableModel model1 = new DefaultTableModel();
					JTable table1 = new JTable(model1);
					model1.addColumn("Request Donor Id");
					//model1.addColumn("Donor Name");
					model1.addColumn("Quantity");
					model1.addColumn("Category");
					model1.addColumn("Location");
					
					
					
					 JLabel label1 = new JLabel("Donors's Request Pending",JLabel.CENTER);
					 label1.setFont(new Font("Tahoma", Font.BOLD, 15));
//					 JPanel panel = new JPanel();
					 arr=new String[100];
					 arr1=new String[100];
					int i=0,j=0;
					count=0;
					while (rs.next()) {
						Object[] row = new Object[4];
						// row[3] = rs.getString("Quantity");
						row[2] = rs.getString("Category");
						row[3] = rs.getString("Location");
						row[0] = rs.getString("Request_Donor_Id");
						arr[i]=rs.getString("Request_Donor_Id");
						i++;
						count++;
						row[1] = rs.getString("Quantity");
						//row[1]=rs.getString("Name");

						model1.addRow(row);
					}

					String query2 = "select * from request_donor inner join request_receiver on request_donor.Category= request_receiver.Category and  request_donor.Location =request_receiver.Location and request_receiver.Location='" + location+ "'";
					ResultSet rs2 = stmt.executeQuery(query2);
					
					
					
					

					DefaultTableModel model2 = new DefaultTableModel();
					JTable table2 = new JTable(model2);
					model2.addColumn("Request Receiver ID");
					//model2.addColumn("Receiver Name");
					model2.addColumn("Quantity");
					model2.addColumn("Category");
					model2.addColumn("Location");
					count1=0;
					while (rs2.next()) {
						
						Object[] row = new Object[4];
						row[0] = rs2.getString("Request_Receiver_Id");
						arr1[j]=rs2.getString("Request_Receiver_Id");
						j++;
						count1++;
						row[2] = rs2.getString("Category");
						row[3] = rs2.getString("Location");
						row[1] = rs2.getString("Quantity");
						//row[1]=rs2.getString("Name");

						model2.addRow(row);
					}
					for(int o=0;o<count;o++)
					{
						System.out.println(arr[o]);
					}
					for(int o=0;o<count1;o++)
					{
						System.out.println(arr1[o]);
					}

					JLabel lblNewLabel_1_1_1 = new JLabel("Enter Receiver_Id :");
					lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblNewLabel_1_1_1 .setBackground(new Color(128, 0, 128));

					//lblNewLabel_1_1_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));




					JLabel lblNewLabel_1_1_1_1 = new JLabel("Enter Donor_Id :");
					lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblNewLabel_1_1_1_1 .setBackground(new Color(128, 0, 128));

					//lblNewLabel_1_1_1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));


					tf2 = new JTextField();
					tf2.setFont(new Font("Tahoma", Font.BOLD, 10));
					tf2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));
					
					

					tf1 = new JTextField();
					tf1.setFont(new Font("Tahoma", Font.BOLD, 10));
					tf1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.blue));
					

					// Create a panel with a GridLayout that has 1 row and 2 columns
					JPanel inputPanel = new JPanel(new GridLayout(1, 2));
					inputPanel.add(lblNewLabel_1_1_1);
					inputPanel.add(tf1);
					inputPanel.add(lblNewLabel_1_1_1_1);
					inputPanel.add(tf2);

//#####################
					JButton okButton = new JButton("OK");
					okButton .setBounds(400, 400 ,150, 56);
					okButton .setFont(new Font("Tahoma", Font.BOLD, 15));
					
					okButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try {
								String donorId = tf2.getText();
								// int donorId1 = Integer.parseInt(donorId);
								String receiverId = tf1.getText();
								
								
								
							//	 int receiverId1 = Integer.parseInt(receiverId);
								
								Integer quantity=0;
								String category=null;String locations=null;
									 a=0;
									for(int k=0;k<count;k++)
									{
										if(arr[k].contains(receiverId))
										{
											System.out.println("HII");
											System.out.println(receiverId);
											a=1;
											System.out.println(a);
											
											

										}
									}
									 b=0;
									for(int k=0;k<count1;k++)
									{
										if(arr1[k].contains(donorId))
									{
											System.out.println(donorId);
											b=1;
											System.out.println(b);
//											break;

										}
									}
									if(a==0 && b==0)
									{
									// System.out.println("hi");
										String query = "SELECT Quantity,Category,Location FROM request_donor WHERE Request_Donor_Id='"+donorId+"'";
							            PreparedStatement stmt = conn.prepareStatement(query);
							           // stmt.setString(1, donorId);
							            ResultSet rs = stmt.executeQuery();
							            while (rs.next()) 
							            {
							                quantity = rs.getInt("Quantity");
							                category = rs.getString("Category");
							                locations = rs.getString("Location");
							            }
							            
							            // Insert the values into the order_completed1 table
							            if (quantity != null && category != null && locations != null) 
							            {
							                String insertQuery = "INSERT INTO order_completed1(Receiver_Id, Donor_Id, Quantity, Category, Location)  VALUES (?,?,?,?,?) ";
							                PreparedStatement prepStmt = conn.prepareStatement(insertQuery);
							                prepStmt.setString(1, receiverId);
							                prepStmt.setString(2, donorId);
							                prepStmt.setInt(3, quantity);
							                prepStmt.setString(4, category);
							                prepStmt.setString(5, locations);
							                prepStmt.executeUpdate();
							            }
										
										
										String query3="delete from request_donor where Request_Donor_Id='"+donorId+"' " ;
										Statement prep_stmt=conn.prepareStatement(query3);
	
										prep_stmt=conn.prepareStatement(query3);
										//prep_stmt.setInt(1,mid);
										prep_stmt.execute(query3);
										
										String query1="delete from request_receiver where Request_Receiver_Id='"+receiverId+"'";
										Statement prep_stmt1=conn.prepareStatement(query1);
	
										prep_stmt1=conn.prepareStatement(query1);
										//prep_stmt.setInt(1,mid);
										prep_stmt1.execute(query1);
										// Retrieve the values of quantity, category, and location from the database
										JOptionPane.showMessageDialog(null, "Order completed successfully.");
									
									}
									else
									{
										JOptionPane.showMessageDialog(null,"Enter correct ID !!");
									}
									
									
						        } catch (SQLException ex) {
						            ex.printStackTrace();
						        }
							

						}
						


						
					});


					
							
							



					

					JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					buttonPanel.add(okButton);
					JPanel gapPanel = new JPanel();
					gapPanel.setPreferredSize(new Dimension(0, 20));

					JLabel label2 = new JLabel("Receiver Pending Requests",JLabel.CENTER);
					label2.setFont(new Font("Tahoma", Font.BOLD, 15));
					gapPanel.add(label2);



					JPanel panel = new JPanel();
					panel.add(label1);
					panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
					panel.add(new JScrollPane(table1));
					panel.add(gapPanel); 
					panel.add(new JScrollPane(table2));
					panel.add(inputPanel);
					panel.add(buttonPanel);

					tablePanel.removeAll();
					tablePanel.add(panel);
					tablePanel.revalidate();
					tablePanel.repaint();
					tablePanel.repaint();


				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});


		//#############################################################


		JButton OrderBtn = new JButton("Order completed");
		OrderBtn .setBounds(0, 10, 150, 56);
		OrderBtn .setFont(new Font("Tahoma", Font.BOLD, 30));
		OrderBtn .setForeground(new Color(0, 0, 0));
		//OrderBtn .setBackground(new Color(0, 0, 0));
		OrderBtn .addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			        
				try {
					Statement stmt = conn.createStatement();
					//String query = "select * from order_completed1 inner join request_receiver on order_completed1.Location=request_receiver.Location  where request_receiver.Location='" + location+ "' ";
					String query = "select * from order_completed1 Where Location='"+location+"'";
					
					ResultSet rs = stmt.executeQuery(query);

					DefaultTableModel model = new DefaultTableModel();
					JTable table = new JTable(model);

					model.addColumn("Order_Id");
					model.addColumn("Receiver_Id");
					model.addColumn("Donor_Id");
					model.addColumn("Quantity");
					model.addColumn("Category");




					while (rs.next()) {
						Object[] row = new Object[5];
						row[0] = rs.getInt("Order_Id");
						row[1] = rs.getString("Receiver_Id");
						row[2] = rs.getString("Donor_Id");
               			row[3] = rs.getString("Quantity");
						row[4] = rs.getString("Category");
						model.addRow(row);
					}

					JScrollPane scrollPane = new JScrollPane(table);
					tablePanel.removeAll();
					tablePanel.add(scrollPane);
					tablePanel.revalidate();
					tablePanel.repaint();


				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		JButton logout = new JButton("<---");
		logout .setBounds(91, 750, 150, 726);
		logout .setFont(new Font("Tahoma", Font.BOLD, 40));
		logout.setForeground(new Color(0, 0, 0));
		//logout .setBackground(new Color(0, 0, 0));
		logout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new intro().setVisible(true);
				
			}
		}
		);
		
	
		buttonPanel.add(donorBtn);
		buttonPanel2.add(receiverBtn);
		buttonPanel3.add(OrderBtn);
		buttonPanel4.add(match);
		buttonPanel5.add(pending);
		buttonPanel6.add(logout);

		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());

		panel_2.add(buttonPanel);
		buttonPanel.setBounds(0, 10, 150, 56);
		buttonPanel.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel.setForeground(new Color(0, 0, 0));
		buttonPanel.setBackground(new Color(0, 0, 0));

		buttonPanel2.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel2.setBounds(0, 10, 402, 565);
		buttonPanel2.setForeground(new Color(0, 0, 0));
		buttonPanel2.setBackground(new Color(0, 0, 0));
		panel_2.add(buttonPanel2);

		panel_2.add(buttonPanel3);
		buttonPanel3.setBounds(0, 10, 150, 56);
		buttonPanel3.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel3.setForeground(new Color(0, 0, 0));
		buttonPanel3.setBackground(new Color(0, 0, 0));



		panel_2.add(buttonPanel4);
		buttonPanel4.setBounds(0, 10, 150, 56);
		buttonPanel4.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel4.setForeground(new Color(0, 0, 0));
		buttonPanel4.setBackground(new Color(0, 0, 0));

		panel_2.add(buttonPanel5);
		buttonPanel5.setBounds(0, 10, 150, 56);
		buttonPanel5.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel5.setForeground(new Color(0, 0, 0));
		buttonPanel5.setBackground(new Color(0, 0, 0));
		
		
		panel_2.add(buttonPanel6);
		buttonPanel6.setBounds(90,100, 180, 76);
		buttonPanel6.setFont(new Font("Tahoma", Font.BOLD, 35));
		buttonPanel6.setForeground(new Color(0, 0, 0));
		buttonPanel6.setBackground(new Color(0, 0, 0));


		tablePanel.setBounds(120, 50, 753, 556);
		panel_11.add(tablePanel);

		setVisible(true);


	}
	protected void JOptionPane(ActionListener actionListener, String string)
	{
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame(" ");

	}
}
