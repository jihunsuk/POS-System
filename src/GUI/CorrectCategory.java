package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CorrectCategory {

	private JFrame frame;
	private JTextField ctgName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorrectCategory window = new CorrectCategory();
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
	public CorrectCategory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uCE74\uD14C\uACE0\uB9AC \uB4F1\uB85D");
		frame.setBounds(100, 100, 438, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uCE74\uD14C\uACE0\uB9AC \uC218\uC815");
		label.setFont(new Font("배달의민족 도현", Font.BOLD, 18));
		label.setBounds(157, 32, 121, 30);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\uCE74\uD14C\uACE0\uB9AC\uBA85");
		lblNewLabel.setBounds(60, 90, 60, 15);
		frame.getContentPane().add(lblNewLabel);
		
		ctgName = new JTextField();
		ctgName.setBounds(143, 87, 218, 21);
		frame.getContentPane().add(ctgName);
		ctgName.setColumns(10);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.setBounds(104, 145, 97, 23);
		frame.getContentPane().add(ok);
		
		JButton cancle = new JButton("\uCDE8\uC18C");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancle.setBounds(213, 145, 97, 23);
		frame.getContentPane().add(cancle);
	}

}
