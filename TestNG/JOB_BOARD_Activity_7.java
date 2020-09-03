package JOB_BOARD.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_7{
	//Create a new job listing
	//Goal: Create a new job listing
	
	WebDriver driver;

	 @BeforeClass public void beforeMethod() {
	   	driver = new FirefoxDriver();
         driver.get("https://alchemy.hguy.co/jobs");	 
	}   
     @Test
     public void Title() throws InterruptedException {
    System.out.println("Below is Activity_7:");
	
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click(); 
	  Thread.sleep(500); 
	  String heading = driver.getTitle();
	  System.out.println("The heading URL is :"+heading); 
	  Thread.sleep(100);
	  driver.findElement(By.xpath("//*[@id=\"create_account_email\"]")).sendKeys("training18@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"job_title\"]")).sendKeys("API Engineer");
	  driver.findElement(By.xpath("//*[@id=\"job_location\"]")).sendKeys("New cary"); 
	  Select JobType = new Select(driver.findElement(By.name("job_type")));
	  JobType.selectByVisibleText("Freelance");
	  //driver.findElement(By.xpath("/html")).sendKeys("Need 5+ experienced API tester");
	  driver.switchTo().frame(driver.findElement(By.id("job_description_ifr")));
	  driver.findElement(By.id("tinymce")).sendKeys("Need 5+ experienced API tester"); driver.switchTo().parentFrame();
	  driver.findElement(By.xpath("//*[@id=\"application\"]")).sendKeys("https://alchemy.hguy.co/jobs/jobs");
	  driver.findElement(By.xpath("//*[@id=\"company_name\"]")).sendKeys("Alchemy"); 
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]")).click();
	  driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).
	  click(); Thread.sleep(1000);
	  
	  String Confirmation = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div")).getText(); 
	  Thread.sleep(10); 
	  String ExpectedTitle ="Job listed successfully. To view your listing click here.";
	  Assert.assertEquals(ExpectedTitle, Confirmation);
	  System.out.println("The confirmation submitted message on the page is:"+Confirmation);
	 
		  System.out.println("Verifying the job in job link");
		  //driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click(); 
		  driver.get("https://alchemy.hguy.co/jobs/jobs");
		  driver.findElement(By.cssSelector("#search_keywords")).sendKeys("API Engineer"); 
		 Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class='search_submit']/.")).click(); 
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/job/alchemy-new-cary-5-api-engineer-5/']")).isDisplayed(); 
			 
    }     
		
	@AfterClass 
	public void afterMethod()
	{ driver.close();
	}
		 
 }
