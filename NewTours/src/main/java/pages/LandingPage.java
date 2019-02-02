/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class LandingPage extends AbstractPage {

    @FindBy(xpath="//input[@name='userName']")
    private WebElement userNameText;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordText;

    @FindBy(xpath="//input[@value='Login']")
    private WebElement signInButton;

    @FindBy(xpath="//img[@src='/images/masts/mast_signon.gif']")
    private WebElement signOnImageBanner;


    public void launchBrowserAndNavigateToTestURL(){
        getDriver().get(test_url);
    }

    public void enterUnregisteredUserDetails(){
        String unregisteredUsername = "UnR3G1ST3R_"+get5DigitsRandomNumber();
        String unKnownPassword = "PA2270RD_"+get5DigitsRandomNumber();
        userNameText.sendKeys(unregisteredUsername);
        passwordText.sendKeys(unKnownPassword);
    }

    public int get5DigitsRandomNumber(){
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public void clickOnSignOnButton(){
        signInButton.click();
    }

    public void userUnableToLoginToBookingApplication(){
        Assert.assertTrue("Failure, Unregistered user is able to login.",signOnImageBanner.isDisplayed());
        takeScreenshotAndReturnName("User not logged in_");
    }

    public void enterRegisteredUserDetails(String username, String password){
        userNameText.sendKeys(username);
        passwordText.sendKeys(password);
        signInButton.click();
    }





}
