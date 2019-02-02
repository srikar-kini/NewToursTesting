/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package cucumberSerenity;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.AbstractPage;

// Cucumber step definition file
public class BookingsCucumberStepDef extends AbstractPage {

    @Before("@initial")
    public void setUp(){
        readEnvironmentDetails();
        setDriver(browser);
    }
    @After("@last")
    public void tearDown(){
        quitBrowser();
    }
    @Steps
    BookingsSerenityStepDef bookingsSerenityStepDef;

    @Given("^I am a web user who navigates to the NewTours website$")
    public void iAmAWebUserWhoNavigatesToTheNewToursWebsite() throws Throwable {
        bookingsSerenityStepDef.launchBrowserAndNavigateToTestURL();
    }


    @When("^I provide an unregistered user details$")
    public void iProvideAnUnregisteredUserDetails() throws Throwable {
        bookingsSerenityStepDef.enterUnregisteredUserDetails();
    }

    @And("^I click on the sign-in button$")
    public void iClickOnTheSignInButton() throws Throwable {
        bookingsSerenityStepDef.clickOnSignOnButton();
    }

    @Then("^I shouldn't be allowed to login and the booking page should not be displayed$")
    public void iShouldnTBeAllowedToLoginAndTheBookingPageShouldNotBeDisplayed() throws Throwable {
        bookingsSerenityStepDef.userUnableToLoginToBookingApplication();
    }

    @When("^I provide valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iProvideValidUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        bookingsSerenityStepDef.enterRegisteredUserDetails(username, password);

    }

    @Then("^the user successfully logs in and is able to see the bookings page$")
    public void theUserSuccessfullyLogsInAndIsAbleToSeeTheBookingsPage() throws Throwable {
        bookingsSerenityStepDef.isFlightFinderPageDisplayed();

    }

    @And("^when the user chooses the same location for origin and destination$")
    public void whenTheUserChoosesTheSameLocationForOriginAndDestination() throws Throwable {
        bookingsSerenityStepDef.selectSameOriginAndDestinationLocations();
    }

    @Then("^the web application doesn't let the user to proceed with booking$")
    public void theWebApplicationDoesnTLetTheUserToProceedWithBooking() throws Throwable {
        bookingsSerenityStepDef.bookingCannotProceedWithErrorsOnPage();
    }

    @And("^provides \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
    public void provides(String departingPort, String onMonth, String onDay) throws Throwable {
        bookingsSerenityStepDef.enterOriginLocationBookingDetails(departingPort, onMonth, onDay);
    }

    @And("^provides \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
    public void provides(String arrivingPort, String fromMonth, String fromDay, String airlineChoice) throws Throwable {
        bookingsSerenityStepDef.enterArrivingLocationBookingDetails(arrivingPort, fromMonth, fromDay, airlineChoice);
    }

    @Then("^the user is able to successfully make the booking$")
    public void theUserIsAbleToSuccessfullyMakeTheBooking() throws Throwable {
        bookingsSerenityStepDef.userProceedsWithBooking();
    }
}
