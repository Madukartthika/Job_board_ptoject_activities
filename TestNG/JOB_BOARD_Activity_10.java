package JOB_BOARD.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_10 {
	
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
 
     System.out.println("Below is Activity_10:");
     driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
     driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
     String Confirmation = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/h1")).getText();   
     Thread.sleep(1000);
     String ExpectedTitle = "Dashboard";
     Assert.assertEquals(ExpectedTitle, Confirmation);
     System.out.println("The Title of the page is:" +Confirmation);
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
     driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("Rosey");
     driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Rosey@alchemy.com");
     driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Rosey");
 	driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Jack");
 	driver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys("https://alchemy.hguy.co/jobs/wp-admin");
    //show password button 
 	driver.findElement(By.xpath("//button[@class = 'button wp-generate-pw hide-if-no-js']")).click();
 	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    // click on add user button
    driver.findElement(By.xpath("//*[@id=\"createusersub\"]")).click();
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    
     System.out.println("Verifying the user is available");
     
	 driver.get("https://alchemy.hguy.co/jobs/wp-admin/users.php");
	 driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).sendKeys("Rosey"); 

	 driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click(); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//*[@class='username column-username has-row-actions column-primary']")).isDisplayed(); 
     } 
    @AfterClass
     public void afterMethod() {      	 
    	    	 
    	 	driver.close();
    	 } 
   
 }
