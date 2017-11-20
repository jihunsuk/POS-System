package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uD648 \uD654\uBA74");
		frame.setBounds(100, 100, 448, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton manageGoods = new JButton("\uC0C1\uD488\uAD00\uB9AC");
		manageGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		manageGoods.setBounds(46, 46, 105, 46);
		frame.getContentPane().add(manageGoods);
		
		JButton ShoppingBasket = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		ShoppingBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ShoppingBasket.setBounds(167, 46, 105, 46);
		frame.getContentPane().add(ShoppingBasket);
		
		JButton SalesCondition = new JButton("\uB9E4\uCD9C\uD604\uD669\uD655\uC778");
		SalesCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SalesCondition.setBounds(287, 46, 105, 46);
		frame.getContentPane().add(SalesCondition);
	}

}