package JOB_BOARD.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_9 {
	
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
 
     System.out.println("Below is Activity_9:");
     driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
     driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
     String Confirmation = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/h1")).getText();   
     Thread.sleep(1000);
     String ExpectedTitle = "Dashboard";
     Assert.assertEquals(ExpectedTitle, Confirmation);
     System.out.println("The Title of the page is:" +Confirmation);
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
     driver.findElement(By.xpath("//*[@id=\"_application\"]")).sendKeys("https://alchemy.hguy.co/jobs/jobs");
     driver.findElement(By.xpath("//*[@id=\"_company_website\"]")).sendKeys("https://alchemy.hguy.co/jobs/");
 	driver.findElement(By.xpath("//*[@id=\"_job_location\"]")).sendKeys("New cary");
 	driver.findElement(By.xpath("//*[@id=\"_company_name\"]")).sendKeys("Alchemy");
 	driver.findElement(By.xpath("//*[@id=\"_company_tagline\"]")).sendKeys("Alchemy is the training partner for MNC companies");
 	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[1]/div[5]/div/div[1]/form/div/div/div/div/div/div/p[8]/span/button[1]")).click();
 	//System.out.println("button clicked");
 	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	//driver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
 	//System.out.println("button clicked");
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

 	driver.findElement(By.xpath("(//div[@class='attachment-preview js--select-attachment type-image subtype-png landscape'])[10]")).click();
    driver.findElement(By.xpath("/html/body/div[11]/div[1]/div/div/div[4]/div/div[2]/button")).click();
    driver.findElement(By.xpath("//*[@id=\"_company_twitter\"]")).sendKeys("alchemy@twitter.com");
    driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("Selenium trainer");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
    String Confirmation1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[1]")).getText();   
    Thread.sleep(1000);
    String ExpectedTitle1 = "Selenium trainer is now live.";
    Assert.assertEquals(ExpectedTitle1, Confirmation1);
    System.out.println("The comfirmation dispalyed on the page is:" +Confirmation1);
     
     } 
    @AfterClass
     public void afterMethod() {      	 
    	    	 
    	 	driver.close();
    	 } 
   
 }
