package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCart {
	
	
	@Test(dataProvider = "getDataForAddToCart")
	public void addToCartTest(String cat , String productName , int Qty) {
		System.out.println("cat==>" + cat + ",  productName==> "+productName + ", Qty==>"+Qty);
	}
	
	@DataProvider
	public Object[][] getDataForAddToCart() {
		Object[][] objArr = new Object[3][3];
		  objArr[0][0] = "Iphone";
		  objArr[0][1] = "XR";
		  objArr[0][2] = 1;
		  
		  objArr[1][0] = "Nokia";
		  objArr[1][1] = "1100";
		  objArr[1][2] = 5;
		  
		  
		  objArr[2][0] = "Samsang";
		  objArr[2][1] = "A50";
		  objArr[2][2] = 10;
		  return objArr;
	}

}
