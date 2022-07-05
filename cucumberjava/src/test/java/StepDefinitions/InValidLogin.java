package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Init.com.Init;
import PageObject.O_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 public class InValidLogin extends Init {

	//private WebDriver driver;
	O_Login Login = new O_Login(driver);

	@When("Click on login link")
	public void User_Click_On_Login_Link() {
		Login.OpenBrowser();
		Login.LoginLink();

	}

	@Then("Enter Invalid Member ID")
	public void Enter_Invaid_MemberID() throws IOException {
		Login.EnterUserName(Init.getdata("Sheet1", 0, 1));

	}

	@Then("Enter Valid password")
	public void Enter_Valid_password() {
		Login.EnterPassword("password");
	}

	@And("Click on login button")
	public void Click_On_login_button() {
		Login.LoginButton();
	}

	@Then("Verify validation message")
	public void Verify_validation_message() {
		Login.LoginValidationMessage(true);

	}
}
