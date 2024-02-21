import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditFlight2 extends JFrame {

	private JPanel contentPane;
	private JTextField flightID;
	private JTextField flightTime;
	private JTextField flightDate;
	private JTextField departCity;
	private JTextField landCity;
	private JTextField economySeats;
	private JTextField businessSeats;
	private JTextField distance;

	public static void main(String[] args) {
		EditFlight2 frame = new EditFlight2("000","00","00","00","00","0","0","0");
		frame.setVisible(true);
	}
	public EditFlight2(String fid,String time,String date,String depcity,String lancity,String ecseats,String bcseats,String dur) {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 357);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Flight");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight ID");
		lblNewLabel_1.setBounds(10, 36, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(10, 61, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Flight Date");
		lblNewLabel_3.setBounds(10, 86, 113, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Departure City");
		lblNewLabel_4.setBounds(10, 111, 113, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Landing City");
		lblNewLabel_5.setBounds(10, 136, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Economy Seats");
		lblNewLabel_6.setBounds(10, 161, 113, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Business Seats");
		lblNewLabel_7.setBounds(10, 186, 113, 14);
		contentPane.add(lblNewLabel_7);
		
		flightID = new JTextField();
		flightID.setBounds(133, 33, 86, 20);
		contentPane.add(flightID);
		flightID.setColumns(10);
		flightID.setText(fid);
		flightTime = new JTextField();
		flightTime.setBounds(133, 58, 86, 20);
		flightTime.setText(time);
		contentPane.add(flightTime);
		flightTime.setColumns(10);
		
		flightDate = new JTextField();
		flightDate.setBounds(133, 83, 86, 20);
		flightDate.setText(date);
		contentPane.add(flightDate);
		flightDate.setColumns(10);
		
		departCity = new JTextField();
		departCity.setBounds(133, 108, 86, 20);
		departCity.setText(depcity);
		contentPane.add(departCity);
		departCity.setColumns(10);
		
		landCity = new JTextField();
		landCity.setBounds(133, 133, 86, 20);
		landCity.setText(lancity);
		contentPane.add(landCity);
		landCity.setColumns(10);
		
		economySeats = new JTextField();
		economySeats.setBounds(133, 158, 86, 20);
		economySeats.setText(ecseats+"");
		contentPane.add(economySeats);
		economySeats.setColumns(10);
		
		businessSeats = new JTextField();
		businessSeats.setBounds(133, 183, 86, 20);
		businessSeats.setText(bcseats+"");
		contentPane.add(businessSeats);
		businessSeats.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternationalFlightSchedule obj=new InternationalFlightSchedule();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (flightID.getText().equals("") || flightTime.getText().equals("") || flightDate.getText().equals("") || departCity.getText().equals("") || 
						landCity.getText().equals("") || economySeats.getText().equals("") || businessSeats.getText().equals("") || distance.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				}
				else if(economySeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Economy Seats.");
				}
				else if(businessSeats.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Business Seats.");
				}
				else if(distance.getText().matches("^\\d+(\\.\\d+)?")==false)
				{
					JOptionPane.showMessageDialog(null, "Please enter integer input for Time Duration.");
				}
				else
				{
					sqlconnect connection = new sqlconnect();
					Connection con = connection.connect();
					Statement st=null;
					String query = "update intflights set departtime='"+flightTime.getText()+"',fdate='"+flightDate.getText()+"',startloc='"+departCity.getText()+"',endloc='"+landCity.getText()+"',ecseats="+economySeats.getText()+",bcseats="+businessSeats.getText()+",duration="+distance.getText()+" Where flightid='"+flightID.getText()+"'";
					try {
						st = con.createStatement();
						st.executeUpdate(query);
						InternationalFlightSchedule obj=new InternationalFlightSchedule();
						obj.setVisible(true);
						dispose();
					}catch(Exception i) {
						System.out.println(i);
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(255, 207, 89, 23);
		contentPane.add(btnNewButton);
		backButton.setBounds(255, 180, 89, 23);
		contentPane.add(backButton);
		JLabel lblNewLabel_8 = new JLabel("Time Duration");
		lblNewLabel_8.setBounds(10, 211, 113, 14);
		contentPane.add(lblNewLabel_8);
		
		distance = new JTextField();
		distance.setBounds(133, 208, 86, 20);
		distance.setText(dur+"");
		contentPane.add(distance);
		distance.setColumns(10);
		
		
	}

}
