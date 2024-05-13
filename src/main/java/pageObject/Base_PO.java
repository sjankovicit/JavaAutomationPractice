package pageObject;

import driver.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Global_Vars;


public class Base_PO {
    //Getting DriverFactory - Web driver for defining the browser
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    Actions actions = new Actions(getDriver());

    //Going to specific URL
    public void navigateTo_URL(String url){
        try{
            getDriver().get(url);
        }catch(Exception ex){
            System.out.println("EXCEPTION MESSAGE: " + ex.getMessage());
        }
    }

    //Wait for specific URL to load
    public void waitFor_URL(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void textToBePresentInElement(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    //Wait for By locator and send keys
//    public void sendKeys(By by, String textToType){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
//    }

    //Wait for WebElement locator and send keys
    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void sendKeysAndEnter(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType, Keys.ENTER);
    }

    //Wait for By locator and click
//    public void waitForWebElementAndClick(By by){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//    }

    //Wait for WebElement locator and click
    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitExplicitlyThenClick(int durationInMilliseconds, WebElement element){
        try{
            explicitWait(durationInMilliseconds);
        }catch(Exception e){
            System.out.println("Waiting explicitly for some element: " + e);
        }
        element.click();
    }

    //Wait for By locator
//    public void waitFor(By by){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//    }

    //Wait for WebElement locator
    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWait(int timeMilliseconds){
        try
        {
            Thread.sleep(timeMilliseconds);
        }
        catch(InterruptedException e)
        {
            System.out.println("ENTERED CATCH");
        }
    }

    public void moveMouseTo(WebElement element, int x, int y){
        actions.moveToElement(element, x, y).perform();
    }

    public void printLine(String text){
        System.out.println(text);
    }
}
