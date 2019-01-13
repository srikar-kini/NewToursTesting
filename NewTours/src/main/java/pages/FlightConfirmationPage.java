/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightConfirmationPage extends AbstractPage {

    @FindBy(xpath = "//img[@src='/images/masts/mast_confirmation.gif']")
    private WebElement confirmationImage;

    @FindBy(xpath = "//img[@src='/images/forms/Logout.gif']")
    private WebElement logOutButton;

    public void verifyFlightConfirmationAndLogOutOfTheApplication(){
        Assert.assertTrue("Failure. Flight confirmation is not displayed.",confirmationImage.isDisplayed());
        takeScreenshotAndReturnName("Booking confirmation_");
        logOutButton.click();
    }
}
