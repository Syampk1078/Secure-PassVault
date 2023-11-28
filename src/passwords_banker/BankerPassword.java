package passwords_banker;

import java.nio.charset.StandardCharsets;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;



import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankerPassword {

	JFrame frame;
	private JTextField id;
	private JPasswordField pass;
	private JPanel panel_5;
	private JTextField txtOutput;
	private JButton btnEnter;
	private JButton btnAdd;
	private JButton btnClear;
	private JButton btnExit;
	private JButton btnShowRecords;
	private JComboBox domain;
	private int val;
	private JButton btnLogout;
	private JButton btn7;
	private JButton btn8;
	private JButton btn0;
	protected String comM;
	protected String uId;
	private JButton user;
	private JButton btnRegister;
	String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankerPassword window = new BankerPassword();
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
	public BankerPassword() {
		initialize();
		btnAdd.setEnabled(false);
		btnClear.setEnabled(false);
		btnExit.setEnabled(false);
		btnShowRecords.setEnabled(false);
		domain.setEnabled(false);
		id.setEnabled(false);
		pass.setEnabled(false);
		btnLogout.setEnabled(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(21, 76, 430, 511);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 410, 142);
		panel_3.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		txtOutput = new JTextField();
		txtOutput.setEditable(false);
		txtOutput.setForeground(new Color(0, 0, 0));
		txtOutput.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtOutput.setHorizontalAlignment(SwingConstants.CENTER);
		txtOutput.setColumns(10);
		txtOutput.setBackground(Color.GREEN);
		txtOutput.setBounds(38, 27, 335, 82);
		panel.add(txtOutput);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 164, 410, 335);
		panel_3.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
				txtOutput.setText(getString+"2");
			}
		});
		btn2.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/two.png")));
		btn2.setBounds(109, 36, 89, 45);
		panel_1.add(btn2);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
				   txtOutput.setText(getString+"1");
			}
		});
		btn1.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/one.png")));
		btn1.setBounds(10, 36, 89, 45);
		panel_1.add(btn1);
		
		JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
				   txtOutput.setText(getString+"3");
			}
		});
		btn3.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/three.png")));
		btn3.setBounds(208, 36, 89, 45);
		panel_1.add(btn3);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to Cancel",
						"Banker Passwords",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnCancel.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/cancel.png")));
		btnCancel.setBounds(307, 36, 89, 45);
		panel_1.add(btnCancel);
		
		JButton btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"6");
			}
		});
		btn6.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/six.png")));
		btn6.setBounds(208, 104, 89, 45);
		panel_1.add(btn6);
		
		JButton btnClr = new JButton("");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOutput.setText(null);
			}
		});
		btnClr.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/clear.png")));
		btnClr.setBounds(307, 104, 89, 45);
		panel_1.add(btnClr);
		
		JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"4");
			}
		});
		btn4.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/four.png")));
		btn4.setBounds(10, 104, 89, 45);
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"5");
			}
		});
		btn5.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/five.png")));
		btn5.setBounds(109, 104, 89, 45);
		panel_1.add(btn5);
		
		JButton btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"9");
			}
		});
		btn9.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/nine.png")));
		btn9.setBounds(208, 175, 89, 45);
		panel_1.add(btn9);
		
		btnEnter = new JButton("");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if(txtOutput.getText().equals("")) {
					   txtOutput.setText("Enter Pin");
				   }
				
				try {
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3?useSSL=false","root","1234");
					//   JOptionPane.showMessageDialog(btn9, "Hello");
					   String s = txtOutput.getText();
					  // id.setText(s);
					   
					   
					   String sql = "select name,uid from userLogin where pin="+s+"";
					   
					   Statement stmt = con.createStatement();
					//Execute Query
					   ResultSet rs = stmt.executeQuery(sql);
					  
					   
					   if(rs.next()) {
						   //JOptionPane.showMessageDialog(btn9, "Hello");
						   name = rs.getString(1);
						   
						   Dashboard obj = new Dashboard();
						   
						   
						  // 
						    uId = rs.getString(2);
						    
						    
						   
						    btnAdd.setEnabled(true);
							btnClear.setEnabled(true);
							btnExit.setEnabled(true);
							btnShowRecords.setEnabled(true);
							domain.setEnabled(true);
							id.setEnabled(true);
							pass.setEnabled(true);
							btnLogout.setEnabled(true);
							btnClr.setEnabled(false);
							btn1.setEnabled(false);
							btn2.setEnabled(false);
							btn3.setEnabled(false);
							btn4.setEnabled(false);
							btn5.setEnabled(false);
							btn6.setEnabled(false);
							btn7.setEnabled(false);
							btn8.setEnabled(false);
							btn9.setEnabled(false);
							btn0.setEnabled(false);
							btnRegister.setEnabled(false);
						   val = Integer.parseInt(s);
						   txtOutput.setText("Hi "+name.substring(2));
						   user.setText(uId);
						   					  
					   }
					  
					
					   else {
						   txtOutput.setText("Invalid");
					   }
					   
				}
				catch(Exception e1) {
					
				}
				
				
				
			}
		});
		btnEnter.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/enter.png")));
		btnEnter.setBounds(307, 175, 89, 45);
		panel_1.add(btnEnter);
		
	    btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"7");
			}
		});
		btn7.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/seven.png")));
		btn7.setBounds(10, 175, 89, 45);
		panel_1.add(btn7);
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"8");
			}
		});
		btn8.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/eight.png")));
		btn8.setBounds(109, 175, 89, 45);
		panel_1.add(btn8);
		
		btnRegister = new JButton("+");
		btnRegister.setForeground(Color.RED);
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration obj = new Registration();
				obj.frame.setVisible(true);
			}
		});
		btnRegister.setVerticalAlignment(SwingConstants.TOP);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(txtOutput.getText().equals(""))
				      txtOutput.setText("Register Now");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(txtOutput.getText().equals("Register Now"))
			    	txtOutput.setText(null);
			}
		});
		btnRegister.setBounds(208, 243, 89, 45);
		panel_1.add(btnRegister);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				btnClr.setEnabled(true);
				btnRegister.setEnabled(true);
				txtOutput.setText(null);
				
				
				btnAdd.setEnabled(false);
				btnClear.setEnabled(false);
				btnExit.setEnabled(false);
				btnShowRecords.setEnabled(false);
				domain.setEnabled(false);
				id.setEnabled(false);
				pass.setEnabled(false);
				btnLogout.setEnabled(false);
				user.setText(null);
				JOptionPane.showMessageDialog(btnRegister, "Logout Successful!");
				
			}
		});
		btnLogout.setBackground(new Color(255, 204, 102));
		btnLogout.setVerticalAlignment(SwingConstants.TOP);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBounds(307, 243, 89, 45);
		panel_1.add(btnLogout);
		
		user = new JButton("");
		user.setFont(new Font("Tahoma", Font.BOLD, 13));
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtOutput.setText(user.getText());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtOutput.setText("");
			}
		});
		user.setEnabled(false);
		user.setBounds(10, 243, 89, 45);
		panel_1.add(user);
		
		btn0 = new JButton("");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getString = txtOutput.getText();
				if(getString.length() != 6)
					txtOutput.setText(getString+"0");
			}
		});
		btn0.setIcon(new ImageIcon(BankerPassword.class.getResource("/passwords_banker/zero.png")));
		btn0.setBounds(109, 243, 89, 45);
		panel_1.add(btn0);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(461, 76, 866, 511);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
	    panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(85, 107, 47));
		panel_5.setBounds(10, 11, 846, 382);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOMAIN");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(128, 56, 154, 35);
		panel_5.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ENTER ID");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(128, 133, 154, 35);
		panel_5.add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(128, 213, 154, 35);
		panel_5.add(lblPassword);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.BOLD, 14));
		id.setBackground(Color.LIGHT_GRAY);
		id.setBounds(404, 133, 251, 33);
		panel_5.add(id);
		id.setColumns(10);
		
		
		String[] colums = {"","GMAIL","OUTLOOK","CODERS PACKET","FACEBOOK"};
		domain = new JComboBox(colums);
		domain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indx = domain.getSelectedIndex();
				if(indx == 0) {
					comM = colums[0];
				}
				else if(indx == 1)
				     comM = colums[1];
				else if(indx == 2)
					comM = colums[2];
				else if(indx == 3)
				     comM = colums[3];
				else if(indx == 4)
					comM = colums[4];
				else if(indx == 5)
					comM = colums[5];
			}
		});
		domain.setFont(new Font("Tahoma", Font.BOLD, 15));
		domain.setBackground(Color.LIGHT_GRAY);
		domain.setBounds(404, 56, 251, 34);
		panel_5.add(domain);
		
		pass = new JPasswordField();
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setBounds(404, 213, 251, 35);
		panel_5.add(pass);
		
		btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					   Class.forName("com.mysql.jdbc.Driver");
					   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3?useSSL=false","root","1234");
					   Statement stmt = con.createStatement();
					   
					   String drop = comM;
					   String txtId = id.getText();
					   String password = pass.getText();
					   
					   if(drop.equals(null) || txtId.equals("") || password.equals("")){
						   txtOutput.setText("=> Missing Required Field <=");
					   }else {
					   //pending
					   String startIndx = ""+name.charAt(0);
					   String lastIndx = ""+name.charAt(name.length()-1);
					   String mix = startIndx + lastIndx;
					   
					   
					   String sql = "insert into "+uId+"(DOMAIN,USER_ID,PASSWORD) "
						  		+ "values (ENCODE('"+drop+"','"+mix+"'),ENCODE('"+txtId+"','"+mix+"'),ENCODE('"+password+"','"+mix+"'))";
						   
						  stmt.execute(sql);
						  
						  txtOutput.setText("=> Record Added <=");
					   }
						
					   
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(lblPassword, e1);
				}
			}
		});
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnAdd.setBounds(128, 300, 154, 58);
		panel_5.add(btnAdd);
		
		btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClear.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				domain.setDropTarget(null);
				id.setText(null);
				pass.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnClear.setBounds(320, 300, 149, 58);
		panel_5.add(btnClear);
		
		btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit",
						"Banker Passwords",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(506, 300, 149, 58);
		panel_5.add(btnExit);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(85, 107, 47));
		panel_6.setBounds(10, 404, 846, 96);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		btnShowRecords = new JButton("SHOW RECORDS");
		btnShowRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShowRecords.setFont(new Font("Tahoma", Font.BOLD, 25));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnShowRecords.setFont(new Font("Tahoma", Font.BOLD, 23));
			}
		});
		btnShowRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard obj = new Dashboard();
				//obj.travel.setText(uId);
				frame.dispose();
			    obj.s = user.getText();
			    obj.travel.setText(user.getText());
			    obj.temp = name;
				obj.load_table();
				//txtOutput.setText("Welcome");
				obj.frame.setVisible(true);
				
			}
		});
		btnShowRecords.setForeground(Color.LIGHT_GRAY);
		btnShowRecords.setBackground(Color.DARK_GRAY);
		btnShowRecords.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnShowRecords.setBounds(10, 11, 826, 74);
		panel_6.add(btnShowRecords);
	}

	

}
