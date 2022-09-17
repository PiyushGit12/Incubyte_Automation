package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={"src/test/resources/Features/ComposeGmail_TC.feature"},
		glue= {"Incubyte_StepDefinitions"},
		plugin = {"pretty",
				"html:target/MyReports/report.html",
				"junit:target/MyReports/report.xml",
				"json:target/MyReports/report.json"},
		monochrome=true,
		dryRun = false,
		publish = true,
		tags = "@Login"
		
		
		
	
		)


public class ComposeEmailRunner {

}
