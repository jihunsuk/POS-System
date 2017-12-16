package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Category;
import DAO.Goods;
import DAO.Payment;
import DAO.ShoppingBasket;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ShoppingBasketUI {

	private JFrame frame;
	private static JTextField totalPrice = new JTextField();
	
	private static JTable table;
	private static JTable basket;
	
	private static Category[] categoryList;
	private static String[] ctgdata = {};
	private static DefaultListModel<String> dlm = null;
	private static JList<String> ctgList = new JList<String>();
	
	private static Goods[] goodsList;
	private static String[][] goods = {};
	private static String header[] = {"상품명", "가격", "재고수량", "할인율"};
	private static DefaultTableModel dtm =  new DefaultTableModel(goods, header);
	
	private static List<Goods> basketList;
	private static HashMap<String, Integer> Amount;
	private static String[][] item = {};
	private static String header2[] = {"상품명", "가격", "수량",};
	private static DefaultTableModel dtm2 =  new DefaultTableModel(item, header2);
	private static ShoppingBasket bsk = new ShoppingBasket();
	/**
	 * Create the application.
	 */
	public ShoppingBasketUI() {
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
			
		updateCategory();
		ctgList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateGoods(ctgList.getSelectedValue());
			}
		});
		ctgList.setBounds(12, 51, 148, 492);
		frame.getContentPane().add(ctgList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 51, 271, 492);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.yellow);
		table.setBounds(172, 48, 271, 492);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(455, 48, 336, 249);
		frame.getContentPane().add(scrollPane2);
		basket = new JTable();
		basket.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	
		basket.setModel(dtm2);
		scrollPane2.setViewportView(basket);
		JTableHeader head2 = basket.getTableHeader();
		head2.setBackground(Color.yellow);
		basket.setBounds(455, 48, 336, 249);
		
		JButton addGood = new JButton("\uC0C1\uD488\uCD94\uAC00");
		addGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				String value = null;
				if(index != -1){
					value = (String)dtm.getValueAt(index, 0);
				}
				boolean sucess = bsk.addGoods(value);
				if(sucess == false){
					JOptionPane.showMessageDialog(null, "상품을 선택해주세요.");
				} else{
					updateBasket();
				}
				
			}
		});
		addGood.setBounds(506, 317, 97, 23);
		frame.getContentPane().add(addGood);
		
		JButton deleteGood = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		deleteGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = basket.getSelectedRow();
				String value = null;
				if(index != -1){
					value = (String)dtm2.getValueAt(index, 0);
				}
				boolean sucess = bsk.removeGoods(value);
				if(sucess == false){
					JOptionPane.showMessageDialog(null, "상품을 선택해주세요.");
				} else{
					updateBasket();
				}
			}
		});
		deleteGood.setBounds(648, 317, 97, 23);
		frame.getContentPane().add(deleteGood);
		
		JLabel label = new JLabel("\uCD1D\uAE08\uC561 :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(455, 367, 76, 15);
		frame.getContentPane().add(label);
		
		
		totalPrice.setBounds(537, 364, 116, 21);
		frame.getContentPane().add(totalPrice);
		totalPrice.setColumns(10);
		
		JButton PayforMoney = new JButton("\uD604\uAE08\uACB0\uC81C");
		PayforMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new payForMoney(totalPrice.getText(), bsk.getGoodsList(), bsk.getAmount());
			}
		});
		PayforMoney.setBounds(506, 406, 97, 23);
		frame.getContentPane().add(PayforMoney);
		
		JButton PayForCard = new JButton("\uCE74\uB4DC\uACB0\uC81C");
		PayForCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucess = Payment.doCreditPay(Integer.parseInt(totalPrice.getText()), bsk.getGoodsList(), bsk.getAmount());
				if(sucess == true){
					JOptionPane.showMessageDialog(null, "카드결제가 완료되었습니다.");
					frame.setVisible(false);
					new Home();
				} else{
					JOptionPane.showMessageDialog(null, "결제할 상품이 없습니다.");
				}
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
		ok.setBounds(578, 449, 97, 23);
		frame.getContentPane().add(ok);
	}
	
	public static void updateCategory(){
		categoryList = Category.getCategoryList();
		ctgdata = new String[categoryList.length];
		for(int i=0; i<categoryList.length; i++){
			ctgdata[i] = categoryList[i].getCategoryName();
		}
		dlm = new DefaultListModel<String>();
		for(String s:ctgdata){
			dlm.addElement(s);
		}
		ctgList.setModel(dlm);
		ctgList.updateUI();
	}

	public static void updateGoods(String ctgName){
		goods = new String[40][4];
		goodsList = Goods.getGoodsList(ctgName);
		for(int j=0; j<goodsList.length; j++){
			goods[j][0] = goodsList[j].getGoodsName();
			goods[j][1] = Integer.toString(goodsList[j].getPrice());
			goods[j][2] = Integer.toString(goodsList[j].getStockAmount());
			goods[j][3] = Float.toString(goodsList[j].getDiscount());
		}
		dtm = new DefaultTableModel(goods, header);
		table.setModel(dtm);
		table.updateUI();
	}
	
	public static void updateBasket(){
		item = new String[40][3];
		basketList = bsk.getGoodsList();
		Amount = bsk.getAmount();
		for(int j=0; j<basketList.size(); j++){
			item[j][0] = basketList.get(j).getGoodsName();
			item[j][1] = Integer.toString(basketList.get(j).getPrice());
			item[j][2] = Integer.toString(Amount.get(item[j][0]));
		}
		dtm2 = new DefaultTableModel(item, header2);
		basket.setModel(dtm2);
		basket.updateUI();
		totalPrice.setText(Integer.toString(bsk.getTotalPrice()));
	}
}
