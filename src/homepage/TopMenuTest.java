package homepage;

import javafx.scene.control.Tab;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

   //This method will check whatever parameter is passed it click on it
    public void selectMenu(String menu){
        if(menu.equalsIgnoreCase("Show All Desktops")){
            clickOnElement(By.xpath("//a[text()='Show All Desktops']"));
        } else if (menu.equalsIgnoreCase("Show All Laptops & Notebooks")) {
            clickOnElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
        } else if (menu.equalsIgnoreCase("Show All Components")) {
            clickOnElement(By.xpath("//a[text()='Show All Components']"));
        }else{
            System.out.println("Wrong menu selection");
        }

    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
       // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        String expectedMessage = "Desktops";
       //Actual text
        String actualMessage = getTextFromElement(By.xpath("//h2[text()='Desktops']"));
      //Validate actual and text
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
       //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedMessage = "Laptops & Notebooks";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h2[text()='Laptops & Notebooks']"));
        //Validate actual and message text
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
       // 3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");
        //3.3 Verify the text ‘Components’
        String expectedMessage = "Components";
        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h2[text()='Components']"));
        //Validate actual and message text
        Assert.assertEquals(expectedMessage,actualMessage);
    }




    @After
    public void tearDown(){
        closeBrowser();
    }
}
