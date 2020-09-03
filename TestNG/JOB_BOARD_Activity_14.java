package JOB_BOARD.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JOB_BOARD_Activity_14 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "root", "pa$$w0rd" }};
    }
    
    @DataProvider(name = "Add new user")
    public static Object[][] data() {
        return new Object[][] { { "jackey", "Jackey@alchemy.com","Jack","Rose","https://alchemy.hguy.co/jobs/wp-admin"}};
    }
    @Test (dataProvider = "Authentication",priority = 1)
    public void loginTestCase(String username, String password) {
        //Find username and password fields
    	
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"user_pass\"]"));
        
        //Enter values
        usernameField.sendKeys(username);
        Reporter.log("Typing in username");
        passwordField.sendKeys(password);
        Reporter.log("Typing in Password");
        
        //Click to Log in
        driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
        Reporter.log("log in successful");
        
        //confirmation for login -  Message
        String Confirmation = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/h1")).getText();   
        String ExpectedTitle = "Dashboard";
        Reporter.log("capturing the title");
        Assert.assertEquals(ExpectedTitle, Confirmation);
        Reporter.log("verifying the title");
        System.out.println("The Title of the page is:" +Confirmation);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
        Reporter.log("click on user");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/a")).click();
        Reporter.log("click on add new user");
    }

    @Test (dataProvider = "Add new user",priority = 2)
    public void Addnewuser(String username, String Email,String Firstname, String Lastname, String Website ) {
        
       	//Find the required fields
    	
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement EmailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement FirstnameField = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        WebElement LastnameField = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        WebElement WebsiteField = driver.findElement(By.xpath("//*[@id=\"url\"]"));
        Reporter.log("Captured all data");
        
        //Enter values
        usernameField.sendKeys("jackey");
        Reporter.log("Typing in username");
        EmailField.sendKeys("Jackey@alchemy.com");
        Reporter.log("Typing in Password");
        FirstnameField.sendKeys("Jackey");
        Reporter.log("Typing in firstname");
        LastnameField.sendKeys("Rose");
        Reporter.log("Typing in lastname");
        WebsiteField.sendKeys("https://alchemy.hguy.co/jobs/wp-admin");
        Reporter.log("Typing in URL");
        
        //Click to show password button
        driver.findElement(By.xpath("//button[@class = 'button wp-generate-pw hide-if-no-js']")).click();
        Reporter.log("clicked on password button");
     	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
     	
        // click on add user button
        driver.findElement(By.xpath("//*[@id=\"createusersub\"]")).click();
        Reporter.log("capturing add user button flow");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        
    }
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}