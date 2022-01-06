package Help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;

    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void validateElementMessage(WebElement element, String value){
        String actualError = element.getText();
        Assert.assertEquals("Mesajul de pe pagina nu este corect!", value, actualError);
    }

    public void selectByTextElement(WebElement element, String value){
        Select skillsSelect = new Select(element);
        skillsSelect.selectByVisibleText(value);
    }

    public void selectByValueElement(WebElement element, String value){
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(value);
    }

    public void switchElement(WebElement element){
        element.click();
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

}
