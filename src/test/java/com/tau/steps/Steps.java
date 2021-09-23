package com.tau.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tau.base.BaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;

public class Steps extends BaseUtil {
	
	private BaseUtil baseUtil;
	
	public Steps(BaseUtil util) {
		this.baseUtil = util;
	}
	private WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Given("The user is in the login page of automationPractice")
	public void the_user_is_in_the_login_page_of_automationPractice() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@When("The user enter valid {string} and {string} with {string}")
	public void the_user_enter_valid_credentials(String username, String password, String userFullName1) {
		
		baseUtil.userFullName = userFullName1;
		
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();

	}

	@Tha("The user should be taken to my account")
	public void the_user_should_be_taken_to_my_account() throws Exception {
		
		String actualuserFullName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText().toString();
		Assert.assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
	}
	
	@After()
	public void tearDown() {
		driver.quit();
	}
}
