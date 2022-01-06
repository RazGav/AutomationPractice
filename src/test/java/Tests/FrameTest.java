package Tests;

import Base.ShareData;
import Help.ElementMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameTest extends ShareData {


    public ElementMethods elementMethods;

    @Test
    public void testAutomat() {

        elementMethods = new ElementMethods(driver);

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //Validam pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);

        //SwitchTo
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        switchToElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).build().perform(); //merge si fara build

        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Frame')]"));
        alertsElement.click();
        //String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //driver.navigate().refresh(); refresh

        List<WebElement> frameOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs '] li a"));
        frameOptions.get(0).click();
        //ne mutam pe un iframe
        driver.switchTo().frame("singleframe");
        WebElement singleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        singleInputElement.sendKeys("spatiu");
        driver.switchTo().defaultContent();

        frameOptions.get(1).click();
        driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        WebElement multipleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        multipleInputElement.sendKeys("multiple frames");

    }
}
