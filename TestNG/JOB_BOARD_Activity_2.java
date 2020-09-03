package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_2 {
	//Verify the website heading
	//Goal: Read the heading of the website and verify the text
	
	WebDriver driver;

	@BeforeClass
	public void beforeMethod() {
		driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
	}     
     @Test
     public void Title() throws InterruptedException {
    		     JavascriptExecutor js = (JavascriptExecutor) driver;

	     System.out.println("Below is Activity_2:");
	          
	        String Title = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/h1")).getText();
	
	        driver.manage().window().maximize();
	        js.executeScript("window.scrollBy(0,100)");
	        Thread.sleep(1000);
	        String ExpectedTitle = "Welcome to Alchemy Jobs";
	        Assert.assertEquals(ExpectedTitle, Title);
	        System.out.println("The heading on the webpage is:" +Title);     
     }
  @AfterClass
 	public void afterMethod() {
    driver.close();
 	}
 }
