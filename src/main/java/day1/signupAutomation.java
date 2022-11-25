package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class signupAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver cd=new ChromeDriver();
		cd.get("https://ineuron-courses.vercel.app/login");
		cd.manage().window().maximize();
		
		cd.findElement(By.linkText("New user? Signup")).click();
		Thread.sleep(5000);
		

		cd.findElement(By.xpath("//input[@name='name']")).sendKeys("varsha");
		cd.findElement(By.xpath("//input[@id='email']")).sendKeys("varsha@gmail.com");
		cd.findElement(By.xpath("//input[@name='password']")).sendKeys("var123");
		//Thread.sleep(5000);
		//Thread.sleep(10000);
		cd.findElement(By.xpath("//input[@name='password']")).sendKeys("var123");
		cd.findElement(By.xpath("//lable[text()='Testing']")).click();
		cd.findElement(By.xpath("//input[@id='gender']")).click();
		cd.quit();
		
		
		

	}

}
