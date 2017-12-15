package GUI;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;

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
		frame.setVisible(true);
		frame.setTitle("\uD648 \uD654\uBA74");
		frame.setBounds(100, 100, 448, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton manageGoods = new JButton("\uC0C1\uD488\uAD00\uB9AC");
		manageGoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManageGoods();
				frame.setVisible(false);
			}
		});
		manageGoods.setBounds(46, 46, 105, 46);
		frame.getContentPane().add(manageGoods);
		
		JButton ShoppingBasket = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		ShoppingBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingBasket();
				frame.setVisible(false);
			}
		});
		ShoppingBasket.setBounds(167, 46, 105, 46);
		frame.getContentPane().add(ShoppingBasket);
		
		JButton SalesCondition = new JButton("\uB9E4\uCD9C\uD604\uD669");
		SalesCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalesCondition();
				frame.setVisible(false);
			}
		});
		SalesCondition.setBounds(287, 46, 105, 46);
		frame.getContentPane().add(SalesCondition);
	}

}
