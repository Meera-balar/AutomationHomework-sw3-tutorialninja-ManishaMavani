package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover to desktop tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Desktops']"));
        //1.2 Click on Show All Desktops link
        clickOnElement(By.xpath("//a[text()='Show All Desktops']"));
        //1.3 Select option product sorted by name Z -A
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 This is from requirement
        String expectedText = "Name (Z - A)";
        //Actual select option text
        String actualText = getTextFromElement(By.xpath("//select[@id='input-sort']/option[3]"));
        //Validate actual and expected
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Mouse hover to desktop tab and click on it
        mouseHoverToElementAndClick(By.xpath("//a[text()='Desktops']"));
        //2.2 Click on Show all desktops link
        clickOnElement(By.xpath("//a[text()='Show All Desktops']"));
        //2.3 Select option product sorted by name A -Z
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //2.4 Select the Product
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[3]/div[1]"));
        //2.5 This is from requirement
        String expectedMessage = "HP LP3065";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='HP LP3065']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
        //********************************************Select Delivery Date*******************************//
        //2.6 This is required date
        String year = "2022";
        String month = "November";
        String date = "30";
        // opens the date picker
        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]/i[1]"));
        //loop for calender
        while (true) {
            //month year text get from calendar (November 2022)
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']//table//th[@class='picker-switch']")).getText();
            //month year split with space
            String[] arr = monthYear.split(" ");
            // index for month
            String mon = arr[0];
            //index for year
            String yer = arr[1];
            //This condition check when expected month and year get then loop break
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
                //else next button will click
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker']/div[1]//table//th[normalize-space()='›']"));
            }
        }
        //select Date
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//table//td"));
        //for loop will find actual date
        for (WebElement dt : allDates) {
            //if condition will check for date once match it will break
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
        //First remove default 1 quantity added to filed
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        //2.7 Enter quantity 1
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        //2.8 Click on add to cart button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 This is from requirement
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!" + "\n×";
        //Actual message
        String actualMessage1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //validate actual and expected
        Assert.assertEquals(expectedMessage1, actualMessage1);
        Thread.sleep(1000);
        //2.10 Click on shopping cart link
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        //2.11 This is from requirement
        String expectedMessage2 = "Shopping Cart  (1.00kg)";
        //Actual message
        String actualMessage2 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]//h1[starts-with(text(),'Shopping Cart')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage2, actualMessage2);
        //2.12 This is from requirement
        String expectedMessage3 = "HP LP3065";
        //Actual message
        String actualMessage3 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage3, actualMessage3);
        //2.13 This is from requirement
        String expectedMessage4 = "Delivery Date: 2022-11-30";
        //Actual message
        String actualMessage4 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage4, actualMessage4);
        //2.14 This is from requirement
        String expectedMessage5 = "Product 21";
        //Actual message
        String actualMessage5 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage5, actualMessage5);
        //2.15 This is from requirement
        String expectedMessage6 = "$122.00";
        //Actual message
        String actualMessage6 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage6, actualMessage6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}