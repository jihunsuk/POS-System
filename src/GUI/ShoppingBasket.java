package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ShoppingBasket {

	private JFrame frame;
	private JTextField totalPrice;
	private JTextField receivePrice;

	/**
	 * Create the application.
	 */
	public ShoppingBasket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 819, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList ctgList = new JList();
		ctgList.setBounds(12, 48, 148, 492);
		frame.getContentPane().add(ctgList);
		
		JList goodsList = new JList();
		goodsList.setBounds(172, 48, 271, 492);
		frame.getContentPane().add(goodsList);
		
		JList basket = new JList();
		basket.setBounds(455, 48, 336, 249);
		frame.getContentPane().add(basket);
		
		JButton addGood = new JButton("\uC0C1\uD488\uCD94\uAC00");
		addGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addGood.setBounds(517, 317, 97, 23);
		frame.getContentPane().add(addGood);
		
		JButton deleteGood = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		deleteGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteGood.setBounds(648, 317, 97, 23);
		frame.getContentPane().add(deleteGood);
		
		JLabel label = new JLabel("\uCD1D\uAE08\uC561 :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(455, 353, 57, 15);
		frame.getContentPane().add(label);
		
		totalPrice = new JTextField();
		totalPrice.setBounds(517, 350, 116, 21);
		frame.getContentPane().add(totalPrice);
		totalPrice.setColumns(10);
		
		JLabel label_1 = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(455, 378, 57, 15);
		frame.getContentPane().add(label_1);
		
		receivePrice = new JTextField();
		receivePrice.setColumns(10);
		receivePrice.setBounds(517, 375, 116, 21);
		frame.getContentPane().add(receivePrice);
		
		JButton PayforMoney = new JButton("\uD604\uAE08\uACB0\uC81C");
		PayforMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PayforMoney.setBounds(517, 406, 97, 23);
		frame.getContentPane().add(PayforMoney);
		
		JButton PayForCard = new JButton("\uCE74\uB4DC\uACB0\uC81C");
		PayForCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PayForCard.setBounds(648, 406, 97, 23);
		frame.getContentPane().add(PayForCard);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				frame.setVisible(false);
			}
		});
		ok.setBounds(583, 439, 97, 23);
		frame.getContentPane().add(ok);
	}

}
