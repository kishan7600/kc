package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Init.com.Init;
import PageObject.O_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 public class login extends Init{

	//private WebDriver driver;
	O_Login Login = new O_Login(driver);

	@When("User click on login link")
	public void User_Click_On_Login_Link() {
		
		Login.LoginLink();

	}

	@Then("User enter memberID")
	public void User_enter_memberID() throws IOException {
		Login.EnterUserName(Init.getdata("Sheet1", 0, 0));

	}

	@Then("User enter password")
	public void User_Enter_MemberID() {
		Login.EnterPassword("password");
	}

	@And("User click on login button")
	public void User_Click_On_Login_Button() {
		Login.LoginButton();
	}

	@Then("User verify member welcome element")
	public void User_Verify_Member_welcome_Element() {
		Login.VerifyMemberlogin(true);

	}
}
