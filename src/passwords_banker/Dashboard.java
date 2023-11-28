package passwords_banker;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.charset.StandardCharsets;

public class Dashboard {

	JFrame frame;
	private JTable table;
	String userId;
	JLabel travel;
	String s;
	String temp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Dashboard st = new Dashboard();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	
	public void load_table() {
		
		try {
			//JOptionPane.showMessageDialog(table, "Hello : "+s);
			   if(s.length() != 0) {
				   Class.forName("com.mysql.jdbc.Driver");
				   
				   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3?useSSL=false","root","1234");
				   
				//  System.out.println(temp);
				  String name = temp;
				  
				  String startIndx = ""+name.charAt(0);
				   String lastIndx = ""+name.charAt(name.length()-1);
				   String mix = startIndx + lastIndx;
				  System.out.println(mix);
				   System.out.print(s);
				   String query = "SELECT DECODE(domain, '"+mix+"'),"
		                    + "DECODE(user_id, '"+mix+"'),"
		                    + "DECODE(password, '"+mix+"')"
		                    + "FROM "+s;
				   	
		            PreparedStatement pst = con.prepareStatement(query);
		            ResultSet rs = pst.executeQuery();
		            
		            
		            DefaultTableModel tableModel = new DefaultTableModel();
		            table.setModel(tableModel);

		            java.sql.ResultSetMetaData metaData = rs.getMetaData();
		            int columnCount = metaData.getColumnCount();
		            for (int i = 1; i <= columnCount; i++) {
		                tableModel.addColumn(metaData.getColumnLabel(i));
		            }

		            while (rs.next()) {
		                Object[] row = new Object[columnCount];
		                for (int i = 1; i <= columnCount; i++) {
		                    // Convert the byte array to a string using hex encoding
		                    byte[] decodedBytes = rs.getBytes(i);
		                    String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
		                    row[i - 1] = decodedString;
		                }
		                tableModel.addRow(row);
		            }
				    
				   // table.setModel(DbUtils.resultSetToTableModel(rs));
				    rs.close();
				    con.close();
			   }
			   
			   
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	public Dashboard() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(32, 90, 1301, 511);
		frame.getContentPane().add(panel_4);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 41, 639, 459);
		panel_4.add(table);
		
		JLabel lblNewLabel = new JLabel("Domain Name");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 124, 19);
		panel_4.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setForeground(Color.LIGHT_GRAY);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserId.setBounds(219, 11, 124, 19);
		panel_4.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(432, 11, 124, 19);
		panel_4.add(lblPassword);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(85, 107, 47));
		panel_5.setBounds(659, 37, 632, 355);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(241, 120, 154, 35);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HAVE A NICE DAY!");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(203, 185, 231, 35);
		panel_5.add(lblNewLabel_1_1);
		
	    travel = new JLabel("");
	    travel.setForeground(new Color(0, 0, 0));
	    travel.setFont(new Font("Tahoma", Font.BOLD, 20));
		travel.setBounds(507, 11, 115, 42);
		panel_5.add(travel);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(85, 107, 47));
		panel_6.setBounds(659, 404, 632, 96);
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
				BankerPassword obj = new BankerPassword();
				frame.dispose();
				obj.frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton.setBounds(10, 11, 612, 74);
		panel_6.add(btnNewButton);
		
		
	}
}
