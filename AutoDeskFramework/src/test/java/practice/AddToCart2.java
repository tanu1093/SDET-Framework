package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autodest.genericUtils.ExcelUtility;

public class AddToCart2 {
	
	ExcelUtility elib = new ExcelUtility();
	
	@Test(dataProvider = "getDataForAddToCart")
	public void addToCartTest(String cat , String productName , String Qty) {
		System.out.println("cat==>" + cat + ",  productName==> "+productName + ", Qty==>"+Qty);
	}
	
	@DataProvider
	public Object[][] getDataForAddToCart() throws Throwable {
		int rowCount = elib.getRowCount("addToCartTest");
		System.out.println("================>"+rowCount);
		Object[][] objArr = new Object[rowCount][3];
	       
		for(int i=0 ; i<rowCount ; i++) {
			objArr[i][0] = elib.getExcelData("addToCartTest", i, 0);
			objArr[i][1] = elib.getExcelData("addToCartTest", i, 1);
			objArr[i][2] = elib.getExcelData("addToCartTest", i, 2);
		}

		  return objArr;
	}

}
