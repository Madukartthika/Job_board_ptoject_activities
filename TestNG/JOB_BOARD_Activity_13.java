package JOB_BOARD.TestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class JOB_BOARD_Activity_13 {
	
	WebDriver driver;
	 @BeforeClass public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\MadukartthikaEswaran\\eclipse\\java-2020-06\\eclipse\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	   	driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");	
	}
    @Test
    public void Title() throws InterruptedException, IOException {
      System.out.println("Below is Activity_13:");
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
	  Thread.sleep(500);
	  String heading = driver.getTitle();
	  System.out.println("The heading URL is :"+heading);
	  Thread.sleep(100);
	  String filename = "Test data1.xlsx";
	  File src = new File("C:\\Users\\MadukartthikaEswaran\\Desktop\\Selenium training\\Test data1.xlsx");
	 
	  FileInputStream inputStream = new FileInputStream(src);
	  Workbook workbook1= null;
	  String fileExtensionName = filename.substring(filename.indexOf("."));
	  if(fileExtensionName.equals(".xlsx"))
	  {
	  	workbook1 = new XSSFWorkbook(inputStream);
	  }
	  else if(fileExtensionName.equals(".xls"))
	  {
	  	workbook1 = new HSSFWorkbook(inputStream);
	  }
	 
	  Sheet sheet1 = workbook1.getSheetAt(0);
	  Row row = sheet1.getRow(0);
		Cell cell1 = row.getCell(0);
		Cell cell2 = row.getCell(1);
		Cell cell3 = row.getCell(2);
		Cell cell4 = row.getCell(3);
		Cell cell5 = row.getCell(4);
		Cell cell6 = row.getCell(5);
		Cell cell7 = row.getCell(6);

		String email1 = cell1.toString();
		String JobTitle1 = cell2.toString();
		String Location = cell3.toString();
		String JobType = cell4.toString();
		String Description = cell5.toString();
		String URL = cell6.toString();
		String compName = cell7.toString();
			 
	  driver.findElement(By.xpath("//*[@id=\"create_account_email\"]")).sendKeys(email1);
	  Thread.sleep(100);	
	  driver.findElement(By.xpath("//*[@id=\"job_title\"]")).sendKeys(JobTitle1);
	  driver.findElement(By.xpath("//*[@id=\"job_location\"]")).sendKeys(Location); 
	  driver.findElement(By.name("job_type")).click();
	  driver.findElement(By.name("job_type")).sendKeys(JobType);
	  driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
	  driver.findElement(By.id("tinymce")).sendKeys(Description); driver.switchTo().parentFrame();
	  driver.findElement(By.xpath("//*[@id=\"application\"]")).sendKeys(URL);
	  driver.findElement(By.xpath("//*[@id=\"company_name\"]")).sendKeys(compName); 
	  Reporter.log("details capured");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]")).click();
	  driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
	  Reporter.log("job posted");
	  Thread.sleep(1000);
	  
	  String Confirmation = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div")).getText(); 
	  Thread.sleep(10); 
	  String ExpectedTitle ="Job listed successfully. To view your listing click here.";
	  Assert.assertEquals(ExpectedTitle, Confirmation);
	  System.out.println("The confirmation submitted message on the page is:"+Confirmation);
	 
		  System.out.println("Verifying the job in job link");
		  driver.get("https://alchemy.hguy.co/jobs/jobs");
		  driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Senior tester"); 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='search_submit']/.")).click(); 
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/job/alchemy-california-5-senior-tester/']")).isDisplayed(); 
		  Reporter.log("job found"); 
    }     
		
	@AfterClass
	public void afterMethod()
	{ driver.close();
	}
}
