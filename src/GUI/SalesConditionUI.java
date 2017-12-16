package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Goods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class SalesConditionUI {

	private JFrame frame;
	private static Goods[] goodsList;
	private static String[][] sales = {};
	private static String header[] = {"날짜", "매출", "d", "d"};
	private static DefaultTableModel dtm =  new DefaultTableModel(sales, header);
	private static JTable table;
	/**
	 * Create the application.
	 */
	public SalesConditionUI() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 525, 215);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.yellow);
		table.setBounds(12, 10, 525, 215);
		
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
	
	public static void updateGoods(){
		sales = new String[40][4];
		goodsList = null;
		for(int j=0; j<goodsList.length; j++){
			sales[j][0] = goodsList[j].getGoodsName();
			sales[j][1] = Integer.toString(goodsList[j].getPrice());
			sales[j][2] = Integer.toString(goodsList[j].getStockAmount());
			sales[j][3] = Float.toString(goodsList[j].getDiscount());
		}
		dtm = new DefaultTableModel(sales, header);
		table.setModel(dtm);
		table.updateUI();
	}
}
