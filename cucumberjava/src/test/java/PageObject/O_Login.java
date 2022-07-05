package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class O_Login {

	WebDriver driver;

	By loginLink = By.id("navItem_0");
	By UserName = By.id("UserName");
	By Password = By.id("Password");
	By loginButton = By.id("btnLogin");
	By welcome = By.xpath("//*[@class='welcomeInfo']");

	public O_Login(WebDriver driver) {
		this.driver = driver;

	}

	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dynamics-dev.toastmasters.org");
	}

	public void LoginLink() {
		driver.findElement(loginLink).click();
	}

	public void EnterUserName(String strUserName) {
		driver.findElement(UserName).sendKeys(strUserName);
	}

	public void EnterPassword(String strPassword) {
		driver.findElement(Password).sendKeys(strPassword);
	}

	public void LoginButton() {
		driver.findElement(loginButton).click();

	}

	public void VerifyMemberlogin(boolean value) {
		driver.findElement(welcome).isDisplayed();
		driver.quit();
	}
}
