package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

   @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid username
        sendTextToElement(By.name("username"), "Abcd");
        //Enter valid password
        sendTextToElement(By.name("password"), "xyz123456");
        //Click on ‘LOGIN’ button
       clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualTextMessageElement.getText();

        //Varify actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage (){
        //Enter invalid username
        sendTextToElement(By.name("username"), "sgfagfr");
        //Enter valid password
        sendTextToElement(By.name("password"), "gfd124545");
        //Click on Login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //Verify the error message ‘The username and password could not be verified.’
        String expectedMessage = "Error!";
        //Varify actual and expected
        Assert.assertEquals(expectedMessage, getTextFormElement(By.xpath("//h1[text() = 'Error!']")));
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        sendTextToElement(By.name("username"), "Abcd");
        //Enter valid password
        sendTextToElement(By.name("password"), "xyz123456");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

        //Verify the text ‘Customer Login’
        String expectedMessage = "Customer Login";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualTextMessageElement.getText();

        //Varify actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);


    }
    @After
    public void testDown(){
        closeBrowser();
    }


}
