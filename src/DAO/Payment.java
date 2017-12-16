package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
	public Payment(){
		
	}
	
	// TODO: 결제가 완료되었을 때 GUI에서 호출하여 매출추가
	// ex) GUI에서 ShoppingBasket s; 일때
	// s.getPayment().doCashPay();
	public int doCashPay(final int totalPrice, final int receiveMoney){
		long t = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String time = dayTime.format(new Date(t));

		return 0;
	}
	
	public boolean doCreditPay(final int totalPrice){

		
		return false;
	}
}
