/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Main runner class for the NewTours test.



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/NewToursTesting.feature"},
        glue = {"cucumberSerenity"})
public class RunNewToursTest {
        public void runNewToursTests(){}
}
