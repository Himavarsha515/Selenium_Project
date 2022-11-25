package Report;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;



public class cd {


	@Test
	
   public static void Create() throws InterruptedException {
        // TODO Auto-generated method stub
        ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        
        driver.get("https://ineuron-courses.vercel.app/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement username=driver.findElement(By.name("email1"));
        username.sendKeys("ineuron@ineuron.ai");
        driver.findElement(By.id("password1")).sendKeys("ineuron");    
        driver.findElement(By.className("submit-btn")).click();
        
        WebElement testDropDown = driver.findElement(By.xpath("//span[contains(text(),'Manage')]"));
        Actions action=new Actions(driver);
        action.moveToElement(testDropDown).perform();
        
        driver.findElement(By.xpath("//span[text()='Manage Categories']")).click();
        Set<String> childs=driver.getWindowHandles();
        List<String> list=new ArrayList<String>(childs);
        
        String first=list.get(1);
        
        driver.switchTo().window(first);
        
        driver.findElement(By.xpath("//button[contains(text(),'Add New Category')]")).click();
        
        Alert alt =driver.switchTo().alert();
        
        alt.sendKeys("Varsha");
        alt.accept();
        
        AssertJUnit.assertTrue(true);
        
     
       
        
        
        



   }



}