package WebAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login_Chrome {

	public static void main(String[] args) {
	
//      1.Open the web browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\antho\\Automation\\WebAutomation\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
//        2. Navigate to the web application
//      http://sdettraining.com/trguitransactions/AccountManagement.aspx
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        // find elements; locate element, determine action, pass any parameters    
//      3. Enter the email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
//      4. Enter the password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
//      5. Click login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
//      6. Get confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("confirmation: " + message);
        
        String headerTitle = driver.findElement(By.className("heading-title")).getText();
        System.out.println("confirmation = " + headerTitle);
//		verify the title of the page(name displayed on tab
        String pageTitle = driver.getTitle();
        	if (pageTitle.equals("SDET Training | Account Management")) {
        		System.out.println("Page title test passed");
        	}
//      7. Close the broswer
    	driver.close();

	}

}
