package mainScript;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/features/input.feature"
		,glue= {"stepDef"}
		,dryRun = false)


public class ScriptRunner {

}
