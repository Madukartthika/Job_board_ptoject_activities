package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_6{
	
	//Apply to a job
	//Goal: Search for a job and apply for it
	
	WebDriver driver;

	 @BeforeClass public void beforeMethod() {
	   	driver = new FirefoxDriver();
         driver.get("https://alchemy.hguy.co/jobs");	 
	}   
     @Test
     public void Title() throws InterruptedException {
    System.out.println("Below is Activity_6:");
	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	Thread.sleep(500);
	String heading = driver.getTitle();
	System.out.println("The heading URL is :"+heading);     
	Thread.sleep(100);
	driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Test automation");
	Thread.sleep(500);
	driver.findElement(By.cssSelector(".search_submit > input:nth-child(1)")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("(//div[@class='position'])[1]")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input")).click();
	String Email = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a")).getText();
	Thread.sleep(50);
	System.out.println("The Email id is :"+Email);        
	  
     }
		
		 @AfterClass 
		 public void afterMethod()
		 { driver.close(); }
		 
 }
