package com.ey.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ey.base.TestBase;

public class BankMangLoginTest extends TestBase {
	@Test
	public void bankMangLoginTest() {
		Assert.assertTrue(driver.findElement(By.xpath(or.getProperty("bml_login"))).isDisplayed());
		driver.findElement(By.xpath(or.getProperty("bml_login"))).click();
		

}
}