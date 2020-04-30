package pharmacy_plus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class usr_signin {

	public JFrame frmPharmacysignIn;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usr_signin window = new usr_signin();
					window.frmPharmacysignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public usr_signin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacysignIn = new JFrame();
		frmPharmacysignIn.setTitle("Pharmacy+/Sign In");
		frmPharmacysignIn.setBounds(100, 100, 1023, 721);
		frmPharmacysignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmacysignIn.getContentPane().setLayout(null);

		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(381, 31, 184, 44);
		frmPharmacysignIn.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(853, 11, 135, 135);
		frmPharmacysignIn.getContentPane().add(label_1);

		JLabel lblSignIn = new JLabel("User Sign In");
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblSignIn.setBounds(352, 86, 265, 44);
		frmPharmacysignIn.getContentPane().add(lblSignIn);

		JLabel label_2 = new JLabel("Username:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_2.setBounds(180, 171, 265, 44);
		frmPharmacysignIn.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(528, 171, 175, 44);
		frmPharmacysignIn.getContentPane().add(textField);

		JLabel label_3 = new JLabel("Password:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_3.setBounds(180, 255, 265, 44);
		frmPharmacysignIn.getContentPane().add(label_3);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				int count = 0;
				String un = textField.getText();
				String pw = passwordField.getText();
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select * from end_user where login_id='" + un + "' and password='" + pw + "'";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);

					while (rs.next()) {
						count++;
					}
					if (count != 1) {
						throw new Exception();
					}
					else {
						welcome w = new welcome(un);
						frmPharmacysignIn.dispose();
						w.frmPharmacywelcome.setVisible(true);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wrong Credentials");
					frmPharmacysignIn.dispose();
				}

				

			}

		});
		btnLogin.setBounds(441, 360, 108, 32);
		frmPharmacysignIn.getContentPane().add(btnLogin);

		JLabel label_4 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_4.setBounds(777, 650, 232, 23);
		frmPharmacysignIn.getContentPane().add(label_4);

		passwordField = new JPasswordField();
		passwordField.setBounds(528, 259, 175, 32);
		frmPharmacysignIn.getContentPane().add(passwordField);
	}
}
