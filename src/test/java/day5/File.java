package day5;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class File {
	public void test() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("C:\\Users\\arlhimav\\Desktop\\Selenium", System.getProperty("user.dir"));
		//chromePrefs.put("//C:\\Users\\arlhimav\\Downloads", System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/download");
//		File dir = new File("C:\\Users\\arlhimav\\Desktop\\Selenium");
//		  File[] dirContents = dir.listFiles();
		driver.findElement(By.xpath("//a[normalize-space()='exibirDocumento (5).pdf']")).click();
		
		
		
		
		
	}
	

}
