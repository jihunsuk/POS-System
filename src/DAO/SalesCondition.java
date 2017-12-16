package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DB.DBConnection;

public class SalesCondition {
	private int totalSalesMoney;
	
	public SalesCondition(){
		
	}

	public static void daySalesCheck(){
		Connection c = null;
		Statement stmt = null;

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from order");
			ResultSet rs = stmt.executeQuery(query);
			
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
