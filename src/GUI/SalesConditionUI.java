package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Goods;
import DAO.SalesCondition;
import DAO.ShoppingBasket;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class SalesConditionUI {

	final static int DAY = 1;
	final static int MONTH = 2;

	private JFrame frame;
	private static Goods[] saleList;
	private static String[][] sales = {};
	private static String header[] = { "날짜", "주문번호", "매출" };
	private static DefaultTableModel dtm = new DefaultTableModel(sales, header);
	private static JTable table;
	private static SalesCondition sc = new SalesCondition();
	private static HashMap<Integer, String> date;
	private static HashMap<Integer, Integer> orderMap;
	private static List<ShoppingBasket> basketList;

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
				sc.daySalesCheck();
				updateSales(DAY);
			}
		});
		sales_for_day.setBounds(99, 235, 115, 23);
		frame.getContentPane().add(sales_for_day);

		JButton sales_for_month = new JButton("\uC6D4\uB9E4\uCD9C\uD604\uD669");
		sales_for_month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sc.monthSalesCheck();
				updateSales(MONTH);
			}
		});
		sales_for_month.setBounds(347, 235, 115, 23);
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

	public static void updateSales(int option) {
		sales = new String[40][3];
		if (option == DAY) {
			basketList = sc.getBasketList();
			date = sc.getDate();
			orderMap = sc.getOrderMap();
		}
		for (int i = 0; i < basketList.size(); i++) {
			sales[i][0] = date.get(i);
			sales[i][1] = Integer.toString(orderMap.get(i));
			sales[i][2] = Integer.toString(basketList.get(i).getTotalPrice());
		}

		saleList = null;

		dtm = new DefaultTableModel(sales, header);
		table.setModel(dtm);
		table.updateUI();
	}
}
