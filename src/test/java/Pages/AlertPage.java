package Pages;

import Help.AlertMethods;
import Help.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;



    public AlertPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul[class='nav nav-tabs nav-stacked'] li a")
    private List<WebElement> alertOptions;

    @FindBy(css = "#OKTab button")
    private WebElement clickOkButton;

    @FindBy(css = "#CancelTab button")
    private WebElement okCancelButton;

    @FindBy(css = "#Textbox button")
    private WebElement textBoxButton;


    public void alertOkProcess(){
        alertOptions.get(0).click();
        elementMethods.clickElement(clickOkButton);
        alertMethods.acceptAlert();
    }

    public void alertOkCancelProcess(){
        alertOptions.get(1).click();
        elementMethods.clickElement(okCancelButton);
        alertMethods.cancelAlert();
    }

    public void alertTextBoxProcess(String valoare){
        alertOptions.get(2).click();
        elementMethods.clickElement(textBoxButton);
        alertMethods.acceptFillAlert(valoare);
    }
}
