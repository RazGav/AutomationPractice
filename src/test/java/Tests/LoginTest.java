package Tests;

import Base.ShareData;
import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends ShareData {

    public ElementMethods elementMethods;

    @Test
    public void testAutomat(){

        elementMethods = new ElementMethods(driver);

        //Identificam elementul "Sign in"
        WebElement signInElement = driver.findElement(By.id("btn1"));
        //Facem un click
        //signInElement.click();
        elementMethods.clickElement(signInElement);

        //Identificare element dupa "locators": id, class, name, link, css, xpath

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "ceai@vrea.sascrie";
        elementMethods.fillElement(emailElement, emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordValue = "salabalamala";
        elementMethods.fillElement(passwordElement, passwordValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        elementMethods.clickElement(enterElement);

        WebElement eroareElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        elementMethods.validateElementMessage(eroareElement, expectedError);

    }
}
