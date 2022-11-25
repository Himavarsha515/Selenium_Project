package day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("http://www.google.com");
//		chromeDriver.findElement(By.name("q")).sendKeys("Automation Testing");
		chromeDriver.findElement(By.name("q"));
        String title=chromeDriver.getTitle();
        System.out.println("Title is "+title);
        String url=chromeDriver.getCurrentUrl();
        System.out.println("Url is "+url);
        chromeDriver.quit();   
        EdgeDriver edgeDriver=new EdgeDriver();
        
        }

	}


