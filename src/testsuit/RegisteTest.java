package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisteTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Verify the text ‘Signing up is easy!’
        String expectedMessage = "Signing up is easy!";
        //Varify actual and expected
        Assert.assertEquals(expectedMessage,getTextFormElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")));
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Enter First name
        sendTextToElement(By.id("customer.firstName"), "Abcd");
        // Enter Last name
        sendTextToElement(By.id("customer.lastName"), "Tanna");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), "10,Downing Street");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "City of Westminster");
        //Enter State
        sendTextToElement(By.id("customer.address.state"), "Colloquially");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "SW1A 2AA");
        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "0208897543");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"), "123456");
        //Enter Username
        sendTextToElement(By.id("customer.username"), "Abcd");
        // Enter Password
        sendTextToElement(By.id("customer.password"), "xyz123456");
        //Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "xyz123456");
        // Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        String actualMessage = actualTextMessageElement.getText();
        //Varify actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();


    }
}
