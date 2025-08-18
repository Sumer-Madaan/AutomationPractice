package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/FailedCases.txt", glue = {"stepDefinitions","hooks"},
plugin = {"pretty","html:target/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RerunFailedTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
