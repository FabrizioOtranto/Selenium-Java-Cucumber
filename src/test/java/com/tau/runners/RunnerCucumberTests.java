package com.tau.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue= {"com.tau.steps"}, features = "src/test/resources", 
plugin={"pretty:target/cucumber-htmlreport.text", "json:target/cucmber-report.json"})
public class RunnerCucumberTests {
	
}
