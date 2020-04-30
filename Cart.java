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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class Cart {

	public JFrame frame;
	public static String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart window = new Cart(name);
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
	

	public Cart(String name2) {
		name=name2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/User/Cart");
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
		JLabel label_3 = new JLabel("User: "+name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 167, 109, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCost.setBounds(714, 167, 109, 23);
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
				String query="select m.mname,c.quantity,c.cost from medicine m,cart c where m.mid=c.mid and uid='"+name+"'";
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
		
		
		
		JLabel lblTablets = new JLabel("My Cart");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTablets.setBounds(384, 66, 184, 44);
		frame.getContentPane().add(lblTablets);
		
		JButton btnAddToCart = new JButton("Place Order");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query="select uid,mid,quantity,cost from cart where uid='"+name+"'";
				String query1="insert into orders(uid,mid,quantity,cost,status) values (?,?,?,?,'placed')";
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next())
					{
					PreparedStatement st1=con.prepareStatement(query1);
					st1.setString(1, rs.getString("uid"));
					st1.setInt(2, rs.getInt("mid"));
					st1.setInt(3, rs.getInt("quantity"));
					st1.setInt(4, rs.getInt("cost"));
					int ct=st1.executeUpdate();
					}
					String query2="delete from cart where uid=?";
					PreparedStatement st2=con.prepareStatement(query2);
						st2.setString(1,name);
						int ct=st2.executeUpdate();
						if(ct<0)
						{
							throw new Exception();
						}
					}
			
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null, "Exception : "+e1);}
			Orders or=new Orders(name);
			frame.dispose();
			or.frame.setVisible(true);
			}	
		});
		btnAddToCart.setBounds(397, 456, 135, 23);
		frame.getContentPane().add(btnAddToCart);
		
		
		JButton btnGoToCart = new JButton("Empty Cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query="delete from cart where uid=?";
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,"root","");
					PreparedStatement st=con.prepareStatement(query);
					st.setString(1,name);
					int ct=st.executeUpdate();
					if(ct<0)
					{
						throw new Exception();
					}
					}
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null, "Wrong credentials");}
			}
		});
		btnGoToCart.setBounds(397, 556, 135, 23);
		frame.getContentPane().add(btnGoToCart);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome w=new welcome(name);
				frame.dispose();
				w.frmPharmacywelcome.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(397, 508, 135, 23);
		frame.getContentPane().add(btnNewButton_1);
		


	}
}
