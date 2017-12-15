package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesCondition {
	private int totalSalesMoney;
	
	public SalesCondition(){
		
	}

	public void daySalesCheck(){
		
	}

	public void monthSalesCheck(){
		
	}
	
	// 매출현황이 추가되는 것은 유스케이스가 아님.
	// TODO: 결제가 완료되었을 때 GUI에서 호출하여 매출추가
	// ex) GUI에서 ShoppingBasket s; 일때
	// s.getAmount().entrySet();
	// for(each entry) {
	// 	SalesCondition.addSales(goodsName, amount);
	// }
	public static void addSales(String goodsName, int amount){
		long t = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));
		
	}
	
	public int getTotalSalesMoney() {
		return totalSalesMoney;
	}

	public void setTotalSalesMoney(int totalSalesMoney) {
		this.totalSalesMoney = totalSalesMoney;
	}
}
