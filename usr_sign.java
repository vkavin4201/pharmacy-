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

public class usr_sign {

	public JFrame frmPharmacysignup;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usr_sign window = new usr_sign();
					window.frmPharmacysignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public usr_sign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacysignup = new JFrame();
		frmPharmacysignup.setTitle("Pharmacy+/signup");
		frmPharmacysignup.setBounds(100, 100, 1020, 722);
		frmPharmacysignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmacysignup.getContentPane().setLayout(null);

		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(414, 47, 184, 44);
		frmPharmacysignup.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(849, 11, 135, 135);
		frmPharmacysignup.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(774, 651, 232, 23);
		frmPharmacysignup.getContentPane().add(label_2);

		JLabel lblNewUserSign = new JLabel("New User Sign Up");
		lblNewUserSign.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUserSign.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewUserSign.setBounds(366, 122, 265, 44);
		frmPharmacysignup.getContentPane().add(lblNewUserSign);

		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblName.setBounds(181, 195, 265, 44);
		frmPharmacysignup.getContentPane().add(lblName);

		textField = new JTextField();
		textField.setBounds(523, 195, 175, 44);
		frmPharmacysignup.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblUsername.setBounds(181, 278, 265, 44);
		frmPharmacysignup.getContentPane().add(lblUsername);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(523, 278, 175, 44);
		frmPharmacysignup.getContentPane().add(textField_1);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblPassword.setBounds(181, 371, 265, 44);
		frmPharmacysignup.getContentPane().add(lblPassword);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblPhoneNumber.setBounds(181, 462, 265, 44);
		frmPharmacysignup.getContentPane().add(lblPhoneNumber);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(523, 450, 175, 44);
		frmPharmacysignup.getContentPane().add(textField_2);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblAddress.setBounds(181, 536, 265, 44);
		frmPharmacysignup.getContentPane().add(lblAddress);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(523, 523, 240, 103);
		frmPharmacysignup.getContentPane().add(textField_3);
		passwordField = new JPasswordField();
		passwordField.setBounds(523, 371, 175, 36);
		frmPharmacysignup.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = new String[5];
				str[0] = textField.getText();
				str[1] = textField_1.getText();
				str[2] = passwordField.getText();
				str[3] = textField_2.getText();
				str[4] = textField_3.getText();
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "insert into end_user values (?,?,?,?,?)";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, str[0]);
					st.setString(2, str[3]);
					st.setString(3, str[1]);
					st.setString(4, str[2]);
					st.setString(5, str[4]);
					int count = st.executeUpdate();
					if (count <= 0)
						throw new Exception();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}
				usr_signin u = new usr_signin();
				frmPharmacysignup.dispose();
				u.frmPharmacysignIn.setVisible(true);
			}
		});
		btnNewButton.setBounds(351, 638, 89, 23);
		frmPharmacysignup.getContentPane().add(btnNewButton);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(482, 638, 89, 23);
		frmPharmacysignup.getContentPane().add(btnReset);

	}
}
