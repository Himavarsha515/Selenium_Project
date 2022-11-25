
package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'25')]")).click();
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		List<WebElement> allElements=driver.findElements(By.xpath("//td[@data-month='10']"));
		for(WebElement e: allElements) {
			//System.out.println(e.getText());
			if(e.getText()=="26") {
				e.click();
			}
			
		}
		
		
		//
		
		
		

	}

}
