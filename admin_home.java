package pharmacy_plus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class admin_home {

	public JFrame frame;
	public static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_home window = new admin_home(name);
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

	public admin_home(String name2) {
		name = name2;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/Admin/Home");
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(383, 37, 184, 44);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(836, 11, 148, 135);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(764, 649, 232, 23);
		frame.getContentPane().add(label_2);

		JLabel lblWelcome = new JLabel("Admin Home");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblWelcome.setBounds(345, 115, 265, 44);
		frame.getContentPane().add(lblWelcome);

		JButton btnProducts = new JButton("");
		btnProducts.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\buildings.png"));
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stock s = new stock(name);
				frame.dispose();
				s.frame.setVisible(true);
			}
		});
		btnProducts.setBounds(145, 276, 135, 135);
		frame.getContentPane().add(btnProducts);

		JButton btnProfile = new JButton("");
		btnProfile.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\interface.png"));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order_view o = new order_view(name);
				frame.dispose();
				o.frame.setVisible(true);
			}
		});
		btnProfile.setBounds(413, 276, 135, 135);
		frame.getContentPane().add(btnProfile);

		JButton btnCart = new JButton("");
		btnCart.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\medical(2).png"));
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicine m = new medicine(name);
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnCart.setBounds(663, 276, 135, 135);
		frame.getContentPane().add(btnCart);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(345, 276, 2, 182);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(612, 276, 2, 182);
		frame.getContentPane().add(separator_1);

		JLabel lblProducts = new JLabel("Stock");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblProducts.setBounds(70, 422, 265, 44);
		frame.getContentPane().add(lblProducts);

		JLabel lblMyProfile = new JLabel("Orders");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblMyProfile.setBounds(349, 422, 265, 44);
		frame.getContentPane().add(lblMyProfile);

		JLabel lblCart = new JLabel("Medicines");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblCart.setBounds(612, 422, 265, 44);
		frame.getContentPane().add(lblCart);

		JLabel lblUser = new JLabel("Admin: " + name);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblUser.setBounds(10, 649, 232, 23);
		frame.getContentPane().add(lblUser);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start s = new Start();
				frame.dispose();
				s.frmPharmacy.setVisible(true);
			}
		});
		btnNewButton.setBounds(445, 559, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
