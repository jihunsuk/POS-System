package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField ID;
	private JTextField PWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uD3EC\uC2A4 \uC2DC\uC2A4\uD15C");
		frame.setBounds(100, 100, 393, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Login = new JButton("\uB85C\uADF8\uC778");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 눌렀을 경우
				
			}
		});
		Login.setBounds(76, 145, 97, 23);
		frame.getContentPane().add(Login);
		
		JButton Membership = new JButton("\uD68C\uC6D0\uAC00\uC785");
		Membership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//회원가입 눌렀을 경우
				
			}
		});
		Membership.setBounds(203, 145, 97, 23);
		frame.getContentPane().add(Membership);
		
		ID = new JTextField();
		ID.setBounds(174, 71, 116, 21);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		PWD = new JTextField();
		PWD.setBounds(174, 102, 116, 21);
		frame.getContentPane().add(PWD);
		PWD.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 72, 66, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(96, 103, 66, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("POS SYSTEM");
		lblNewLabel_2.setFont(new Font("배달의민족 도현", Font.BOLD, 18));
		lblNewLabel_2.setBounds(126, 20, 138, 38);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
