package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAO.Member;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Membership {

	private JFrame frame;
	private JTextField ID;
	private JTextField Pwd;
	private JTextField Name;
	private JTextField Age;
	private JTextField Phone_Number;
	
	/**
	 * Create the application.
	 */
	public Membership() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uD68C\uC6D0\uAC00\uC785");
		frame.setBounds(100, 100, 455, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 49, 69, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(79, 74, 69, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(79, 99, 69, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB098\uC774");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(79, 124, 69, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD734\uB300\uD3F0 \uBC88\uD638");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(79, 149, 69, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		ID = new JTextField();
		ID.setBounds(178, 46, 186, 21);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		Pwd = new JTextField();
		Pwd.setBounds(178, 71, 186, 21);
		frame.getContentPane().add(Pwd);
		Pwd.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(178, 96, 186, 21);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		Age = new JTextField();
		Age.setBounds(178, 121, 186, 21);
		frame.getContentPane().add(Age);
		Age.setColumns(10);
		
		Phone_Number = new JTextField();
		Phone_Number.setBounds(178, 146, 186, 21);
		frame.getContentPane().add(Phone_Number);
		Phone_Number.setColumns(10);
		
		JButton Member_Enroll = new JButton("\uAC00\uC785\uD558\uAE30");
		Member_Enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean join = Member.doMembership(ID.getText(), Pwd.getText(), Name.getText(), Age.getText());
				if (join == true){
					JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
					new Login();
					frame.setVisible(false);
					
				}
			}
		});
		Member_Enroll.setBounds(112, 198, 97, 23);
		frame.getContentPane().add(Member_Enroll);
		
		JButton Enroll_Cancle = new JButton("\uAC00\uC785\uCDE8\uC18C");
		Enroll_Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				frame.setVisible(false);
			}
		});
		Enroll_Cancle.setBounds(237, 198, 97, 23);
		frame.getContentPane().add(Enroll_Cancle);
	}

}
