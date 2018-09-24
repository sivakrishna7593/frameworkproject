package tests;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"D:\\siva203\\gmailbdd\\src\\test\\resources\\features\\feature1.feature","D:\\siva203\\gmailbdd\\src\\test\\resources\\features\\feature2.feature"},
				plugin={"pretty","html:target"},
				monochrome=true)
public class Gmailrunner {

}
