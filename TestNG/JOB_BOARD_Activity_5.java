package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_5{
	// Navigate to another page
	//Goal: Navigate to the “Jobs” page on the site.
	
	WebDriver driver;

	 @BeforeClass public void beforeMethod() {
	   	driver = new FirefoxDriver();
         driver.get("https://alchemy.hguy.co/jobs");	 
	}   
     @Test
     public void Title() throws InterruptedException {
 
    		     
	     System.out.println("Below is Activity_5:");
	     driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	        Thread.sleep(500);
	        String heading = driver.getTitle();
	        System.out.println("The heading URL is :"+heading);     
	        Thread.sleep(1000);
	        String ExpectedTitle = "Jobs – Alchemy Jobs";
	        Assert.assertEquals(ExpectedTitle, heading);
	        System.out.println("The heading on the webpage is:" +heading);     
     }
		
		 @AfterClass 
		 public void afterMethod()
		 { driver.close(); }
		 
 }
