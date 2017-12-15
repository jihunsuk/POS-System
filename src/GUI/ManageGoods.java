package GUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.Category;

public class ManageGoods {

	private JFrame frame;
	private JTable table;
	private static Category[] categoryList;
	private static String[] ctgdata = {};
	private static DefaultListModel<String> dlm = null;
	private static JList<String> ctgList = new JList<String>();
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
			
		updateCategory();
		ctgList.setBounds(12, 51, 148, 492);
		frame.getContentPane().add(ctgList);
		
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
		DefaultTableModel dtm = new DefaultTableModel(contents, header);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(Color.yellow);
		
		table.setBounds(172, 48, 271, 492);
		
		JButton ctg_Eroll = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uB4F1\uB85D</html>");
		ctg_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ErollCategory();
			}
		});
		ctg_Eroll.setBounds(455, 159, 97, 53);
		frame.getContentPane().add(ctg_Eroll);
		
		JButton ctg_Corret = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uC218\uC815</html>");
		ctg_Corret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = ctgList.getSelectedIndex();
				if (index == -1){
					JOptionPane.showMessageDialog(null, "카테고리를 선택해주세요.");
				} else{
					String selected = (String) ctgList.getSelectedValue();
					new CorrectCategory(selected);
				}	
			}
		});
		ctg_Corret.setBounds(577, 159, 97, 53);
		frame.getContentPane().add(ctg_Corret);
		
		JButton ctg_Delete = new JButton("<html>\uCE74\uD14C\uACE0\uB9AC<br>&nbsp&nbsp\uC0AD\uC81C</html>;");
		ctg_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = ctgList.getSelectedIndex();
				if (index == -1){
					JOptionPane.showMessageDialog(null, "카테고리를 선택해주세요.");
				} else{
					String selected = (String) ctgList.getSelectedValue();
					boolean sucess = Category.removeCategory(selected);
					if (sucess == true){
						updateCategory();
					}
				}
								
			}
		});
		ctg_Delete.setBounds(697, 159, 97, 53);
		frame.getContentPane().add(ctg_Delete);
		
		JButton good_Eroll = new JButton("\uC0C1\uD488\uB4F1\uB85D\r\n");
		good_Eroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ErollGoods();
				//상품 리스트 업데이트
			}
		});
		good_Eroll.setBounds(455, 250, 97, 53);
		frame.getContentPane().add(good_Eroll);
		
		JButton good_Correct = new JButton("\uC0C1\uD488\uC218\uC815");
		good_Correct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null, "상품을 선택해주세요.");
				} else{
					new CorrectGoods((String)dtm.getValueAt(index, 0));
				}
				//상품 리스트 업데이트하기
			}
		});
		good_Correct.setBounds(577, 250, 97, 53);
		frame.getContentPane().add(good_Correct);
		
		JButton good_Delete = new JButton("\uC0C1\uD488\uC0AD\uC81C");
		good_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
//				if (index == -1){
//					JOptionPane.showMessageDialog(null, "상품을 선택해주세요.");
//				} else{
//					removeGoods((String)dtm.getValueAt(index, 0));			
//				}
//				//상품 리스트 업데이트
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
}
