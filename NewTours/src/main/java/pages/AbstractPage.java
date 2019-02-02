/*
#### Author: Srikar Kini
#### NewTours Test Project
#### Date created: 12/01/2019
 */

package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// Parent class for specific UI pages.
public abstract class AbstractPage {

    protected static final Logger log = LoggerFactory.getLogger(AbstractPage.class);
    protected static WebDriver driver;
    protected static Path path = Paths.get("");
    protected static String test_url,browser;
    protected SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy");
    protected SimpleDateFormat time = new SimpleDateFormat("_HHmmss");
    protected static String screenshotName="";

    // read values from Properties files
    protected String getValueFromPropertiesFile(String filename, String propertyValue){
        Properties prop = new Properties();
        InputStream input = null;
        String value="";
        try{
            input = new FileInputStream(path.toAbsolutePath().toString()+filename);
            prop.load(input);
            value=prop.getProperty(propertyValue);
        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    return value;
    }

    protected void readEnvironmentDetails(){
        test_url=getValueFromPropertiesFile("/properties/EnvDetails.properties","test.url");
        browser=getValueFromPropertiesFile("/properties/EnvDetails.properties","browser");
    }

    // instantiate browser by choice.
    protected void setDriver(String browser){
        switch(browser.toUpperCase()){
            case "CHROME":{
                System.setProperty("webdriver.chrome.driver",path.toAbsolutePath().toString()+"/drivers/chrome/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case "FIREFOX":{
                System.setProperty("webdriver.gecko.driver",path.toAbsolutePath().toString()+"/drivers/firefox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            case "INTERNET EXPLORER":{
                // TODO ** assign IE properties.
            }
            default:{
                System.setProperty("webdriver.chrome.driver",path.toAbsolutePath().toString()+"/drivers/chrome/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Driver object is set.");
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void closeBrowser(){
        getDriver().close();
        log.info("Browser is closed.");
    }

    protected void quitBrowser(){
        if(getDriver()!=null){
            getDriver().quit();
            log.info("Driver object is released.");
        }
    }

    protected String takeScreenshotAndReturnName(String screenName){
        screenshotName="/src/test/resources/files/screenshots/"+screenName+
                date.format(new Date()) + time.format(new Date())+".png";
        String filename = path.toAbsolutePath().toString()+screenshotName;
        try {
            FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotName;
    }

    protected String getLatestScreenshotName(){
        return screenshotName;
    }

    // Create page factory objects.
    public <T extends AbstractPage> T createPage(Class<T> pageClass) {
        return PageFactory.initElements(getDriver(), pageClass);
    }
}
