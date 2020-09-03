package JOB_BOARD.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_4 {
	//Verify the website’s second heading
	//Goal: Read the second heading of the website and verify the text
	
		WebDriver driver;
		@BeforeClass
		public void beforeMethod() {
		driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
		}
		
	@Test
	public void Title() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Below is Activity_4:");
	String Title = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2")).getText();
	driver.manage().window().maximize();
	js.executeScript("window.scrollBy(0,1000)");
	Thread.sleep(1000);
	String ExpectedTitle = "Quia quis non";
	 Assert.assertEquals(ExpectedTitle, Title);
	System.out.println("The 2nd heading on the page is:" +Title);
			        
	}
	@AfterClass
 	public void afterMethod() {
    driver.close();
 	}

}
