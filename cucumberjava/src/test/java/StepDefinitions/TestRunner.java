package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/StepDefinitions/", 
glue = {
		"StepDefinitions" }, 
monochrome = true, 
plugin = { "pretty","html:target/HtmlRepots.html"})

public class TestRunner {

}