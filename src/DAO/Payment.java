package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import DB.DBConnection;

public class Payment {
	public Payment() {

	}

	// TODO: 결제가 완료되었을 때 GUI에서 호출하여 매출추가
	// ex) GUI에서 ShoppingBasket s; 일때
	// s.getPayment().doCashPay();
	public static int doCashPay(final int totalPrice, final int receiveMoney, List<Goods> goodsList, HashMap<String, Integer> Amount) {
		Connection c = null;
		Statement stmt = null;
		int result = totalPrice - receiveMoney;
		
		long t = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));
		int prevOrderNo;
		int thisOrderNo;
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			// OrderNo 설정
			String query = String.format("SELECT MAX(orderNo) from `possystem`.`order`");
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) {
				prevOrderNo = 0;
			} else {
				prevOrderNo = rs.getInt(1);
			}
			thisOrderNo = prevOrderNo + 1;
			
			// Order 추가
			for (Goods g : goodsList){
				String goodsName = g.getGoodsName();
				int amount = Amount.get(goodsName);
				int price = g.getPrice();
				
				query = String.format("INSERT INTO `possystem`.`order` (`orderNo`, `goodsName`, `price`, `amount`, `time`) VALUES ('%s', '%s', '%s', '%s', '%s');", Integer.toString(thisOrderNo), goodsName, price, amount, time);
				stmt.executeUpdate(query);
			}

			stmt.close();
			System.out.println("현금결제에 성공했습니다.");
		} catch (Exception e) {
			result = -1;
			System.out.println("현금결제에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public static boolean doCreditPay(final int totalPrice, List<Goods> goodsList, HashMap<String, Integer> Amount) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		long t = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));
		int prevOrderNo;
		int thisOrderNo;
		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			// OrderNo 설정
			String query = String.format("select MAX(orderNo) from order");
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) {
				prevOrderNo = 0;
			} else {
				prevOrderNo = rs.getInt(0);
			}
			thisOrderNo = prevOrderNo + 1;
			
			// Order 추가
			for (Goods g : goodsList){
				String goodsName = g.getGoodsName();
				int amount = Amount.get(goodsName);
				int price = g.getPrice();
				
				query = String.format("insert into order values('%d', '%s', '%s', '%s', '%s')", thisOrderNo, goodsName, price, amount, time);
				stmt.executeUpdate(query);
			}
				
			result = true;
			stmt.close();
			System.out.println("카드결제에 성공했습니다.");
		} catch (Exception e) {
			System.out.println("카드결제에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}
}
