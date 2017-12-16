package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import DB.DBConnection;

public class SalesCondition {
	private int totalSalesMoney;
	private HashMap<Integer, Integer> orderMap; // <basketIndex, orderNo> 
	private HashMap<Integer, String> date; // <basketIndex, date>
	private List<ShoppingBasket> basketList;

	public SalesCondition() {
		basketList = new ArrayList<>();
		date = new HashMap<>();
		orderMap = new HashMap<>();
	}

	public void daySalesCheck() {
		Connection c = null;
		Statement stmt = null;
		basketList.clear();
		date.clear();
		orderMap.clear();
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd");
		String thisDay = dayTime.format(new Date());
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("SELECT * from `possystem`.`order` where substring(`time`, 1, 8) = '%s' order by orderNo", thisDay);
			ResultSet rs = stmt.executeQuery(query);

			int idx = 0;
			int prevOrderNo = -1;
			ShoppingBasket bsk = null;
			while (rs.next()) {
				String goodsName = rs.getString("goodsName");
				String time = rs.getString("time");
				int orderNo = rs.getInt("orderNo");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");

				if (prevOrderNo != orderNo) {
					bsk = new ShoppingBasket();
					basketList.add(bsk);
					date.put(idx, time);
					orderMap.put(idx, orderNo);
					prevOrderNo = orderNo;
					idx++;
				}
				
				bsk.setTotalPrice(bsk.getTotalPrice() + (price * amount));
			}

			stmt.close();
			System.out.println("조회에 성공했습니다.");
		} catch (Exception e) {
			System.out.println("조회에 실패했습니다.");
			e.printStackTrace();
		}
	}

	public void monthSalesCheck() {
		Connection c = null;
		Statement stmt = null;
		basketList.clear();
		date.clear();
		orderMap.clear();
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMM");
		String thisMonth = dayTime.format(new Date());
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("SELECT * from `possystem`.`order` where substring(`time`, 1, 6) = '%s' order by orderNo", thisMonth);
			ResultSet rs = stmt.executeQuery(query);

			int idx = 0;
			int prevOrderNo = -1;
			ShoppingBasket bsk = null;
			while (rs.next()) {
				String goodsName = rs.getString("goodsName");
				String time = rs.getString("time");
				int orderNo = rs.getInt("orderNo");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");

				if (prevOrderNo != orderNo) {
					bsk = new ShoppingBasket();
					basketList.add(bsk);
					date.put(idx, time);
					orderMap.put(idx, orderNo);
					prevOrderNo = orderNo;
					idx++;
				}
				
				bsk.setTotalPrice(bsk.getTotalPrice() + (price * amount));
			}

			stmt.close();
			System.out.println("조회에 성공했습니다.");
		} catch (Exception e) {
			System.out.println("조회에 실패했습니다.");
			e.printStackTrace();
		}
	}

	public int getTotalSalesMoney() {
		return totalSalesMoney;
	}

	public void setTotalSalesMoney(int totalSalesMoney) {
		this.totalSalesMoney = totalSalesMoney;
	}
	
	public HashMap<Integer, String> getDate(){
		return this.date;
	}
	
	public List<ShoppingBasket> getBasketList(){
		return this.basketList;
	}

	public HashMap<Integer, Integer> getOrderMap() {
		return this.orderMap;
	}
}
