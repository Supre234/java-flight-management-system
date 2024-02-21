import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;

public class SignUP extends JFrame {

	private JPanel contentPane;
	private JTextField fullName;
	private JTextField cnic;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	static ArrayList<Passengers> PassengerList=new ArrayList<Passengers>();
	static JTextField username;
	private JTextField passport;
	public static void main(String[] args) {
		SignUP frame = new SignUP();
		frame.setVisible(true);
	}
	public SignUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(252, 11, 389, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(37, 68, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Aadhar");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(37, 130, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(37, 203, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(37, 247, 132, 17);
		contentPane.add(lblNewLabel_4);
		
		fullName = new JTextField();
		fullName.setBounds(214, 65, 150, 20);
		contentPane.add(fullName);
		fullName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(214, 96, 150, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		cnic = new JTextField();
		cnic.setBounds(214, 127, 150, 20);
		contentPane.add(cnic);
		cnic.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(214, 200, 150, 20);
		contentPane.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(214, 244, 150, 20);
		contentPane.add(confirmPassword);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								int chk=0;
				for (int i=0 ; i<password.getText().length() ; i++)
				{
					char check=password.getText().charAt(i);
					
					if (Character.isUpperCase(check)==true)
					{
						chk+=1;
						break;
					}
				}
				
				if(username.getText().equals("") || password.getText().equals("") || cnic.getText().equals("") || fullName.getText().equals("") ||
						confirmPassword.getText().equals("") || passport.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill all fields.");
				}
				
				if(password.getText().equals(confirmPassword.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "Passwords do not match.");
				}
				else if (password.getText().length()<8)
				{
					JOptionPane.showMessageDialog(null, "Password cannot be less than 8 characters.");
				}
				else if(password.getText().contains("@")==false && password.getText().contains("!")==false && password.getText().contains("%")==false 
						&& password.getText().contains("#")==false && password.getText().contains("^")==false && password.getText().contains("&")==false)
				{
					JOptionPane.showMessageDialog(null, "Password must have a special character");
				}
				else if (cnic.getText().length()!=12)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Aadhar of 12 digits.");
				}
				else if (cnic.getText().matches("[0-9]+")==false)
				{
					JOptionPane.showMessageDialog(null, "Aadhar must contain digits.");
				}
				else if (chk<1)
				{
					JOptionPane.showMessageDialog(null, "Password must have atleast one uppercase letter.");
				}
				else
				{
				Passengers obj=new Passengers(fullName.getText(),cnic.getText(),username.getText(),password.getText(),passport.getText());
				String query = "INSERT INTO users values('"+obj.getName()+"','"+obj.getUsername()+"','"+obj.getCnic()+"','"+obj.getPassword()+"','"+obj.getPassport()+"')";
				sqlconnect connection = new sqlconnect();
				Connection con = connection.connect();
				Statement st=null;
				try {
					st = con.createStatement();
					System.out.println(st.executeUpdate(query)); 
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "This Aadhar is already registered. Please choose another");
					return;
				}
				Login obj1=new Login();
				obj1.setVisible(true);
				dispose();
				}
			}
		});
		
		btnNewButton.setBounds(387, 348, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(37, 99, 96, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj=new Login(); 
				
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(503, 348, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Passport");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBounds(37, 155, 99, 29);
		contentPane.add(lblNewLabel_6);
		
		passport = new JTextField();
		passport.setBounds(214, 163, 150, 20);
		contentPane.add(passport);
		passport.setColumns(10);
	    
	}
}
