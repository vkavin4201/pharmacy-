package pharmacy_plus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcome {

	public JFrame frmPharmacywelcome;
	public static String un;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome(welcome.un);
					window.frmPharmacywelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcome(String str) {
		welcome.un = str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacywelcome = new JFrame();
		frmPharmacywelcome.setTitle("Pharmacy+/welcome");
		frmPharmacywelcome.setBounds(100, 100, 1020, 720);
		frmPharmacywelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmacywelcome.getContentPane().setLayout(null);

		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(383, 37, 184, 44);
		frmPharmacywelcome.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(844, 11, 152, 135);
		frmPharmacywelcome.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(764, 649, 232, 23);
		frmPharmacywelcome.getContentPane().add(label_2);

		JLabel lblWelcome = new JLabel("Welcome!!!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblWelcome.setBounds(345, 115, 265, 44);
		frmPharmacywelcome.getContentPane().add(lblWelcome);

		JButton btnProducts = new JButton("");
		btnProducts.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\product.png"));
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = new Product(welcome.un);
				frmPharmacywelcome.dispose();
				p.frmPharmacyproducts.setVisible(true);
			}
		});
		btnProducts.setBounds(145, 276, 135, 135);
		frmPharmacywelcome.getContentPane().add(btnProducts);

		JButton btnProfile = new JButton("");
		btnProfile.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\profile.png"));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile p = new Profile(welcome.un);
				frmPharmacywelcome.dispose();
				p.frame.setVisible(true);
			}
		});
		btnProfile.setBounds(413, 276, 135, 135);
		frmPharmacywelcome.getContentPane().add(btnProfile);

		JButton btnCart = new JButton("");
		btnCart.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\cart.png"));
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart c = new Cart(welcome.un);
				frmPharmacywelcome.dispose();
				c.frame.setVisible(true);
			}
		});
		btnCart.setBounds(646, 276, 152, 135);
		frmPharmacywelcome.getContentPane().add(btnCart);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(345, 276, 2, 182);
		frmPharmacywelcome.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(612, 276, 2, 182);
		frmPharmacywelcome.getContentPane().add(separator_1);

		JLabel lblProducts = new JLabel("Products");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblProducts.setBounds(70, 422, 265, 44);
		frmPharmacywelcome.getContentPane().add(lblProducts);

		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblMyProfile.setBounds(349, 422, 265, 44);
		frmPharmacywelcome.getContentPane().add(lblMyProfile);

		JLabel lblCart = new JLabel("Cart");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblCart.setBounds(612, 422, 265, 44);
		frmPharmacywelcome.getContentPane().add(lblCart);

		JLabel lblUser = new JLabel("User: " + welcome.un);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblUser.setBounds(10, 649, 232, 23);
		frmPharmacywelcome.getContentPane().add(lblUser);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start s = new Start();
				frmPharmacywelcome.dispose();
				s.frmPharmacy.setVisible(true);
			}
		});
		btnNewButton.setBounds(445, 559, 89, 23);
		frmPharmacywelcome.getContentPane().add(btnNewButton);
	}

}
