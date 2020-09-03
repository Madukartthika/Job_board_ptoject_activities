package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_1 {
	
	// Verify the website title
	//Goal: Read the title of the website and verify the text
	
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
	   	
	     driver = new FirefoxDriver();
	     driver.get("https://alchemy.hguy.co/jobs");
	}     
     @Test 
     public void Title() throws InterruptedException {
 
     System.out.println("Below is Activity_1:");
     String Title = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[1]/div/div/h1/a")).getText();
     Thread.sleep(1000);
     String ExpectedTitle = "Alchemy Jobs";
     Assert.assertEquals(ExpectedTitle, Title);
     System.out.println("The Title of the page is:" +Title);
      
 
     } 
    @AfterClass
     public void afterMethod() {      	 
    	 System.out.println("Closing the browser session");      	 
    	 	driver.close();
    	 } 
   
 }
