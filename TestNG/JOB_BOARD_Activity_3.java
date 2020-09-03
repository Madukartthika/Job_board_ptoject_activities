package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_3 {
	
	//Get the url of the header image
	//Goal: Print the url of the header image to the console
	
	WebDriver driver;
		@BeforeClass
		public void beforeMethod() {
		 driver = new FirefoxDriver();
	        driver.get("https://alchemy.hguy.co/jobs");
		}     
		@Test
		public void Title() throws InterruptedException {
	     System.out.println("Below is Activity_3:");
	     
	     // Find the URL of the image
	     
	        driver.findElement(By.xpath("//html/body/div/div/div/div/main/article/header/div/img"));
	        Thread.sleep(50);
	        String Image = driver.getCurrentUrl();
	        System.out.println("The Image URL is :"+Image);
	        
	      // Find the 1st URL heading
	        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[1]/div/div/h1/a")).click();
	        Thread.sleep(500);
	        String option_heading1 = driver.getCurrentUrl();
	        System.out.println("The 1st heading URL is :"+option_heading1);
	        
	      	        
	     // Find the 2nd URL heading
	        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	        Thread.sleep(500);
	        String option_heading2 = driver.getCurrentUrl();
	        System.out.println("The 2nd heading URL is :"+option_heading2);
	        
	        
	     // Find the 3rd URL heading
	        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a")).click();
	        Thread.sleep(500);
	        String option_heading3 = driver.getCurrentUrl();
	        System.out.println("The 3rd heading URL is :"+option_heading3);
	        
	        // Find the 4th URL heading
	        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
	        Thread.sleep(500);
	        String option_heading4 = driver.getCurrentUrl();
	        System.out.println("The 4th heading URL is :"+option_heading4);
	 
	}
	@AfterClass
 	public void afterMethod() {
    driver.close();
 	}
}
