package Pages;

import Help.AlertMethods;
import Help.ElementMethods;
import Help.FrameMethods;
import Help.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;
    public AlertMethods alertMethods;
    public WindowMethods windowMethods;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        windowMethods = new WindowMethods(driver);
        frameMethods = new FrameMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
