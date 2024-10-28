package utils;

import org.testng.annotations.DataProvider;

public class urlData {
	
	@DataProvider(name = "urlData", parallel = true)
	public Object[][] getData() {
	    return new Object[][] {
				{ "https://www.flipkart.com/" }, // First set of data
				{ "https://www.amazon.in/" }, // Second set of data
				{ "https://www.myntra.com/" } // Third set of data
	    };
	}
	


}
