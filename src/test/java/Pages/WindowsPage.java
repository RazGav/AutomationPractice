package Pages;

import Help.ElementMethods;
import Help.FrameMethods;
import Help.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;
    public WindowMethods windowMethods;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul[class='nav nav-tabs nav-stacked'] li a")
    private List<WebElement> windowsOptions;
    @FindBy(css = "#Tabbed a button")
    private WebElement clickTheButtonElement;
    @FindBy(css = "#Seperate  button")
    private WebElement clickWindowElement;
    @FindBy(css = "#Multiple")
    private WebElement clickTabsElement;

    public void tabbedProcess() {
        windowsOptions.get(0).click();
        elementMethods.clickElement(clickTheButtonElement);
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);
    }

    public void separateProcess() {
        windowsOptions.get(1).click();
        elementMethods.clickElement(clickWindowElement);
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);
    }

    public void multipleProcesses() {
        windowsOptions.get(2).click();
        elementMethods.clickElement(clickTabsElement);
        windowMethods.switchToSpecificWindow(2);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);
    }
}
