package Day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelLogin {
	ChromeDriver driver;
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("https://ineuron-courses.vercel.app/login");
		
	}
	@AfterMethod
	public void Clearup() {
		driver.quit();
	}
	@Test(dataProvider="TestData")
	public void Test(String s1,String s2) {
//		ChromeDriver driver= new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//		driver.get("https://ineuron-courses.vercel.app/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.name("email1")).sendKeys(s1);
	    driver.findElement(By.id("password1")).sendKeys(s2);    
	    driver.findElement(By.className("submit-btn")).click();
//	    int k=driver.findElements(By.xpath("//button[normalize-space()='Sign out']")).size();
//	    AssertJUnit.assertEquals(k==1, true);
	    AssertJUnit.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed(), true);
	    
	   
	}
	@DataProvider(name="TestData")
	public Object[][] testData(){
		Object[][] arr=null;
	
		XSSFWorkbook wb;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\arlhimav\\Desktop\\DataTest.xlsx")));
			XSSFSheet sh1=wb.getSheet("login");
			int row=sh1.getPhysicalNumberOfRows();
			int col=sh1.getRow(0).getPhysicalNumberOfCells();
			arr=new Object[row][col];
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j]=sh1.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return arr;
		
	}

}
