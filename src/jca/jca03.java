package jca;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jca03 {

	private JFrame frame;
	private JTextField txtproname;
	private JTextField txtprice1;
	private JTextField txtcity1;
	private JTextField txtproid;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jca03 window = new jca03();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public jca03() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
		}
		catch (ClassNotFoundException ex)
		{
			
			
		}
		catch (SQLException ex)
		{
			
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1030, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java Crud Application");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 10, 360, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(0, 59, 195, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(0, 102, 195, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("City");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(0, 147, 195, 27);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtproname = new JTextField();
		txtproname.setBounds(197, 67, 797, 19);
		frame.getContentPane().add(txtproname);
		txtproname.setColumns(10);
		
		txtprice1 = new JTextField();
		txtprice1.setColumns(10);
		txtprice1.setBounds(197, 111, 797, 19);
		frame.getContentPane().add(txtprice1);
		
		txtcity1 = new JTextField();
		txtcity1.setColumns(10);
		txtcity1.setBounds(197, 156, 797, 19);
		frame.getContentPane().add(txtcity1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,price,city;
				
				
				pname= txtproname.getText();
				price= txtprice1.getText();
				city= txtcity1.getText();
				
				try {
					pst = con.prepareStatement("insert into product(Name,Price,City)values(?,?,?)");
					pst.setString(1, pname);
					pst.setString(2, price);
					pst.setString(3, city);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					//table_load();
					          
					txtproname.setText("");
					txtprice1.setText("");
					txtcity1.setText("");
					txtproname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 226, 180, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bid;
				
				
				bid= txtproid.getText();
				
				try {
					pst = con.prepareStatement("delete from product where id= ?");
					
					pst.setString(1, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record deleted!!!!!");
					
					          
					txtproname.setText("");
					txtprice1.setText("");
					txtcity1.setText("");
					txtproname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(0, 283, 180, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String pname,price,city,bid;
				pname= txtproname.getText();
				price= txtprice1.getText();
				city= txtcity1.getText();
				bid= txtproid.getText();
				
				try {
					pst = con.prepareStatement("update product set Name= ?,Price= ?,City= ? where id= ?");
					pst.setString(1, pname);
					pst.setString(2, price);
					pst.setString(3, city);
					pst.setString(4, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record updated!!!!!");
					//table_load();
					          
					txtproname.setText("");
					txtprice1.setText("");
					txtcity1.setText("");
					txtproname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(0, 341, 180, 37);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_3 = new JLabel("Product ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(0, 401, 195, 27);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtproid = new JTextField();
		txtproid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
			          
		            String id = txtproid.getText();
		 
		                pst = con.prepareStatement("select Name,Price,City from product where id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String name = rs.getString(1);
		                String price = rs.getString(2);
		                String city = rs.getString(3);
		                
		                txtproname.setText(name);
		                txtprice1.setText(price);
		                txtcity1.setText(city);
		                
		                
		            }  
		            else
		            {
		             txtproname.setText("");
		             txtprice1.setText("");
		                txtcity1.setText("");
		                
		            }
		            
		 
		 
		        }
		catch (SQLException ex) {
		          
		        }
		}
				
		});
		txtproid.setColumns(10);
		txtproid.setBounds(197, 410, 797, 19);
		frame.getContentPane().add(txtproid);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(200, 452, 794, 37);
		frame.getContentPane().add(btnNewButton_1);
	}
}
