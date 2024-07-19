package pages;

import com.github.javafaker.Faker;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static utilities.WaitUtils.waitFor;

public class AddDeanPage {
    Faker faker = new Faker();
    // Constructor to initialize the WebDriver
    public AddDeanPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // CSS locators
    private By loginLink = By.cssSelector("a[href='/login']");
    private By menuButton = By.cssSelector("button[class='fw-semibold text-white bg-primary navbar-toggler collapsed']");
    private By deanManagementButton = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > a:nth-child(2)");
    private By usernameBox = By.cssSelector("#username");
    private By passwordBox = By.cssSelector("#password");
    private By loginButton = By.cssSelector("button[class='fw-semibold btn btn-primary']");
    private By name = By.cssSelector("#name");
    private By surname = By.cssSelector("#surname");
    private By birthPlace = By.cssSelector("#birthPlace");
    private By genderFemale = By.cssSelector("input[value='FEMALE']");
    private By genderMale = By.cssSelector("input[value='MALE']");
    private By birthDay = By.cssSelector("#birthDay");
    private By phoneNumber = By.cssSelector("#phoneNumber");
    private By ssn = By.cssSelector("#ssn");
    private By deanSubmit = By.cssSelector(".btn-primary");
    private By deanSavedPopUp = By.xpath("//*[.='Dean Saved']");


    public void enterUsername(String username) {
        Driver.getDriver().findElement(this.usernameBox).sendKeys(username);
    }

    public void enterDeanPassword(String password) {
        Driver.getDriver().findElement(passwordBox).sendKeys(password);
    }

    public void clickOnLoginButton() {
        Driver.getDriver().findElement(loginButton).click();
    }

    public void clickOnMenu() {
        Driver.getDriver().findElement(menuButton).click();
    }

    public void clickOnDeanManagement() {
        Driver.getDriver().findElement(deanManagementButton).click();
    }

    public void enterDeanName(String name) {
        Driver.getDriver().findElement(this.name).sendKeys(name);
    }

    public void enterDeanSurName(String surname) {
        Driver.getDriver().findElement(this.surname).sendKeys(surname);
    }

    public void enterBirthPlace(String birthplace) {
        Driver.getDriver().findElement(birthPlace).sendKeys(birthplace);
    }

    public void enterDeanGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            Driver.getDriver().findElement(genderFemale).click();
        } else {
            Driver.getDriver().findElement(genderMale).click();
        }
    }

    public void enterBirthDay(String birthday) {
        Driver.getDriver().findElement(birthDay).sendKeys(birthday);
    }

    public void enterPhone(String phone) {
        Driver.getDriver().findElement(phoneNumber).sendKeys(phone);
    }

    public void enterSSN(String ssn) {
        Driver.getDriver().findElement(this.ssn).sendKeys(ssn);
    }





    public void clickOnDeanSubmit() {
        Driver.getDriver().findElement(deanSubmit).click();
    }

    public void verifyDeanRegistration() {
        WebElement popUp = Driver.getDriver().findElement(deanSavedPopUp);
        assertTrue(popUp.isDisplayed());
    }
    public void verifyDeanRegistration(String message) {
        WebElement popUp = Driver.getDriver().findElement(deanSavedPopUp);
        assertTrue(popUp.isDisplayed());
        assertTrue(popUp.getText().equals(message));
    }


//    REUSABLE METHOD FOR ADD DEAN PAGE
//DEAN MANAGEMENT SAYFASINA GIDER
    public void navigateToDeanManagement(){
        waitFor(1);
//        menuye tikla
        clickOnMenu();
        waitFor(1);
//        dean managementa tikla
        clickOnDeanManagement();
        waitFor(1);
    }

    public void enterDeanInfo(
            String name,
            String surname,
            String birth_place,
            String gender,
            String date_of_birth,
            String phone,
            String ssn,
            String username,
            String password
    ){

//        DEAN BILGILERINI GIRER
        waitFor(1);
//        tum alanlari gir
        enterDeanName(name);
        waitFor(1);
        enterDeanSurName(surname);
        waitFor(1);
        enterBirthPlace(birth_place);
        waitFor(1);
        enterDeanGender(gender);
        waitFor(1);
        enterBirthDay(date_of_birth);
        waitFor(1);

//        phone, ssn, username degerlerini dinamik yapalim
//        839-683-7310
        String ilk3= String.valueOf(faker.number().numberBetween(100,1000));
        String ikinci3=String.valueOf(faker.number().numberBetween(100,1000));
        String son4=String.valueOf(faker.number().numberBetween(1000,10000));
//        enterPhone(ilk3+"-"+ikinci3+"-"+son4);
        enterPhone(phone);
        waitFor(1);
//        enterSSN(faker.idNumber().ssnValid());
        enterSSN(ssn);
        waitFor(1);
//        enterUsername(faker.name().username()+String.valueOf(faker.number().numberBetween(1,10)));
        enterUsername(username);
        waitFor(1);
        enterDeanPassword(password);
        waitFor(1);
        clickOnDeanSubmit();
        waitFor(1);
    }


}

