package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest {

    public WebDriver driver;

    @Test
    public void testAutomat() {
        //Specificam unde se afla driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\Automation\\chromedriver.exe");
        //Deschidem un browser
        driver = new ChromeDriver();
        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");
        //Schimbar rezolutia in maximize
        driver.manage().window().maximize();

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //Validam pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);

        //SwitchTo
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        switchToElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).build().perform(); //merge si fara build

        //Alerts
        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
        alertsElement.click();
        //String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        //driver.navigate().refresh(); refresh

        List<WebElement> alertOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        alertOptions.get(0).click();
        //click the button element
        WebElement clickTheButtonElement = driver.findElement(By.cssSelector("#OKTab button"));
        clickTheButtonElement.click();

        //inchide alerta
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        //alerta 2
        alertOptions.get(1).click();
        //click the button element
        WebElement clickTheButton2Element = driver.findElement(By.cssSelector("#CancelTab button"));
        clickTheButton2Element.click();
        //inchide alerta cu cancel
        Alert alertOkCancel = driver.switchTo().alert();
        alertOkCancel.dismiss();

        //alerta 3
        alertOptions.get(2).click();
        //click the button element
        WebElement clickTheButton3Element = driver.findElement(By.cssSelector("#Textbox button"));
        clickTheButton3Element.click();
        //inchide alerta cu cancel
        Alert alertText = driver.switchTo().alert();
        alertText.sendKeys("scris");
        alertText.accept();

    }
}

//Cautare >text< cu xpath (text hardcodat) ex. //a[contains(text(),'Switch')]