package pharmacy_plus;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Profile {

	public JFrame frame;
	public static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile(name);
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
	public Profile(String str) {
		name = str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/User/Profile");
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(414, 47, 184, 44);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(849, 11, 135, 135);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(774, 651, 232, 23);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("User: " + name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);

		JLabel lblNewUserSign = new JLabel("My Profile");
		lblNewUserSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUserSign.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewUserSign.setBounds(366, 122, 265, 44);
		frame.getContentPane().add(lblNewUserSign);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblName.setBounds(181, 195, 265, 44);
		frame.getContentPane().add(lblName);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblUsername.setBounds(181, 278, 265, 44);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblPassword.setBounds(181, 371, 265, 44);
		frame.getContentPane().add(lblPassword);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblPhoneNumber.setBounds(181, 462, 265, 44);
		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblAddress.setBounds(181, 536, 265, 44);
		frame.getContentPane().add(lblAddress);

		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_4.setBounds(470, 195, 265, 44);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_5.setBounds(470, 278, 265, 44);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_6.setBounds(470, 371, 265, 44);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_7.setBounds(470, 462, 265, 44);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_8.setBounds(470, 536, 265, 44);
		frame.getContentPane().add(label_8);
		JButton btnNewButton = new JButton("Show Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select * from end_user where login_id='" + name + "'";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);

					while (rs.next()) {
						label_4.setText(rs.getString(1));
						label_5.setText(rs.getString(3));
						label_6.setText(rs.getString(4));
						label_7.setText(rs.getString(2));
						label_8.setText(rs.getString(5));
					}
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}

			}
		});
		btnNewButton.setBounds(431, 635, 122, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Home Page");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome w = new welcome(name);
				frame.dispose();
				w.frmPharmacywelcome.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(242, 635, 135, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnMyOrders = new JButton("My Orders");
		btnMyOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders o = new Orders(name);
				frame.dispose();
				o.frame.setVisible(true);
			}
		});
		btnMyOrders.setBounds(613, 635, 151, 23);
		frame.getContentPane().add(btnMyOrders);

	}
}
