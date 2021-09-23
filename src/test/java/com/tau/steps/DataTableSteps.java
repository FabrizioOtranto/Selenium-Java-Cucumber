package com.tau.steps;

import java.awt.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;

public class DataTableSteps {
	private WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("The user is in the login page of Rendring webDB")
	public void the_user_is_in_the_login_page_of_rendering_web() {
		driver.get("https://rendering-fabry.web.app/examples/login");
		
	}

	@When("The user enter valid credentials")
	public void the_user_enter_valid_credentials(DataTable table) {
		java.util.List<String> loginForm = table.asList();
		driver.findElement(By.name("user")).sendKeys(loginForm.get(0));
		driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
		driver.findElement(By.name("user")).submit();

	}

	@Tha("The user should be taken to the index pageDB")
	public void the_user_should_be_taken_to_the_index_page() {
		
		String actualResult = driver.getTitle();
		String expectedResult = "Pagina web Danny";
		
		Assert.assertEquals(expectedResult, actualResult);

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
