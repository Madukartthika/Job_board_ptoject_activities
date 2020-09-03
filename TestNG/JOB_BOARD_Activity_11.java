package JOB_BOARD.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_11{
	
	//Apply to a job
	//Goal: Search for a job and apply for it
	
	WebDriver driver;

	 @BeforeClass public void beforeMethod() {
	   	driver = new FirefoxDriver();
         driver.get("https://alchemy.hguy.co/jobs");	 
	}   
     @Test
     public void Title() throws InterruptedException {
    System.out.println("Below is Activity_11:");
	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	Thread.sleep(500);
	String heading = driver.getTitle();
	System.out.println("The heading URL is :"+heading);     
	Thread.sleep(100);
	driver.findElement(By.cssSelector("#search_keywords")).sendKeys("test Automation");

	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 WebElement Freelance = driver.findElement(By.xpath("//*[@id=\"job_type_freelance\"]")); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 Freelance.click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 WebElement Internship = driver.findElement(By.xpath("//*[@id=\"job_type_internship\"]")); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 Internship.click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 WebElement Parttime = driver.findElement(By.xpath("//*[@id=\"job_type_part-time\"]")); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 Parttime.click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 WebElement temporary = driver.findElement(By.xpath("//*[@id=\"job_type_temporary\"]")); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 temporary.click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.findElement(By.cssSelector(".search_submit > input:nth-child(1)")).click();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 driver.manage().window().maximize();
     js.executeScript("window.scrollBy(0,100)");
     
	 driver.findElement(By.xpath("(//div[@class='position'])[2]")).click();
	 
	 String Title = driver.findElement(By.xpath("//div[@class='ast-single-post-order']")).getText();
	 System.out.println("The heading URL is :"+Title);  
	 driver.findElement(By.xpath("//div[@class='job_application application']")).click();
     }
		
		 @AfterClass 
		 public void afterMethod()
		 { driver.close(); }
		 
 }
