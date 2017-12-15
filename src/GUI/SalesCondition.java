package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesCondition {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public SalesCondition() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 565, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList salesList = new JList();
		salesList.setBounds(12, 10, 525, 196);
		frame.getContentPane().add(salesList);
		
		JButton sales_for_day = new JButton("\uC77C\uB9E4\uCD9C\uD604\uD669");
		sales_for_day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sales_for_day.setBounds(99, 235, 97, 23);
		frame.getContentPane().add(sales_for_day);
		
		JButton sales_for_month = new JButton("\uC6D4\uB9E4\uCD9C\uD604\uD669");
		sales_for_month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sales_for_month.setBounds(360, 235, 97, 23);
		frame.getContentPane().add(sales_for_month);
		
		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setVisible(false);
			}
		});
		back.setBounds(234, 271, 97, 23);
		frame.getContentPane().add(back);
		

	}

}
