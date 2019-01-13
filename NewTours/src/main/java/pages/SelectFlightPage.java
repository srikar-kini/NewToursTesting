/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends AbstractPage {
    @FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
    private WebElement selectFightsImage;

    @FindBy(xpath = "//input[@name='reserveFlights']")
    private WebElement continueButton;

    public void selectFlightAndContinue(){
        Assert.assertTrue("Failure. Select Flights page is not displayed",selectFightsImage.isDisplayed());
        continueButton.click();
    }
}
