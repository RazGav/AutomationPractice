package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrameById(String value){
        driver.switchTo().frame(value);
    }

    public void switchFrameDefault(){
        driver.switchTo().defaultContent();
    }

    public void switchFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }

}
