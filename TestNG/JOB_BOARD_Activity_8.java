package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_8 {
	
	// Login into the website’s backend
	//Goal: Visit the site’s backend and login
	
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
	   	
	     driver = new FirefoxDriver();
	     driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}     
     @Test 
     public void Login() throws InterruptedException {
 
     System.out.println("Below is Activity_8:");
     driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
     driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
     String Confirmation = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/h1")).getText();   
     Thread.sleep(1000);
     String ExpectedTitle = "Dashboard";
     Assert.assertEquals(ExpectedTitle, Confirmation);
     System.out.println("The Title of the page is:" +Confirmation);
    
     } 
    @AfterClass
     public void afterMethod() {      	 
    	 System.out.println("Closing the browser session");      	 
    	 	driver.close();
    	 } 
   
 }
