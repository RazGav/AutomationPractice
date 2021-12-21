package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest {

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

        //Identificam elementul Spatiul pentru Nume
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder=\"First Name\"]"));
        String firstName = "Ala";
        firstNameElement.sendKeys(firstName);

        //Identificam elementul Spatiul pentru Prenume
        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder=\"Last Name\"]"));
        String lastName = "Bala";
        lastNameElement.sendKeys(lastName);

        //Identificam elementul radiobutton Female
        WebElement radiobuttonFemaleElement = driver.findElement(By.cssSelector("input[value=\"FeMale\"]"));
        radiobuttonFemaleElement.click();

        //Identificam "Cricket" element
        WebElement checkboxCricket = driver.findElement(By.id("checkbox1"));
        checkboxCricket.click();

        //Identificam Skills dropbox element
        WebElement skillsDropboxElement = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(skillsDropboxElement);
        skillsSelect.selectByVisibleText("Android");

        //Identificam Year dropbox element
        WebElement yearDropboxElement = driver.findElement(By.id("yearbox"));
        Select yearSelect = new Select(yearDropboxElement);
        yearSelect.selectByValue("1998");

        //Identificam fake dropbox Language element
        WebElement fakeLanguageDropboxElement = driver.findElement(By.id("msdd"));
        fakeLanguageDropboxElement.click();

        List<WebElement> languageElements = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
        for(int i = 0; i< languageElements.size(); i++){
            if(languageElements.get(i).getText().equals("Bulgarian")){
                languageElements.get(i).click();
            }
        }

        WebElement imageElement = driver.findElement(By.id("imagetrgt"));
        imageElement.click();

        WebElement adressElement = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String adresa = "Str. Ajun, nr. 1, bloc D12, Ap.24";
        adressElement.sendKeys(adresa);

        //Identificam Year dropbox element
        WebElement passwordElement = driver.findElement(By.id("firstpassword"));
        String password = "Parola1";
        passwordElement.sendKeys(password);


        // "// = de unde incepi, [@ = dupa ce cauti], / = intri mai adanca in lista cautata pt xpath
        // ex. //textarea[@ng-model='Adress']




    }

}
