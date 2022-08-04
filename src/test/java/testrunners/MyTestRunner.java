package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//adapter 2.0 , extent spark html report, spark pdf, extent cucumber adapter
// in junit features run in parallel, but not scenario wise
//inside failsafe plugin give the parallelism
//timeline plugin to check if tests run in parallel, use mvn verify cmd

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/features"},
		glue = {"stepDefinations","AppHooks"},
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"}
		)
public class MyTestRunner {

}
