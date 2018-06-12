package WebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Anthony Test";
		String email = "anthony@test.com";
		String phone = "078254499098";
		String country = "India";
		String password = "Password@1234";
		String browser = "Firefox";
	//	String lowerCaseCopy = "Create Account";
        WebDriver driver;
	//	String linkText = "Create Account";
        String gender;
		String weeklyEmail;
		String monthlyEmail;
		String occassional; 
		
		
// 	1. create webdrive
//	cross browser		
		if (browser.equals("Firefox")){
	System.setProperty("webdriver.gecko.driver" , "C:\\Users\\antho\\Automation\\WebAutomation\\geckodriver.exe");	
	driver = new FirefoxDriver();
	System.out.println("Using FF");
	}
	else {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\antho\\Automation\\WebAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Using Chrome");
	}
	
//	2. navigate to account management page, click on create account
	// IF statement for the 'Create Account' text on the browser, Chrome converts all character to upper case.  
	// this makes it find the upper case if it is on a Chrome browser	
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		if  (browser.equals("Firefox")){
			driver.findElement(By.linkText("Create Account")).click();;
			System.out.println("Using Lower case");
			}
		else { 
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		System.out.println("Using Upper Case");
		}

	
// 	3. Fill out form
	driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(name);
	driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
	String phoneNumberCopy = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/div[3]/div[1]/label")).getText();
	System.out.println("confirmation = " + phoneNumberCopy);
	driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys(phone);
	driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys(password);
// Radio buttons
	driver.findElement(By.id("MainContent_Female")).click();
// drop down
	new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
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
