package testNG;

import org.testng.Assert;
import static org.testng.Assert.assertEquals; //import thư viện để viết assert gọn hơn
import org.testng.annotations.Test;

public class Topic_01_Assert {
	String address = "";
	
	@Test
	public void TC_01() {
		Assert.assertEquals(address, "Hà Nội");
		assertEquals(address, "Hà Nội");//cách  viết gọn sau khi import thư viện
		
	}

}
