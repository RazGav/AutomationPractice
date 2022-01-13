package Tests;

import Base.ShareData;
import Help.ElementMethods;
import Help.FrameMethods;
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
    public FrameMethods frameMethods;

    @Test
    public void testAutomat() {

        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        //Validam pagina de "Register"
        elementMethods.validatePage("Register");

        //SwitchTo
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.switchElement(switchToElement);

        WebElement alertsElement = driver.findElement(By.xpath("//a[contains(text(),'Frame')]"));
        elementMethods.clickElement(alertsElement);
        //String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //driver.navigate().refresh(); refresh

        List<WebElement> frameOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs '] li a"));
        frameOptions.get(0).click();
        //ne mutam pe un iframe
        frameMethods.switchFrameById("singleframe");
        WebElement singleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        singleInputElement.sendKeys("spatiu");
        frameMethods.switchFrameDefault();

        frameOptions.get(1).click();
        frameMethods.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        frameMethods.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        WebElement multipleInputElement = driver.findElement(By.xpath("//input[@type='text']"));
        multipleInputElement.sendKeys("multiple frames");

    }
}
