package day5;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*
 * MutableCapabilities capabilities = new MutableCapabilities();
HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
browserstackOptions.put("osVersion", "16");
browserstackOptions.put("deviceName", "iPhone 14");
browserstackOptions.put("local", "false");
capabilities.setCapability("bstack:options", browserstackOptions);

 */

public class SeleniumgridDemo {
	WebDriver driver;
	@Parameters({"s1","s2","s3","s4"})
	@BeforeMethod()
	public void setup(String s1,String s2,String s3,String s4) {
		DesiredCapabilities cap=new DesiredCapabilities();
		//DesiredCapabilities cap1=new DesiredCapabilities();
		
//		cap.setCapability("browserName", "Edge");
//		cap.setCapability("browserVersion", "latest");
//		cap.setCapability("osVersion", "16");
//		cap.setCapability("deviceName", "iPhone 14");
		cap.setCapability("browserName", s3);
		cap.setCapability("browserVersion", s4);
		cap.setCapability("os", s1);
		cap.setCapability("osVersion", s2);

		
		URL url=null;
		try {
			url=new URL("https://varsha_WXp5Vy:AFKaHmqSB7Xp9syqKT6U@hub-cloud.browserstack.com/wd/hub");
		}catch(Exception e) {
			
		}
		driver=new RemoteWebDriver(url,cap);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		
	}
	@AfterMethod
	public void clearup() {
		driver.quit();
	}
	@Test
	public void validCredentials()
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        AssertJUnit.assertEquals(driver.findElement(By.xpath("//b[text()='Admin']")).isDisplayed(), true);
        
    }
	@Test
    public void validUsernameInvalidPassword()
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k7iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        AssertJUnit.assertEquals(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed(), true);
        
    }

}
