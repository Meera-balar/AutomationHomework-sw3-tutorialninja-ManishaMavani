package myaccounts;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String option){
        //Lis of my account list
        List<WebElement> myAccountList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        try {
            //for loop for find right options
            for (WebElement options : myAccountList) {
                //if condtion will check passed parameter
                if (options.getText().equals(option) ) {
                   //click on passed parameter
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
       //1.2 Method call and pass the parameter
        selectMyAccountOptions("Register");
        //1.3 Verify the text "Register Account"
        String expectedMessage = "Register Account";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Method call and pass the parameter
        selectMyAccountOptions("Login");
        //2.3 Verify the text "Returning Customer"
        String expectedMessage = "Returning Customer";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        //Validate actual and expected are match
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Method call and pass the parameter
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"),"Meera");
        //3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"),"Balar");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"),"MeeraBalar@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"),"07658476758");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"),"Mani123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"),"Mani123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//div[@class='form-group']/div/label[1]/input[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        //Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedMessage1 = "Account Logout";
        //Actual Message
        String actualMessage1 = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Method call and pass the parameter
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"),"MeeraBalar@gmail.com");
        //4.5 Enter Password
        sendTextToElement(By.id("input-password"),"Mani123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String expectedMessage = "My Account";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h2[text()='My Account']"));
        //Validate actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String expectedMessage1 = "Account Logout";
        //Actual Message
        String actualMessage1 = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
