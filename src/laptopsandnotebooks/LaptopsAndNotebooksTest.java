package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on laptop&Notebook tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //1.2 click on show all laptops &Notebooks link
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //1.3 Select Price(High>Low) option from drop down
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //1.4 This is from requirement
        String expectedMessage = "Price (High > Low)";
        //This is actual select options selected which will store in actualMessage
        String actualMessage = getTextFromElement(By.xpath("//select[@id='input-sort']/option[5]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        //2.1 Mouse hover on laptop&Notebook tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 Click on show all laptops &Notebooks link
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Price(High>Low) option from drop down
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //2.4Select product MacBook
        Thread.sleep(1000);
        clickOnElement(By.xpath("//img[@title='MacBook']"));
        //2.5 This is from requirement
        String expectedMessage = "MacBook";
        //Actual message is "MacBook"
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage,actualMessage);
        //2.6 Click on Add to cart
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 This is from requirement
        String expectedMessage1 = "Success: You have added MacBook to your shopping cart!" + "\n×";
        //Actual message
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage1,actualMessage1);
        //2.8 click on Shopping cart
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        //2.9 This is from requirement
        String expectedText = "Shopping Cart  (0.00kg)";
        //Actual message
        String actualText = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedText,actualText);
        //2.10 This is from requirement
        String expectedMessage2 = "MacBook";
        //Actual message
        String actualMessage2 = getTextFromElement(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage2,actualMessage2);
        //clear 1 quantity from textbox
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/input")).clear();
        //2.11 Change Quantity "2"
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/input"),"2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        //2.13 This is from requirement
        String expectedMessage3 = "Success: You have modified your shopping cart!" + "\n×";
        //Actual message
        String actualMessage3 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage3,actualMessage3);
        //2.14 This is from requirement
        String expectedMessage4 = "$1,204.00";
        //Actual message
        String actualMessage4 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage4,actualMessage4);
        //2.15 Click on checkout button
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 This is from requirement
        String expectedMessage5 = "Checkout";
        //Actual message
        String actualMessage5 = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage5,actualMessage5);
        //2.17 This is from requirement
        String expectedMessage6 = "New Customer";
         //Actual message
         String actualMessage6 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
         //Validate actual and expected are match
         Assert.assertEquals(expectedMessage6,actualMessage6);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on continue tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20******************************Fill All Mandatory Field***********************************************//
        //Enter Firstname
        sendTextToElement(By.id("input-payment-firstname"),"Manisha");
        //Enter Lastname
        sendTextToElement(By.id("input-payment-lastname"),"Mavani");
        //Enter E-mail
        sendTextToElement(By.id("input-payment-email"),"ManishaMavani@gmail.com");
        //Enter Telephone
        sendTextToElement(By.id("input-payment-telephone"),"076453687345");
        //Enter address
        sendTextToElement(By.id("input-payment-address-1"),"Yardley Road");
        //Enter city
        sendTextToElement(By.id("input-payment-city"),"Birmingham");
        //Enter Postcode
        sendTextToElement(By.id("input-payment-postcode"),"B20 2LR");
        //Select country
        selectByVisibleTextFromDropDown(By.id("input-payment-country"),"India");
        //Select state
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Gujarat");

        //2.21 Click on continue button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Please make sure On time delivery." + "\nThank You");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 This is from requirement
        String expectedMessage7 = "Warning: Payment method required!" + "\n×";
        //Actual message
        String actualMessage7 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage7,actualMessage7);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
