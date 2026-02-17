package dbms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class LoggedIn_Receiver extends JFrame
{
	private JPanel tablePanel;
	private JPanel contentPane;
	private JPanel contentPane1;
	private JTextField tf2,tf1,tf3,tf4;
	private Connection conn;
	public LoggedIn_Receiver(String email)
	{

		String Email=email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-12, -3, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0,0));
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
		        Color color1 = new Color(154, 205, 50); // light green
		        Color color2 = new Color(144, 238, 144); // dark green
		        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
		        g2d.setPaint(gp);
		        g2d.fillRect(0, 0, width, height);
		    }
		};
		panel_2.setBounds(20, 21, 302, 726);
		panel.add(panel_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.pink);
		tabbedPane.setBounds(10, -22, 931, 782);
		panel_2.add(tabbedPane);

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/dbms";
			String user = "root";
			String password = "1517";
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		//     JPanel buttonPanel = new JPanel();
		//        JPanel buttonPanel2 = new JPanel();
		//        JPanel buttonPanel3 = new JPanel();
		//        JPanel buttonPanel4 = new JPanel();

		JButton requestBtn = new JButton("Request Form");
		requestBtn.setBounds(0, 10, 150, 56);
		requestBtn.setFont(new Font("Tahoma", Font.BOLD, 28));
		requestBtn.setForeground(new Color(0, 0, 0));
		//requestBtn.setBackground(new Color(0, 0, 0));

		requestBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JScrollPane scrollPane = new JScrollPane();
				tablePanel.removeAll();
				tablePanel.add(scrollPane);
				tablePanel.revalidate();
				tablePanel.repaint();

				try
				{

					JLabel lblNewLabel = new JLabel("Location");
					tablePanel.add(lblNewLabel);
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
					lblNewLabel.setSize(new Dimension(10, 0));
					lblNewLabel.setBounds(150, -100, 875, 700);


					JLabel lblNewLabel_1 = new JLabel("Quantity");
					tablePanel.add(lblNewLabel_1);
					lblNewLabel_1.setSize(new Dimension(10, 0));
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
					lblNewLabel_1.setBounds(150, -50, 875, 700);


					JLabel lblNewLabel_1_1 = new JLabel("Category");
					tablePanel.add(lblNewLabel_1_1);
					lblNewLabel_1_1.setSize(new Dimension(10, 0));
					lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
					lblNewLabel_1_1.setBounds(150, 0, 875, 700);


					JLabel lblNewLabel_1_1_1 = new JLabel("Receiver Type");
					tablePanel.add(lblNewLabel_1_1_1);
					lblNewLabel_1_1_1.setSize(new Dimension(10, 0));
					lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
					lblNewLabel_1_1_1.setBounds(150, 50, 875, 700);


					tf1 = new JTextField();
					tf1.setFont(new Font("Tahoma", Font.BOLD, 20));
					tf1.setBounds(350, 227, 217, 40);
					tf1.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
					tablePanel.add(tf1);
					tf1.setColumns(10);

					tf2 = new JTextField();
					tf2.setFont(new Font("Tahoma", Font.BOLD, 20));
					tf2.setBounds(350, 277, 217, 40);
					tf2.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
					tablePanel.add(tf2);
					tf2.setColumns(10);

					tf3 = new JTextField();
					tf3.setFont(new Font("Tahoma", Font.BOLD, 20));
					tf3.setBounds(350, 327, 217, 40);
					tf3.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
					tablePanel.add(tf3);

					tf4 = new JTextField();
					tf4.setFont(new Font("Tahoma", Font.BOLD, 20));
					tf4.setBounds(350, 377, 217, 40);
					tf4.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black));
					tablePanel.add(tf4);

					JButton btnNewButton = new JButton("CONFIRM");
					btnNewButton.setForeground(Color.BLACK);
					btnNewButton.setBackground(new Color(128,128,128));
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


								String location = tf1.getText();
								String quantity = tf2.getText();
								String category = tf3.getText();
								String rtype=tf4.getText();
								if( tf1.getText().isEmpty()|| tf2.getText().isEmpty()|| tf3.getText().isEmpty()|| tf4.getText().isEmpty() )
								{
									JOptionPane.showMessageDialog(null,"Empty fields are not allowed !!","Testing",JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									String query = "select Receiver_Id,Name from receiver where Email_id = '"+email+"'  ";
									rs1 = stmt.executeQuery(query);
									if (rs1.next())
									{
										int id= rs1.getInt("Receiver_Id");
										String name=rs1.getString("Name");

										String query1 = "Insert into request_receiver(Receiver_Id,Location,Quantity,Category,Name,Receiver_Type) values(?,?,?,?,?,?)";
										PreparedStatement ps2 = conn.prepareStatement(query1);
										ps2.setInt(1,id);
										ps2.setString(2,location);
										ps2.setString(3,quantity);
										ps2.setString(4,category);
										ps2.setString(5, name);
										ps2.setString(6,rtype);
										ps2.execute();            
										JOptionPane.showMessageDialog(null,"Request Successful !!");
										tf1.setText("");
										tf2.setText("");
										tf3.setText("");
										tf4.setText("");

									}
									else
									{
										JOptionPane.showMessageDialog(null, "Email not found in database");
										tf1.setText("");
										tf2.setText("");
										tf3.setText("");
										tf4.setText("");
									}

								}
							}
							catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
								e1.printStackTrace();
								tf1.setText("");
								tf2.setText("");
								tf3.setText("");
								tf4.setText("");
							}

						}
					});
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
					btnNewButton.setBounds(265, 500, 187, 57);
					//btnNewButton.setBackground(new Color(0, 0, 0));
					tablePanel.add(btnNewButton);

					//tablePanel.setLayout(null);
					
					
					
					
					tablePanel.setLayout(new BorderLayout());
//					JLabel lblreqForm = new JLabel("Request Form");
//					lblreqForm.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 70));
//					lblreqForm.setBounds(150, 300, 875, 700);
					JPanel panel_req = new JPanel();
					panel_req.setBackground(new Color(230, 230, 250));//inner side panel
					panel_req.setBounds(0, 1, 3, 7);
					//panel.add(panel_req);
					tablePanel.add(panel_req);
					
					
					JLabel lblreqForm = new JLabel("Request Form");
					lblreqForm.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 70));
					lblreqForm.setBounds(150, 300, 875, 700);
					panel_req.add(lblreqForm);

					// JScrollPane scrollPane = new JScrollPane();
					// tablePanel.removeAll();
					// tablePanel.add(scrollPane);
					// tablePanel.revalidate();
					// tablePanel.repaint();

				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "ERROR !");
				}
				// finally
				// {
				// Container container1 = getContentPane();
				// container1.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
				// container1.add(panel);
				// container1.add(panel);
				//
				// }


			}
		});

		JButton pendBtn = new JButton("Pending Requests ");
		pendBtn.setBounds(0, 90, 150, 56);
		pendBtn.setFont(new Font("Tahoma", Font.BOLD, 28));
		pendBtn.setForeground(new Color(0, 0, 0));
		//pendBtn.setBackground(new Color(0, 0, 0));
		pendBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					System.out.println("Connection Succeded..............................");
					Statement stmt = conn.createStatement();

					String query1 = "select Receiver_Id from receiver where Email_id = '"+Email+"'  ";
					ResultSet rs1 = stmt.executeQuery(query1);

					if(rs1.next())
					{      

						int id= rs1.getInt("Receiver_Id");


						String query = "select Request_Receiver_Id,Quantity,Category from request_receiver where Receiver_Id='" + id+ "' ";
						ResultSet rs = stmt.executeQuery(query);
						DefaultTableModel model = new DefaultTableModel();
						JTable table = new JTable(model);

						model.addColumn("Request_Receiver_Id");
						model.addColumn("Quantity");
						model.addColumn("Category");

						while (rs.next())
						{
							//System.out.println(rs.getInt("Request_Receiver_Id"));
							Object[] row = new Object[3];
							row[0] = rs.getInt("Request_Receiver_Id");
							row[1] = rs.getString("Quantity");
							row[2] = rs.getString("Category");
							model.addRow(row);
						}

						JScrollPane scrollPane = new JScrollPane(table);
						tablePanel.removeAll();
						tablePanel.add(scrollPane);
						tablePanel.revalidate();
						tablePanel.repaint();


					}

				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "ERROR !");          
				}

			}
		});


		JButton completeBtn = new JButton("Completed Orders");
		completeBtn .setBounds(0, 90, 100, 56);
		completeBtn .setFont(new Font("Tahoma", Font.BOLD, 28));
		completeBtn.setForeground(new Color(0, 0, 0));
		//completeBtn .setBackground(new Color(0, 0, 0));
		completeBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms","root","1517");
					System.out.println("Connection Succeded..............................");
					Statement stmt = conn.createStatement();
					//System.out.println("1");
					String query1 = "select Receiver_Id from receiver where Email_id = '"+Email+"'  ";
					ResultSet rs1 = stmt.executeQuery(query1);
					//System.out.println("1");

					if(rs1.next())
					{      

						int id= rs1.getInt("Receiver_Id");
						//System.out.println(name);
						String query = "select Order_Id,Donor_Id,Quantity,Category from order_completed1 where Receiver_Id='" + id+ "' ";
						ResultSet rs = stmt.executeQuery(query);
						DefaultTableModel model = new DefaultTableModel();
						JTable table = new JTable(model);

						model.addColumn("Order_Id");
						model.addColumn("Donor_Id");
						model.addColumn("Quantity");
						model.addColumn("Category");

						while (rs.next())
						{
							//System.out.println(rs.getInt("Request_Receiver_Id"));
							Object[] row = new Object[4];
							row[0] = rs.getInt("Order_Id");
							//System.out.println(rs.getInt("Order_Id"));
							row[1] = rs.getString("Donor_Id");
							row[2] = rs.getString("Quantity");
							row[3] = rs.getString("Category");
							model.addRow(row);
						}



						JScrollPane scrollPane = new JScrollPane(table);
						tablePanel.removeAll();
						tablePanel.add(scrollPane);
						tablePanel.revalidate();
						tablePanel.repaint();

					}
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "ERROR !");                
				}
			}});

		panel_2.add(requestBtn);
		panel_2.add(pendBtn);
		panel_2.add(completeBtn);



		setVisible(true);


		tablePanel =new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setBounds(450, 65, 753, 606);
		panel.add(tablePanel);




	}

	public static void main(String[] args)
	{
		LoggedIn_Receiver frame = new LoggedIn_Receiver(" ");

	}
	protected void JOptionPane(ActionListener actionListener, String string)
	{
		// TODO Auto-generated method stub

	}

}


