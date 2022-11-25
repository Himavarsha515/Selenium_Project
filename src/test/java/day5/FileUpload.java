package day5;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUpload {
	@Test
	public void test() throws IOException, InterruptedException {
		WebDriver wb=new ChromeDriver();
		wb.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        wb.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        Actions act=new Actions(wb);
        wb.get("https://the-internet.herokuapp.com/upload");
        act.moveToElement(wb.findElement(By.xpath("//input[@id='file-upload']"))).click().perform();
        Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\arlhimav\\Desktop\\fileupload.exe");
		wb.findElement(By.xpath("//input[@id='file-submit']")).click();
		wb.quit();
		
	}

}
