package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@id='menu1']")).click();
//		driver.findElement(By.xpath("//a[text()='JavaScript']")).click();
		
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		List<WebElement> allElements=driver.findElements(By.xpath("//a[@role='menuitem']"));
		for(WebElement e: allElements) {
			System.out.println(e.getText());
			if(e.getText()=="JavaScript") {
				e.click();}
			}
		
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		driver.findElement(By.xpath("//a[text()='CSS']")).click();
		
			
		}
		

	}


