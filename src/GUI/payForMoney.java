package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.Goods;
import DAO.Payment;

public class payForMoney {

	private JFrame frame;
	private String totalMoney;
	private JTextField money;
	private JFrame priviousFrame;
	private List<Goods> basketList;
	private HashMap<String, Integer> Amount;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private JTextField totalPrice;

	public payForMoney(String tMoney, List<Goods> list, HashMap<String, Integer> hm, JFrame f, DefaultTableModel d,
			DefaultTableModel d2, JTextField price) {
		totalMoney = tMoney;
		basketList = list;
		Amount = hm;
		priviousFrame = f;
		dtm = d;
		dtm2 = d2;
		totalPrice = price;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uD604\uAE08\uACB0\uC81C");
		frame.setBounds(100, 100, 335, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		money = new JTextField();
		money.setBounds(147, 44, 116, 21);
		frame.getContentPane().add(money);
		money.setColumns(10);

		JLabel label = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		label.setBounds(64, 47, 71, 15);
		frame.getContentPane().add(label);
		frame.setVisible(true);
		JButton pay = new JButton("\uACB0\uC81C");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int rem = Payment.doCashPay(Integer.parseInt(totalMoney), Integer.parseInt(money.getText()), basketList,
						Amount);
				if (rem != -1) {
					JOptionPane.showMessageDialog(null, "잔액 : " + rem + "\n현금결제가 완료되었습니다.");
					frame.setVisible(false);
					priviousFrame.setVisible(false);
					for (int i = 0; i < dtm.getRowCount(); i++)
						dtm.removeRow(i);
					for (int i = 0; i < dtm2.getRowCount(); i++)
						dtm2.removeRow(i);
					totalPrice.setText("");
					new Home();
				} else {
					JOptionPane.showMessageDialog(null, "결제할 상품이 없습니다.");
					frame.setVisible(false);
				}
			}
		});
		pay.setBounds(51, 98, 97, 23);
		frame.getContentPane().add(pay);

		JButton cancle = new JButton("\uCDE8\uC18C");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
			}
		});
		cancle.setBounds(166, 98, 97, 23);
		frame.getContentPane().add(cancle);
	}

}
