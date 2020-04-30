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
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;

public class Orders {

	public JFrame frame;
	public static String name;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders(name);
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
	public Orders(String str) {
		name = str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/User/My Orders");
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
		JLabel label_3 = new JLabel("User: " + name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 167, 109, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCost = new JLabel("Cost");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCost.setBounds(459, 167, 109, 23);
		frame.getContentPane().add(lblCost);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblQuantity.setBounds(307, 167, 109, 23);
		frame.getContentPane().add(lblQuantity);

		JTable table = new JTable();
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		table.setBounds(36, 191, 925, 264);

		frame.getContentPane().add(table);

		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select o.oid,m.mname,o.quantity,o.cost,o.status from medicine m,orders o where m.mid=o.mid and o.uid='"
						+ name + "'";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}
			}
		});
		btnNewButton.setBounds(410, 123, 135, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblTablets = new JLabel("My Orders");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTablets.setBounds(384, 66, 184, 44);
		frame.getContentPane().add(lblTablets);

		JButton btnAddToCart = new JButton("Profile");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile p = new Profile(name);
				frame.dispose();
				p.frame.setVisible(true);
			}
		});
		btnAddToCart.setBounds(397, 548, 135, 23);
		frame.getContentPane().add(btnAddToCart);

		JButton btnGoToCart = new JButton("Cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart c = new Cart(name);
				frame.dispose();
				c.frame.setVisible(true);
			}
		});
		btnGoToCart.setBounds(397, 623, 135, 23);
		frame.getContentPane().add(btnGoToCart);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblStatus.setBounds(623, 167, 109, 23);
		frame.getContentPane().add(lblStatus);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblId.setBounds(56, 167, 109, 23);
		frame.getContentPane().add(lblId);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome w = new welcome(name);
				frame.dispose();
				w.frmPharmacywelcome.setVisible(true);
			}
		});
		btnHome.setBounds(397, 589, 135, 23);
		frame.getContentPane().add(btnHome);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = 0, id = Integer.parseInt(textField.getText());
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select mid,quantity from orders where oid=" + id + " and status='placed'";
				String query1 = "update suppliers set quantity=quantity-? where mid=? and quantity>=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					PreparedStatement st1 = con.prepareStatement(query1);
					while (rs.next()) {
						st1.setInt(1, rs.getInt("quantity"));
						st1.setInt(2, rs.getInt("mid"));
						st1.setInt(3, rs.getInt("quantity"));

					}

					int ct = st1.executeUpdate();
					if (ct > 0) {
						String query2 = "update orders set status='confirmed' where oid=" + id;
						PreparedStatement st2 = con.prepareStatement(query2);
						int ct1 = st2.executeUpdate();
					} else {
						String query2 = "update orders set status='cancelled' where oid=" + id;
						PreparedStatement st5 = con.prepareStatement(query2);
						int CT = st5.executeUpdate();
						JOptionPane.showMessageDialog(null, "Cancelled due to unavailability of stock");
					}
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}

			}
		});
		btnNewButton_1.setBounds(665, 466, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Enter Order ID to confirm:");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 470, 195, 19);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(324, 471, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblEnterOrderId = new JLabel("Enter Order ID to cancel:");
		lblEnterOrderId.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblEnterOrderId.setBounds(78, 516, 195, 19);
		frame.getContentPane().add(lblEnterOrderId);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 517, 184, 20);
		frame.getContentPane().add(textField_1);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField_1.getText());
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select mid,quantity from orders where oid=" + id + " and status='confirmed'";
				String query1 = "update suppliers set quantity=quantity+? where mid=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while (rs.next()) {
						PreparedStatement st1 = con.prepareStatement(query1);
						st1.setInt(1, rs.getInt("quantity"));
						st1.setInt(2, rs.getInt("mid"));
						int ct = st1.executeUpdate();
					}
					String query2 = "update orders set status='cancelled' where oid=" + id;
					PreparedStatement st2 = con.prepareStatement(query2);
					int ct = st2.executeUpdate();
					if (ct < 0) {
						throw new Exception();
					}
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}

			}
		});
		btnCancel.setBounds(665, 516, 89, 23);
		frame.getContentPane().add(btnCancel);

	}
}
