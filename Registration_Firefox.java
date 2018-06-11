package WebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration_Firefox {

	public static void main(String[] args) {
		
// 	1. create webdrive
	System.setProperty("webdriver.gecko.driver" , "C:\\Users\\antho\\Automation\\WebAutomation\\geckodriver.exe");	
	WebDriver driver = new FirefoxDriver();
	
//	2. navigate to account managment page, click on create account
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	driver.findElement(By.linkText("Create Account")).click();
	
// 	3. Fill out form
	driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Anthony Test");
	driver.findElement(By.id("MainContent_txtEmail")).sendKeys("Anthony@test.com");
	String phoneNumberCopy = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/div[3]/div[1]/label")).getText();
	System.out.println("confirmation = " + phoneNumberCopy);
	driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("07838383838");
	driver.findElement(By.id("MainContent_txtPassword")).sendKeys("Password");
	driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("Password");
// Radio buttons
	driver.findElement(By.id("MainContent_Female")).click();
// drop down
	new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("India");
// Radio buttons
	driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
	driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail")).click();
	driver.findElement(By.id("MainContent_checkUpdates")).click();
	driver.findElement(By.id("MainContent_btnSubmit")).click();
	//	4.get confirmation
	String conirmationMessage = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
	System.out.println("success = " + conirmationMessage);
//	5 close browser
	driver.close();
	}

}
