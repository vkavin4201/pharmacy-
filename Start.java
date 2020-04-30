package pharmacy_plus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Start {

	public JFrame frmPharmacy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frmPharmacy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacy = new JFrame();
		frmPharmacy.setTitle("Pharmacy+");
		frmPharmacy.setBounds(100, 100, 1020, 720);
		frmPharmacy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmacy.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pharmacy+");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel.setBounds(417, 42, 184, 44);
		frmPharmacy.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		lblNewLabel_1.setBounds(822, 23, 150, 135);
		frmPharmacy.getContentPane().add(lblNewLabel_1);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblAdmin.setBounds(253, 337, 184, 44);
		frmPharmacy.getContentPane().add(lblAdmin);

		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblUser.setBounds(549, 337, 184, 44);
		frmPharmacy.getContentPane().add(lblUser);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(505, 117, 2, 386);
		frmPharmacy.getContentPane().add(separator);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\admin-settings-male.png"));
		label.setBounds(267, 158, 189, 149);
		frmPharmacy.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\user.png"));
		label_1.setBounds(549, 158, 151, 149);
		frmPharmacy.getContentPane().add(label_1);

		JLabel lblNewLabel_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(774, 649, 232, 23);
		frmPharmacy.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adm_signin a = new adm_signin();
				frmPharmacy.dispose();
				a.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(305, 415, 89, 23);
		frmPharmacy.getContentPane().add(btnNewButton);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usr_sign u = new usr_sign();
				frmPharmacy.dispose();
				u.frmPharmacysignup.setVisible(true);
			}
		});
		btnSignUp.setBounds(596, 392, 89, 23);

		frmPharmacy.getContentPane().add(btnSignUp);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usr_signin u = new usr_signin();
				frmPharmacy.dispose();
				u.frmPharmacysignIn.setVisible(true);
			}
		});
		btnSignIn.setBounds(596, 467, 89, 23);
		frmPharmacy.getContentPane().add(btnSignIn);
	}

}
