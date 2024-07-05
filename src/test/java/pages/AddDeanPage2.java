package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class AddDeanPage2 {

    public AddDeanPage2() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(css = "button[class='fw-semibold btn btn-primary']" )
    public WebElement loginButton;
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @FindBy(css = "button[class='fw-semibold text-white bg-primary navbar-toggler collapsed']")
    public WebElement menuButton;
    public void clickOnMenu() {
        menuButton.click();
    }


    @FindBy(css = "body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > a:nth-child(2)")
    public WebElement deanManagementButton;
    public void clickOnDeanManagement() {
        deanManagementButton.click();
    }

    @FindBy(css = "#username")
    public WebElement usernameBox;

    public void enterUsername(String username) {
        usernameBox.sendKeys(username);
    }
    @FindBy(css = "#name" )
    public WebElement name;
    public void enterDeanName(String name) {
        this.name.sendKeys(name);
    }

    @FindBy(css = "#surname" )
    public WebElement surname;
    public void enterDeanSurName(String surname) {
        this.surname.sendKeys(surname);
    }

    @FindBy(css = "#password" )
    public WebElement passwordBox;
    public void enterDeanPassword(String password) {
        passwordBox.sendKeys(password);
    }



    @FindBy(css = "#birthPlace" )
    public WebElement birthPlace;
    public void enterBirthPlace(String birthplace) {
        birthPlace.sendKeys(birthplace);
    }

    @FindBy(css = "input[value='FEMALE']" )
    public WebElement genderFemale;
    @FindBy(css = "input[value='MALE']" )
    public WebElement genderMale;
    public void enterDeanGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            genderFemale.click();
        } else {
            genderMale.click();
        }
    }

    @FindBy(css = "#birthDay" )
    public WebElement birthDay;
    public void enterBirthDay(String birthday) {
        birthDay.sendKeys(birthday);
    }

    @FindBy(css = "#phoneNumber" )
    public WebElement phoneNumber;
    public void enterPhone(String phone) {
        phoneNumber.sendKeys(phone);
    }

    @FindBy(css = "#ssn" )
    public WebElement ssn;
    public void enterSSN(String ssn) {
        this.ssn.sendKeys(ssn);
    }



    @FindBy(css = ".btn-primary" )
    public WebElement deanSubmit;
    public void clickOnDeanSubmit() {
        deanSubmit.click();
    }

    @FindBy(css = "//*[.='Dean Saved']" )
    public WebElement deanSavedPopUp;
    public void verifyDeanRegistration() {
        assertTrue(deanSavedPopUp.isDisplayed());
    }
    public void verifyDeanRegistration(String message) {
        assertTrue(deanSavedPopUp.isDisplayed());
        assertTrue(deanSavedPopUp.getText().equals(message));
    }
}
