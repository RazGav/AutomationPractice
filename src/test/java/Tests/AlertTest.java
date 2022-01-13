package Tests;

import Base.ShareData;
import Help.AlertMethods;
import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends ShareData {

    public ElementMethods elementMethods;
    public AlertMethods alertMethods;

    @Test
    public void testAutomat() {

        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //Validam pagina de "Register"
        elementMethods.validatePage("Register");

        //SwitchTo
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.switchElement(switchToElement);

        //Alerts
        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
        elementMethods.clickElement(alertsElement);
        //String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        //driver.navigate().refresh(); refresh

        List<WebElement> alertOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        alertOptions.get(0).click();
        //click the button element
        WebElement clickTheButtonElement = driver.findElement(By.cssSelector("#OKTab button"));
        elementMethods.clickElement(clickTheButtonElement);

        //inchide alerta
        alertMethods.acceptAlert();

        //alerta 2
        alertOptions.get(1).click();
        //click the button element
        WebElement clickTheButton2Element = driver.findElement(By.cssSelector("#CancelTab button"));
        elementMethods.clickElement(clickTheButton2Element);
        //inchide alerta cu cancel
        alertMethods.cancelAlert();

        //alerta 3
        alertOptions.get(2).click();
        //click the button element
        WebElement clickTheButton3Element = driver.findElement(By.cssSelector("#Textbox button"));
        elementMethods.clickElement(clickTheButton3Element);
        //inchide alerta cu cancel
        alertMethods.acceptFillAlert("alerta");

    }
}

//Cautare >text< cu xpath (text hardcodat) ex. //a[contains(text(),'Switch')]