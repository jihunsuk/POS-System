package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingBasket {
	private int TotalPrice, ReceiveMoney, Change;
	// TODO: Amount는 상품별 개수가 되어야 한다. key-value를 통해?
	private List<Goods> goodsList = new ArrayList<>();
	private HashMap<Goods, Integer> Amount = new HashMap<>();

	public ShoppingBasket() {

	}

	public boolean addGoods(Goods GOODS) {
		if (goodsList.contains(GOODS)) {
			Amount.replace(GOODS, Amount.get(GOODS) + 1);
		} else {
			goodsList.add(GOODS);
			Amount.put(GOODS, 1);
		}

		return true;
	}

	public boolean removeGoods(Goods GOODS) {
		boolean result = goodsList.remove(GOODS);
		if(result == true) {
			Amount.remove(GOODS);
		}
		return result;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
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
}
