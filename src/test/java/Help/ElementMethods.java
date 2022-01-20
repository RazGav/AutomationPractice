package Help;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;

    }

    public void clickElement(WebElement element){
        waitElementVisible(element);
        element.click();
    }

    public void waitElementVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value){
        waitElementVisible(element);
        element.sendKeys(value);
    }

    public void validateElementMessage(WebElement element, String value){
        waitElementVisible(element);
        String actualError = element.getText();
        Assert.assertEquals("Mesajul de pe pagina nu este corect!", value, actualError);
    }

    public void selectByTextElement(WebElement element, String value){
        waitElementVisible(element);
        Select skillsSelect = new Select(element);
        skillsSelect.selectByVisibleText(value);
    }

    public void selectByValueElement(WebElement element, String value){
        waitElementVisible(element);
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(value);
    }


    public void validatePage(String value){
        String actualRegister = driver.getTitle();
        Assert.assertEquals(value, actualRegister);
    }

    public void hoverElement(WebElement element){
        waitElementVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

}
