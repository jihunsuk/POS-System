package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DB.DBConnection;

public class ShoppingBasket {
	private int TotalPrice, ReceiveMoney, Change;
	private List<Goods> goodsList;
	private HashMap<String, Integer> Amount;
	private Payment payment;

	public ShoppingBasket() {
		TotalPrice = 0;
		ReceiveMoney = 0;
		Change = 0;
		goodsList = new ArrayList<>();
		Amount = new HashMap<>();
		payment = null;
	}

	public boolean addGoods(String goodsName) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// 예외 흐름 E1
		if (goodsName == null) {
			return false;
		}

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from goods where goodsName = '%s'", goodsName);

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				String gn = rs.getString("goodsName");
				int p = rs.getInt("price");
				int s = rs.getInt("stockamount");
				int d = rs.getInt("discount");
				String cn = rs.getString("categoryName");
				Category ct = new Category(cn);

				boolean flag = false;
				for (Goods g : goodsList) {
					if (g.getGoodsName().equals(gn)) {
						// 이미 추가된 상품이면 개수만 늘린다.
						Amount.replace(goodsName, Amount.get(goodsName) + 1);
						flag = true;
						break;
					}
				}
				if (flag == false) {
					goodsList.add(new Goods(gn, p, s, d, ct));
					Amount.put(goodsName, 1);
				}
				result = true;
			}

			System.out.println("장바구니상품담기에 성공했습니다.");
		} catch (SQLException e) {
			System.out.println("장바구니상품담기에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public boolean removeGoods(String goodsName) {
		Connection c = null;
		Statement stmt = null;
		boolean result = false;

		// 예외 흐름 E1
		if (goodsName == null) {
			return false;
		}

		try {
			c = DBConnection.getConnection();
			stmt = c.createStatement();

			String query = String.format("select * from goods where goodsName = '%s'", goodsName);

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next() && rs.getString("goodsName").equals(goodsName)) {
				for (Goods g : goodsList) {
					if (g.getGoodsName().equals(goodsName)) {
						goodsList.remove(g);
						Amount.remove(goodsName);
						result = true;
						break;
					}
				}
			}

			System.out.println("장바구니상품삭제에 성공했습니다.");
		} catch (SQLException e) {
			System.out.println("장바구니상품삭제에 실패했습니다.");
			e.printStackTrace();
		}

		return result;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public HashMap<String, Integer> getAmount() {
		return Amount;
	}

	public int getReceiveMoney() {
		return ReceiveMoney;
	}

	public void setReceiveMoney(int receiveMoney) {
		ReceiveMoney = receiveMoney;
	}

	public int getChange() {
		return Change;
	}

	public void setChange(int change) {
		Change = change;
	}

	// TODO: GUI에서 ShoppingBasket s일때
	// s.getPayment().doCreditPay(s.getReceiveMoney());
	// s.getPayment().doCashPay(s.getReceiveMoney(), s.getChange());
	public Payment getPayment() {
		if (this.payment == null) {
			payment = new Payment();
		}
		return payment;
	}

}
