package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Switch')]")
    private WebElement switchToelement;
    @FindBy(xpath = "//a[contains(text(),'Frames')]")
    private WebElement frameElement;
    @FindBy(xpath = "//a[contains(text(),'Alert')]")
    private WebElement alertElement;
    @FindBy(xpath = "//a[contains(text(),'Windows')]")
    private WebElement windowsElement;
    @FindBy(css = "input[placeholder=\"First Name\"]")
    private WebElement firstNameElement;
    @FindBy(css = "input[placeholder=\"Last Name\"]")
    private WebElement lastNameElement;
    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement adressElement;
    @FindBy(css = "input[ng-model=\"EmailAdress\"]")
    private WebElement emailElement;
    @FindBy(css = "input[type=\"tel\"]")
    private WebElement phoneElement;
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> radiobuttonGenderElement;
    @FindBy(id = "checkbox1")
    private WebElement checkboxCricketElement;
    @FindBy(css = "checkbox2")
    private WebElement checkboxMoviesElement;
    @FindBy(css = "checkbox3")
    private WebElement checkboxHockeyElement;
    @FindBy(css = "Skills")
    private WebElement skillsDropboxElement;
    @FindBy(id = "country")
    private WebElement selectCountryDropboxElement;
    @FindBy(id = "yearbox")
    private WebElement yearDropboxElement;
    @FindBy(id = "//select[@ng-model='monthbox']")
    private WebElement monthDropboxElement;
    @FindBy(id = "daybox")
    private WebElement dayDropboxElement;
    @FindBy(css = "firstpassword")
    private WebElement passwordElement;
    @FindBy(css = "secondpassword")
    private WebElement secondPasswordElement;
    @FindBy(css = "msdd")
    private WebElement fakeLanguageDropboxElement;
    @FindBy(id = "//li[@class='ng-scope']/a")
    private List<WebElement> languageElements;
    @FindBy(id = "imagesrc")
    private WebElement photoElement;
    @FindBy(id = "submitbtn")
    private WebElement submitButtonElement;


    public void goToFramePage() {
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(frameElement);
        String url = "http://demo.automationtesting.in/Frames.html";
        driver.navigate().to(url);
    }

    public void goToAlertPage() {
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(alertElement);
        String url = "http://demo.automationtesting.in/Alerts.html";
        driver.navigate().to(url);
    }

    public void goToWindowsPage() {
        elementMethods.hoverElement(switchToelement);
        elementMethods.clickElement(windowsElement);
        String url = "http://demo.automationtesting.in/Windows.html";
        driver.navigate().to(url);
    }

    public void validRegisterProcess(HashMap<String, String> values) {
        firstName(values.get("firstName"));
        lastName(values.get("lastName"));
        email(values.get("email"));
        adress(values.get("address"));
        phone(values.get("phone"));
        genderSelect(values.get("gender"));
        cricketHobby();
        moviesHobby();
        hockeyHobby();
        sendPicture(values.get("picture"));
        chooseLanguage(values.get("language"));
        countryDropbox(values.get("country"));
        yearDropbox(values.get("year"));
        monthDropbox(values.get("month"));
        dayDropbox(values.get("day"));
        password(values.get("password"));
        secondPassword(values.get("secondPassword"));
        submitButton();

    }

    public void firstName(String value) {
        elementMethods.fillElement(firstNameElement, value);
    }

    public void lastName(String value) {
        elementMethods.fillElement(lastNameElement, value);
    }

    public void adress(String value) {
        elementMethods.fillElement(adressElement, value);
    }

    public void email(String value) {
        elementMethods.fillElement(emailElement, value);
    }

    public void phone(String value) {
        elementMethods.fillElement(phoneElement, value);
    }

    public void genderSelect(String gender) {
        switch (gender) {
            case "Male":
                elementMethods.clickElement(radiobuttonGenderElement.get(0));
                break;
            case "Female":
                elementMethods.clickElement(radiobuttonGenderElement.get(1));
                break;
        }
    }

    public void cricketHobby() {
        elementMethods.clickElement(checkboxCricketElement);
    }

    public void moviesHobby() {
        elementMethods.clickElement(checkboxMoviesElement);
    }

    public void hockeyHobby() {
        elementMethods.clickElement(checkboxHockeyElement);
    }

    public void countryDropbox(String value){
        elementMethods.selectByTextElement(selectCountryDropboxElement, value);
    }

    public void yearDropbox(String value){
        elementMethods.selectByValueElement(yearDropboxElement, value);
    }

    public void monthDropbox(String value){
        elementMethods.selectByTextElement(monthDropboxElement, value);
    }

    public void dayDropbox(String value){
        elementMethods.selectByValueElement(dayDropboxElement, value);
    }

    public void password(String value) {
        elementMethods.fillElement(passwordElement, value);
    }

    public void secondPassword(String value) {
        elementMethods.fillElement(secondPasswordElement, value);
    }

    public void chooseLanguage(String language) {
        for (WebElement element : languageElements) {
            if (element.getText().equals(language)) {
                element.click();
                break;
            }
        }
    }


    public void sendPicture(String value){
        photoElement.sendKeys(value);

    }

    public void submitButton() {
        elementMethods.clickElement(submitButtonElement);
    }


}