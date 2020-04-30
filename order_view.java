package pharmacy_plus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class order_view {

	public JFrame frame;
	public static String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order_view window = new order_view(name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public order_view(String str) {
		name=str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/Admin/View Orders");
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(384, 11, 184, 44);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(861, 11, 135, 135);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(764, 649, 232, 23);
		frame.getContentPane().add(label_2);
		JLabel label_3 = new JLabel("Admin: "+name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(279, 167, 109, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCost.setBounds(583, 167, 109, 23);
		frame.getContentPane().add(lblCost);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblQuantity.setBounds(420, 167, 109, 23);
		frame.getContentPane().add(lblQuantity);
		
		JTable table = new JTable();
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		table.setBounds(36, 239, 925, 135);
		
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query="select o.oid,o.uid,m.mname,o.quantity,o.cost,o.status from medicine m,orders o where m.mid=o.mid";
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null, "Exception : "+e1);}
			}
		});
		btnNewButton.setBounds(410, 123, 135, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JLabel lblTablets = new JLabel("Orders");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTablets.setBounds(384, 66, 184, 44);
		frame.getContentPane().add(lblTablets);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblStatus.setBounds(744, 167, 109, 23);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblId.setBounds(56, 167, 109, 23);
		frame.getContentPane().add(lblId);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_home a=new admin_home(name);
				frame.dispose();
			    a.frame.setVisible(true);
			}
		});
		btnHome.setBounds(397, 536, 135, 23);
		frame.getContentPane().add(btnHome);
		JTextField textField = new JTextField();
		textField.setBounds(324, 404, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query2="update orders set status='In Process' where oid="+id;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					PreparedStatement st2=con.prepareStatement(query2);
						int ct=st2.executeUpdate();
						if(ct<0)
						{
							throw new Exception();
						}
					}
			
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null, "Exception : "+e1);}
			
			}
		});
		btnNewButton_1.setBounds(665, 403, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Order ID to process:");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 407, 195, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
				
		JLabel lblEnterOrderId = new JLabel("Enter Order ID to cancel:");
		lblEnterOrderId.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblEnterOrderId.setBounds(78, 449, 195, 19);
		frame.getContentPane().add(lblEnterOrderId);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 450, 184, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField_1.getText());
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query="select mid,quantity from orders where oid="+id;
				String query1="update suppliers set quantity=quantity+? where mid=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next())
					{
					PreparedStatement st1=con.prepareStatement(query1);
					st1.setInt(1, rs.getInt("quantity"));
					st1.setInt(2, rs.getInt("mid"));
					int ct=st1.executeUpdate();
					}
					String query2="update orders set status='cancelled' where oid="+id;
					PreparedStatement st2=con.prepareStatement(query2);
						int ct=st2.executeUpdate();
						if(ct<0)
						{
							throw new Exception();
						}
					}
			
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null, "Exception : "+e1);}
			
		
			}
		});
		btnCancel.setBounds(665, 449, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblUsername.setBounds(146, 167, 109, 23);
		frame.getContentPane().add(lblUsername);
		

	}

}
