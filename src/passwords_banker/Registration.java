package passwords_banker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration {

	JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPin;
	private JTextField txtName;
	private JButton btnMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(31, 77, 1301, 511);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(85, 107, 47));
		panel_5.setBounds(866, 11, 425, 381);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(133, 120, 154, 35);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HAVE A NICE DAY!");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(97, 185, 231, 35);
		panel_5.add(lblNewLabel_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(85, 107, 47));
		panel_6.setBounds(866, 404, 425, 96);
		panel_4.add(panel_6);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BankerPassword obj = new BankerPassword();
				obj.frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(10, 11, 405, 74);
		panel_6.add(btnNewButton);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5_1.setBackground(new Color(85, 107, 47));
		panel_5_1.setBounds(10, 11, 846, 382);
		panel_4.add(panel_5_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblName.setBounds(128, 56, 154, 35);
		panel_5_1.add(lblName);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setForeground(Color.BLACK);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUserId.setBounds(128, 133, 154, 35);
		panel_5_1.add(lblUserId);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setHorizontalAlignment(SwingConstants.LEFT);
		lblPin.setForeground(Color.BLACK);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPin.setBounds(128, 213, 154, 35);
		panel_5_1.add(lblPin);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtId.setColumns(10);
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.setBounds(404, 133, 251, 33);
		panel_5_1.add(txtId);
		
		txtPin = new JPasswordField();
		txtPin.setBackground(Color.LIGHT_GRAY);
		txtPin.setBounds(404, 213, 251, 35);
		panel_5_1.add(txtPin);
		
		JButton newRecord = new JButton("CREATE");
		newRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String uId = txtId.getText();
				String startIndx = ""+name.charAt(0);
				String lastindex = ""+name.charAt(name.length()-1);
				String val = startIndx+lastindex;
				String pin = txtPin.getText();
				if(name.equals("") || uId.equals("") || pin.equals("")) {
					btnMsg.setText("Missing Fields");
				}
				else {
					try {
						   Class.forName("com.mysql.jdbc.Driver");
						   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3?useSSL=false","root","1234");
						   Statement stmt = con.createStatement();
						   
				
						   String sql = "insert into userLogin (pin,name,uid) "
							  		+ "values ("+pin+",'"+name+"','"+uId+"')";
							   
							  stmt.execute(sql);
							  
							  btnMsg.setText("=> Record Added <=");
							  
							  String sql2 = "create table "+uId
								  		+ "("
								  		+ "DOMAIN blob,"
								  		+ "USER_ID blob,"
								  		+ "PASSWORD blob"
								  		+ ");";
							  stmt.execute(sql2);
							
						   
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(newRecord, e1);
					}
				}
			}
		});
		newRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newRecord.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newRecord.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		newRecord.setFont(new Font("Tahoma", Font.BOLD, 23));
		newRecord.setBackground(Color.LIGHT_GRAY);
		newRecord.setBounds(204, 300, 154, 58);
		panel_5_1.add(newRecord);
		
		JButton clean = new JButton("CLEAR");
		clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText(null);
				txtName.setText(null);
				txtPin.setText(null);
			}
		});
		clean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				clean.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				clean.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		clean.setFont(new Font("Tahoma", Font.BOLD, 23));
		clean.setBackground(Color.LIGHT_GRAY);
		clean.setBounds(425, 300, 149, 58);
		panel_5_1.add(clean);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setBounds(404, 56, 251, 33);
		panel_5_1.add(txtName);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6_1.setBackground(new Color(85, 107, 47));
		panel_6_1.setBounds(10, 404, 846, 96);
		panel_4.add(panel_6_1);
	
	    btnMsg = new JButton("");
		btnMsg.setEnabled(false);
		btnMsg.setForeground(Color.LIGHT_GRAY);
		btnMsg.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnMsg.setBackground(Color.DARK_GRAY);
		btnMsg.setBounds(10, 11, 826, 74);
		panel_6_1.add(btnMsg);
	}
}
