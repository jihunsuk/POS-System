package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManageGoods {

	private JFrame frame;
	private JTable table;

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
		//ctgList.updateUI();  리스트에변경일어났을 경우 업데이트
		ctgList.setBounds(12, 51, 148, 492);
		frame.getContentPane().add(ctgList);
		
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
				new Home();
				frame.setVisible(false);
			}
		});
		ok.setBounds(577, 342, 97, 37);
		frame.getContentPane().add(ok);
		
		String header[] = {"상품명", "가격", "재고수량", "할인율"};
		String contents[][] = {
				{"이상현", "100", "1", "99"},
				{"이상현", "100", "2", "99"}
		};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 51, 271, 492);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(contents, header));
		scrollPane.setViewportView(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.yellow);
		/*   테이블 추가하는 방법
		String[] add = {"이상현", "100", "3", "99"};
		model.addRow(add);
		*/
		
		table.setBounds(172, 48, 271, 492);
	}
}
