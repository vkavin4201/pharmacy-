package pharmacy_plus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class adm_signin {

	public JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adm_signin window = new adm_signin();
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
	public adm_signin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(381, 31, 184, 44);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(853, 11, 135, 135);
		frame.getContentPane().add(label_1);

		JLabel lblSignIn = new JLabel("Admin Sign In");
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblSignIn.setBounds(352, 86, 265, 44);
		frame.getContentPane().add(lblSignIn);

		JLabel lblLoginId = new JLabel("Login ID:");
		lblLoginId.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginId.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblLoginId.setBounds(180, 171, 265, 44);
		frame.getContentPane().add(lblLoginId);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(528, 171, 175, 44);
		frame.getContentPane().add(textField);

		JLabel label_3 = new JLabel("Password:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		label_3.setBounds(180, 255, 265, 44);
		frame.getContentPane().add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(528, 255, 175, 36);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				String un = textField.getText();
				String pw = passwordField.getText();
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select pid,password from pharmacy where pid=? and password=?";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, un);
					st.setString(2, pw);
					ResultSet rs = st.executeQuery();

					while (rs.next()) {
						count++;
					}
					if (count != 1) {
						throw new Exception();
					} else {
						admin_home a = new admin_home(un);
						frame.dispose();
						a.frame.setVisible(true);

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wrong Credentials");
					frame.dispose();
				}

			}

		});
		btnLogin.setBounds(441, 360, 108, 32);
		frame.getContentPane().add(btnLogin);

		JLabel label_4 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_4.setBounds(777, 650, 232, 23);
		frame.getContentPane().add(label_4);

		frame.getContentPane().add(passwordField);

	}
}
