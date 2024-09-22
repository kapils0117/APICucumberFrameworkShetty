package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/java/features",glue={"stepDefinitions"},tags= "@deletePlace")
@CucumberOptions(features="src/test/java/features",glue={"stepDefinitions"},tags= "@AddPlace")
//@CucumberOptions(features="src/test/java/features", plugin="json:target/jsonReports/cucumber-report.json",glue={"stepDefinitions"})
public class TestRunner {

}

//Suppose tomorrow we create more feature files and want to run any specific then give the complete path after slash , features="src/test/java/features/ feature file name
// Run project from cmd thru Maven
// Command 1 : cd project path(get from proj properties)
//open cmd = cd "proj path", for eg. cd C:\Users\KSHARM23\eclipse-workspace\APILatestFramework
//Command 2 :  mvn compile = it will not execute code just will compile code
//Command 3: mvn test = this command will execute the code
// While running from mvn cmd we need not set tag on eclipse to run any specific tag, we will set tag on cmd only 
//"@CucumberOptions(features="src/test/java/features",glue={"stepDefinitions"})"
// command 4 : mvn test @CucumberOptions="--tags @deletePlace"

//Command 4- for extent reporting give this " mvn verify"