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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class medicine {

	public JFrame frame;
	public static String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicine window = new medicine(name);
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
	public medicine(String str) {
		name=str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy+/Admin/Medicines");
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
		JLabel label_3 = new JLabel("Admin: "+name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 167, 109, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCost.setBounds(420, 167, 109, 23);
		frame.getContentPane().add(lblCost);
		
		JTable table = new JTable();
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		table.setBounds(36, 239, 925, 286);
		
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query="select * from medicine";
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
		
		
		
		JLabel lblTablets = new JLabel("Medicine");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTablets.setBounds(384, 66, 184, 44);
		frame.getContentPane().add(lblTablets);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblId.setBounds(56, 167, 109, 23);
		frame.getContentPane().add(lblId);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_home a=new admin_home(name);
				frame.dispose();
			    a.frame.setVisible(true);
			}
		});
		btnHome.setBounds(397, 536, 135, 23);
		frame.getContentPane().add(btnHome);
		
		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDosage.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblDosage.setBounds(301, 167, 109, 23);
		frame.getContentPane().add(lblDosage);
		
		JLabel lblType = new JLabel("Type");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblType.setBounds(551, 167, 109, 23);
		frame.getContentPane().add(lblType);
		
		JLabel lblManufactureDate = new JLabel("Manufacture Date");
		lblManufactureDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblManufactureDate.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblManufactureDate.setBounds(680, 167, 109, 23);
		frame.getContentPane().add(lblManufactureDate);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpiryDate.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblExpiryDate.setBounds(811, 167, 109, 23);
		frame.getContentPane().add(lblExpiryDate);
		
		
		

	}

}
