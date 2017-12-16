package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.Payment;

public class payForMoney {

	private JFrame frame;
	private String totalMoney;
	private JTextField money;
	private JTextField rem;

	public payForMoney(String tMoney) {
		totalMoney = tMoney;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uD604\uAE08\uACB0\uC81C");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		money = new JTextField();
		money.setBounds(183, 60, 116, 21);
		frame.getContentPane().add(money);
		money.setColumns(10);
		
		JLabel label = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		label.setBounds(100, 63, 71, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC794\uC561 :");
		label_1.setBounds(110, 94, 40, 15);
		frame.getContentPane().add(label_1);
		
		rem = new JTextField();
		rem.setColumns(10);
		rem.setBounds(183, 91, 116, 21);
		frame.getContentPane().add(rem);
		frame.setVisible(true);
		JButton pay = new JButton("\uACB0\uC81C");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				boolean sucess = Payment.doCashPay(Integer.parseInt(totalMoney)
						, Integer.parseInt(money.getText()));
				if(sucess == true){
					JOptionPane.showMessageDialog(null, "현금결제가 완료되었습니다.");
					frame.setVisible(false);
					new Home();
				} else{
					JOptionPane.showMessageDialog(null, "결제할 상품이 없습니다.");
					frame.setVisible(false);
				}
			}
		});
		pay.setBounds(79, 159, 97, 23);
		frame.getContentPane().add(pay);
		
		JButton cancle = new JButton("\uCDE8\uC18C");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		cancle.setBounds(228, 159, 97, 23);
		frame.getContentPane().add(cancle);
	}

}

