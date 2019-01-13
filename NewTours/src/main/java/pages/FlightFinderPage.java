/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends AbstractPage {

    @FindBy(xpath="//font[contains(text(),'Details')]")
    private WebElement flightDetailsImage;

    @FindBy(xpath="//select[@name='fromPort']")
    private WebElement departingFromSelectBox;

    @FindBy(xpath="//select[@name='toPort']")
    private WebElement arrivingInSelectBox;

    @FindBy(xpath="//select[@name='fromMonth']")
    private WebElement fromMonthDepartingSelectBox;

    @FindBy(xpath="//select[@name='fromDay']")
    private WebElement fromDayDepartingSelectBox;

    @FindBy(xpath="//select[@name='toMonth']")
    private WebElement toMonthArrivingSelectBox;

    @FindBy(xpath="//select[@name='toDay']")
    private WebElement toDayArrivingSelectBox;

    @FindBy(xpath ="//input[@name='findFlights']")
    private WebElement continueButton;

    @FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
    private WebElement selectFightsImage;

    @FindBy(xpath = "//select[@name='airline']")
    private WebElement airlineChoiceDropdown;

    private String departingPort="London", departingMonth="January", departingDay="12";
    private String arrivingPort="London", arrivingMonth="January", arrivingDay="12";

    public void isFlightFinderPageDisplayed(){
        Assert.assertTrue("Failure. Flight Finder page is not displayed.",flightDetailsImage.isDisplayed());
    }

    public void selectSameDepartingAndArrivingPortForSameDay(){
        Select s_departingPort = new Select(departingFromSelectBox);
        s_departingPort.selectByVisibleText(departingPort);
        Select s_departingMonth = new Select(fromMonthDepartingSelectBox);
        s_departingMonth.selectByVisibleText(departingMonth);
        Select s_departingDay = new Select(fromDayDepartingSelectBox);
        s_departingDay.selectByVisibleText(departingDay);
        Select s_arrivingPort = new Select(arrivingInSelectBox);
        s_arrivingPort.selectByVisibleText(arrivingPort);
        Select s_arrivingMonth = new Select(toMonthArrivingSelectBox);
        s_arrivingMonth.selectByVisibleText(arrivingMonth);
        Select s_arrivingDay = new Select(toDayArrivingSelectBox);
        s_arrivingDay.selectByVisibleText(arrivingDay);
        continueButton.click();
    }

    public void bookingCannotProceedWithErrorsOnPage(){
        try{
            Assert.assertFalse("Failure. Booking cannot proceed without correct dates and destinations.",selectFightsImage.isDisplayed());
        }catch(AssertionError ae){
            log.error("Assertion error found in Test. Possibly a defect.");
            takeScreenshotAndReturnName("No error found in application_");
            ae.printStackTrace();
            Assert.fail();
        }finally {
            closeBrowser();
        }
    }

    public void enterOriginLocationBookingDetails(String departingPort, String onMonth, String onDay){
        Select s_departingPort = new Select(departingFromSelectBox);
        s_departingPort.selectByVisibleText(departingPort);
        Select s_departingMonth = new Select(fromMonthDepartingSelectBox);
        s_departingMonth.selectByVisibleText(onMonth);
        Select s_departingDay = new Select(fromDayDepartingSelectBox);
        s_departingDay.selectByVisibleText(onDay);
    }

    public void enterArrivingLocationBookingDetails(String arrivingPort, String arrivingMonth, String arrivingDay,
                                                    String airlineChoice){
        Select s_arrivingPort = new Select(arrivingInSelectBox);
        s_arrivingPort.selectByVisibleText(arrivingPort);
        Select s_arrivingMonth = new Select(toMonthArrivingSelectBox);
        s_arrivingMonth.selectByVisibleText(arrivingMonth);
        Select s_arrivingDay = new Select(toDayArrivingSelectBox);
        s_arrivingDay.selectByVisibleText(arrivingDay);
        Select s_airlineChoice = new Select(airlineChoiceDropdown);
        s_airlineChoice.selectByVisibleText(airlineChoice);
        continueButton.click();
    }
}
