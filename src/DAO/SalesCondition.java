package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DB.DBConnection;

public class SalesCondition {
	private int totalSalesMoney;
	private HashMap<Integer, String> date;
	private List<ShoppingBasket> basketList;
	
	public SalesCondition(){
		basketList = new ArrayList<>();
		date = new HashMap<>();
	}

	public static void daySalesCheck(){
		Connection c = null;
		Statement stmt = null;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("SELECT * from `possystem`.`order` order by orderNo desc");
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()){
				String goodsName = rs.getString("goodsName");
				String time = rs.getString("time");
				int orderNo = rs.getInt("orrderNo");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");
			}
			
			stmt.close();
			System.out.println("조회에 성공했습니다.");
		} catch (Exception e) {
			System.out.println("조회에 실패했습니다.");
			e.printStackTrace();
		}
	}

	public static void monthSalesCheck(){
		
	}
	
	
	public int getTotalSalesMoney() {
		return totalSalesMoney;
	}

	public void setTotalSalesMoney(int totalSalesMoney) {
		this.totalSalesMoney = totalSalesMoney;
	}
}
