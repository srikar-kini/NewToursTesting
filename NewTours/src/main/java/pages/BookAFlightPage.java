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

public class BookAFlightPage extends AbstractPage {

    @FindBy(xpath = "//font[contains(text(),'Summary')]")
    private WebElement summaryDisplay;

    @FindBy(xpath = "//input[@name='passFirst0']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='passLast0']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='creditnumber']")
    private WebElement creditCardField;

    @FindBy(xpath = "//select[@name='creditCard']")
    private WebElement creditCardSelectBox;

    @FindBy(xpath = "//input[@name='buyFlights']")
    private WebElement securePurchaseButton;

    private String sampleFirstName="John", sampleLastName="Smith", ccNumber="1100220033004400", ccCard="MasterCard";


    public void enterCustomerDetailsAndMakePurchase(){
        Assert.assertTrue("Failure. Book A Flight page is not displayed.",summaryDisplay.isDisplayed());
        firstNameField.sendKeys(sampleFirstName);
        lastNameField.sendKeys(sampleLastName);
        Select ccSelectbox = new Select(creditCardSelectBox);
        ccSelectbox.selectByVisibleText(ccCard);
        creditCardField.sendKeys(ccNumber);
        securePurchaseButton.click();
    }
}
