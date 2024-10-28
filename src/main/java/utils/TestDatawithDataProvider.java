package utils;

import org.testng.annotations.DataProvider;

public class TestDatawithDataProvider {
	@DataProvider(name = "userData")
    public static Object[][] provideUserData() {
        return new Object[][] {
            { "nandakishore.shopping@gmail.com", "Jan@2024" },
        };
    }

}
