/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package cucumberSerenity;

import net.thucydides.core.annotations.Step;
import pages.*;

// Serenity step definition file
public class BookingsSerenityStepDef extends AbstractPage {
    private LandingPage landingPage= createPage(LandingPage.class);
    private FlightFinderPage flightFinderPage= createPage(FlightFinderPage.class);
    private SelectFlightPage selectFlightPage= createPage(SelectFlightPage.class);
    private BookAFlightPage bookAFlightPage = createPage(BookAFlightPage.class);
    private FlightConfirmationPage flightConfirmationPage= createPage(FlightConfirmationPage.class);

    // constructor to initialize Page objects.
   /* public BookingsSerenityStepDef() {
        landingPage = createPage(LandingPage.class);
        flightFinderPage = createPage(FlightFinderPage.class);
        selectFlightPage = createPage(SelectFlightPage.class);
        bookAFlightPage = createPage(BookAFlightPage.class);
        flightConfirmationPage = createPage(FlightConfirmationPage.class);
    }
*/
    // Base step for set up and launching browser
    @Step
    public void launchBrowserAndNavigateToTestURL(){
        landingPage.launchBrowserAndNavigateToTestURL();
        _log_("the browser is successfully launched.");
    }

    @Step
    public void enterUnregisteredUserDetails(){
        landingPage = createPage(LandingPage.class);
        landingPage.enterUnregisteredUserDetails();
    }

    @Step
    public void clickOnSignOnButton(){
        landingPage.clickOnSignOnButton();
    }

    @Step
    public void userUnableToLoginToBookingApplication(){
        landingPage.userUnableToLoginToBookingApplication();
        _log_("view the following screenshot: "+getLatestScreenshotName());
    }

    @Step
    public void enterRegisteredUserDetails(String username, String password){
        landingPage.enterRegisteredUserDetails(username,password);
    }

    @Step
    public void isFlightFinderPageDisplayed(){
        flightFinderPage.isFlightFinderPageDisplayed();
    }

    @Step
    public void selectSameOriginAndDestinationLocations(){
        flightFinderPage.selectSameDepartingAndArrivingPortForSameDay();
    }

    @Step
    public void bookingCannotProceedWithErrorsOnPage(){
        flightFinderPage.bookingCannotProceedWithErrorsOnPage();
        _log_("view the following screenshot: "+getLatestScreenshotName());
    }

    @Step
    public void enterOriginLocationBookingDetails(String departingPort, String onMonth, String onDay){
        flightFinderPage.enterOriginLocationBookingDetails(departingPort,onMonth,onDay);
    }

    @Step
    public void enterArrivingLocationBookingDetails(String arrivingPort, String arrivingMonth, String arrivingDay,
                                                    String airlineChoice){
        flightFinderPage.enterArrivingLocationBookingDetails(arrivingPort, arrivingMonth, arrivingDay, airlineChoice);
        selectFlightPage.selectFlightAndContinue();
    }

    @Step
    public void userProceedsWithBooking(){
        bookAFlightPage.enterCustomerDetailsAndMakePurchase();
        flightConfirmationPage.verifyFlightConfirmationAndLogOutOfTheApplication();
        _log_("The user has successfully made Flight bookings.");
        _log_("view the following screenshot: "+getLatestScreenshotName());
    }

    @Step
    public void _log_(String msg){
        System.out.println(msg);
    }
}
