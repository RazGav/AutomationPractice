package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    //WebDriver = variabila care ne ajuta sa interactionam cu site-ul si elementele de pe site

    public WebDriver driver;

    @Test
    public void testAutomat(){
        //Specificam unde se afla driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\Automation\\chromedriver.exe");
        //Deschidem un browser
        driver = new ChromeDriver();
        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");
        //Schimbar rezolutia in maximize
        driver.manage().window().maximize();

        //Identificam elementul "Sign in"
        WebElement signInElement = driver.findElement(By.id("btn1"));
        //Facem un click
        signInElement.click();

        //Identificare element dupa "locators": id, class, name, link, css, xpath

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "ceai@vrea.sascrie";
        emailElement.sendKeys(emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordValue = "salabalamala";
        passwordElement.sendKeys(passwordValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement eroareElement = driver.findElement(By.id("errormsg"));
        String expectedError = "Invalid User Name or PassWord";
        String actualError = eroareElement.getText();
        Assert.assertEquals("Mesajul de pe pagina nu este corect!", expectedError, actualError);





    }
}
