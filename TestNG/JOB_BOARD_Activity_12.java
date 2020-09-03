package JOB_BOARD.TestNG;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_12 {
	
	// Creating a user using an external file
	//Goal: Create a user using details from an external CSV/Excel file
	
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
	   	
	     driver = new FirefoxDriver();
	     driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}     
     @SuppressWarnings("resource")
	@Test 
     public void Login() throws InterruptedException, IOException{
    	  
     System.out.println("Below is Activity_12:reading data from excel");

     File file = new File("C:\\Users\\MadukartthikaEswaran\\Desktop\\Selenium training\\Testdata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		System.out.println("file fetched");

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		String username = cell1.toString();
		String password = cell2.toString();
		XSSFRow row1 = sheet.getRow(1);
		
		XSSFCell cell3 = row1.getCell(0);
		XSSFCell cell4 = row1.getCell(1);
		XSSFCell cell5 = row1.getCell(2);
		XSSFCell cell6 = row1.getCell(3);
		XSSFCell cell7 = row1.getCell(4);
		
		String username1 = cell3.toString();
		String email = cell4.toString();
		String Fname = cell5.toString();
		String Lname = cell6.toString();
		String URL = cell7.toString();
		
		System.out.println(username + password);
	    driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys(username);
	    Thread.sleep(1000);
	    Reporter.log(username);
	    driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys(password);
	    Thread.sleep(1000);
	    Reporter.log(password);
	    driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
	    Reporter.log("clicked on login");
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
	    Reporter.log("clicked on add user");
	    driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys(username1);
	     driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	     driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(Fname);
	 	driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(Lname);
	 	driver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys(URL);
	 	Reporter.log("input completed for all fields");
    
    //show password button 
	
	  driver.findElement(By.xpath("//button[@class = 'button wp-generate-pw hide-if-no-js']")).click();
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	  Reporter.log("clicked on show password");
	  // click on add user button
	  driver.findElement(By.xpath("//*[@id=\"createusersub\"]")).click();
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  Reporter.log("clicked on create user");
	  
	  System.out.println("Verifying the user is available");
	  
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin/users.php");
	 
	driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).sendKeys(username1); 

	driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click(); 
	Reporter.log("clicked on search to find the added new user");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@class='username column-username has-row-actions column-primary']")).isDisplayed();
	Reporter.log("captured the screenshot");
	System.out.println("Found the user");
	
     } 
    @AfterClass
     public void afterMethod() {      	 
    	    	 
    	 	driver.close();
    	 } 
   
 }
