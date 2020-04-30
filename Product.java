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

public class Product {

	public JFrame frmPharmacyproducts;
	public static String uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product window = new Product(uname);
					window.frmPharmacyproducts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Product(String str) {
		Product.uname = str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacyproducts = new JFrame();
		frmPharmacyproducts.setTitle("Pharmacy+/User/products");
		frmPharmacyproducts.setBounds(100, 100, 1020, 720);
		frmPharmacyproducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPharmacyproducts.getContentPane().setLayout(null);

		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(386, 43, 184, 44);
		frmPharmacyproducts.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(861, 11, 135, 135);
		frmPharmacyproducts.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(764, 649, 232, 23);
		frmPharmacyproducts.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("User: " + Product.uname);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frmPharmacyproducts.getContentPane().add(label_3);

		JLabel lblProducts = new JLabel("Products");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblProducts.setBounds(348, 128, 265, 44);
		frmPharmacyproducts.getContentPane().add(lblProducts);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\medical(2).png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tablet t = new Tablet(uname);
				frmPharmacyproducts.dispose();
				t.frame.setVisible(true);
			}
		});
		button.setBounds(179, 251, 135, 135);
		frmPharmacyproducts.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\medical.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Syrup s = new Syrup(uname);
				frmPharmacyproducts.dispose();
				s.frame.setVisible(true);
			}
		});
		button_1.setBounds(435, 251, 135, 135);
		frmPharmacyproducts.getContentPane().add(button_1);

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\medical(1).png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ointment o = new Ointment(uname);
				frmPharmacyproducts.dispose();
				o.frame.setVisible(true);
			}
		});
		button_2.setBounds(651, 251, 135, 135);
		frmPharmacyproducts.getContentPane().add(button_2);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(373, 228, 2, 182);
		frmPharmacyproducts.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(610, 228, 2, 182);
		frmPharmacyproducts.getContentPane().add(separator_1);

		JLabel lblTablets = new JLabel("Tablets");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblTablets.setBounds(110, 397, 265, 44);
		frmPharmacyproducts.getContentPane().add(lblTablets);

		JLabel lblSyrup = new JLabel("Syrup");
		lblSyrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSyrup.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblSyrup.setBounds(365, 397, 265, 44);
		frmPharmacyproducts.getContentPane().add(lblSyrup);

		JLabel lblOintment = new JLabel("Ointment");
		lblOintment.setHorizontalAlignment(SwingConstants.CENTER);
		lblOintment.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblOintment.setBounds(586, 397, 265, 44);
		frmPharmacyproducts.getContentPane().add(lblOintment);
	}

}
