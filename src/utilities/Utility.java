package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        //Find login link and click on login button
        driver.findElement(by).click();
    }

    //This method will enter data into field
    public void sendTextToElement(By by, String text) {
        //Find element and enter data into element
        driver.findElement(by).sendKeys(text);
    }

    //Find the element and get the text from element
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //************Alert Methods******************************************//
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert();
    }

    public void dismissAlert() {
        driver.switchTo().alert();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //**********************************Select Class Method ***************************//


    //This method will select option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //create object for select class
        select.selectByVisibleText(text); //select by visible text
    }

    //This method will select the option by value

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //create object for select class
        select.selectByValue(text);
    }

    // This method will select the option by index


    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //create object for select class
        select.selectByIndex(index);
    }


    //*********************************Window Handle*******************//

    //******************************Action class **********************//

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        actions.moveToElement(text1).build().perform();
    }
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        actions.moveToElement(text1).click().build().perform();
    }
}


