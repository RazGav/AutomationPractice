package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {

    public WebDriver driver;

    @Test
    public void testAutomat() {
        //Specificam unde se afla driverul pentru browser
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\Automation\\chromedriver.exe");
        //Deschidem un browser
        driver = new ChromeDriver();
        //Introducem o adresa
        driver.get("http://demo.automationtesting.in/Index.html");
        //Schimbar rezolutia in maximize
        driver.manage().window().maximize();

        //Identificam "Skip sign in" element
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        //Validam pagina de "Register"
        String actualRegister = driver.getTitle();
        Assert.assertEquals("Register", actualRegister);

        //SwitchTo
        WebElement switchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        switchToElement.click();
        Actions action = new Actions(driver);
        action.moveToElement(switchToElement).build().perform(); //merge si fara build

        //Windows
        WebElement windowsElement = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        windowsElement.click();
        //String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");
        //driver.navigate().refresh(); refresh

        List<WebElement> windowsOptions = driver.findElements(By.cssSelector("ul[class='nav nav-tabs nav-stacked'] li a"));
        windowsOptions.get(0).click();
        //click the button element
        WebElement clickTheButtonElement = driver.findElement(By.cssSelector("#Tabbed a button"));
        clickTheButtonElement.click();

        System.out.println("titlul paginii" + driver.getTitle());

        //salvam taburile intr-o lista
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //new separate windows
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close(); //inchide tabul activ

        //se intoarce pe primul tab
        driver.switchTo().window(tabs.get(0));

        windowsOptions.get(1).click();
        //click the button element
        WebElement clickWindow = driver.findElement(By.cssSelector("#Separate a button"));
        clickWindow.click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();

        driver.switchTo().window(tabs.get(0));

        windowsOptions.get(2).click();
        //click button
        WebElement clickTabsElement = driver.findElement(By.cssSelector("#Multiple"));
        clickTabsElement.click();
        List<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();
        driver.switchTo().window(multipleTabs.get(1));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();
        driver.switchTo().window(multipleTabs.get(0));
        System.out.println("titlul paginii" + driver.getTitle());
        driver.close();


        }
    }
