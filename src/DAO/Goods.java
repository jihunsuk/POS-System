package DAO;

public class Goods {
	private String GoodsName;
	private int Price, StockAmount;
	private float Discount;
	private Category Category;
	
	public Goods(){
		
	}

	public boolean addGoods(final String goodsName, final int price, final float discount, final int stockAmount){
		
		return false;
	}
	
	public boolean modifyGoods(final String goodsName, final int price, final float discount, final int stockAmount){
		
		return false;
	}
	
	public boolean removeGoods(final String goodsName){
		
		return false;
	}
	
	public void checkGoodsList(){
		// TODO: return type -> Goods's List or Array
		
	}
	
	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStockAmount() {
		return StockAmount;
	}

	public void setStockAmount(int stockAmount) {
		StockAmount = stockAmount;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}
	
	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		this.Category = category;
	}
}
