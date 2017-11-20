package DAO;

public class ShoppingBasket {
	private int TotalPrice, Amount, ReceiveMoney, Change; // Change = 거스름돈
	// TODO: Amount는 상품별 개수가 되어야 한다. key-value를 통해? 
	
	public ShoppingBasket(){
		
	}

	public boolean addGoods(final String GOODS_NAME){
		
		return false;
	}
	
	public boolean removeGoods(final String GOODS_NAME){
		
		return false;
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
