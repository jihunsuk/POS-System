package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageGoods {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public ManageGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uC0C1\uD488\uAD00\uB9AC");
		frame.setBounds(100, 100, 819, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList ctgList = new JList();
		ctgList.setBounds(12, 48, 148, 492);
		frame.getContentPane().add(ctgList);
		
		JList goodsList = new JList();
		goodsList.setBounds(172, 48, 271, 492);
		frame.getContentPane().add(goodsList);
		
		JButton ctg_Corret = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uC218\uC815</html>");
		ctg_Corret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ctg_Corret.setBounds(577, 159, 97, 53);
		frame.getContentPane().add(ctg_Corret);
		
		JButton ctg_Eroll = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uB4F1\uB85D</html>");
		ctg_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ctg_Eroll.setBounds(455, 159, 97, 53);
		frame.getContentPane().add(ctg_Eroll);
		
		JButton good_Correct = new JButton("\uC0C1\uD488\uC218\uC815");
		good_Correct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		good_Correct.setBounds(577, 250, 97, 53);
		frame.getContentPane().add(good_Correct);
		
		JButton good_Eroll = new JButton("\uC0C1\uD488\uB4F1\uB85D\r\n");
		good_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		good_Eroll.setBounds(455, 250, 97, 53);
		frame.getContentPane().add(good_Eroll);
		
		JButton ctg_Delete = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uC0AD\uC81C</html>;");
		ctg_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ctg_Delete.setBounds(697, 159, 97, 53);
		frame.getContentPane().add(ctg_Delete);
		
		JButton good_Delete = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		good_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		good_Delete.setBounds(697, 250, 97, 53);
		frame.getContentPane().add(good_Delete);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.setBounds(577, 342, 97, 37);
		frame.getContentPane().add(ok);
	}
}
