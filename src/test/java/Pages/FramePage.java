package Pages;

import Help.ElementMethods;
import Help.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public FramePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul[class='nav nav-tabs '] li a")
    private List<WebElement> frameOptions;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputSingleElement;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputMultipleElement;


    public void dealSingleFrame(String value){
        frameOptions.get(0).click();
        //ne mutam pe un iframe
        frameMethods.switchFrameById("singleframe");
        inputSingleElement.sendKeys(value);
        frameMethods.switchFrameDefault();
    }

    public void dealMultipleFrame(String value){
        frameOptions.get(1).click();
        frameMethods.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        frameMethods.switchFrameByElement(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        inputMultipleElement.sendKeys(value);
    }
}