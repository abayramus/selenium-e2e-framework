package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AddDeanPage;
import pages.CommonPage;
import utilities.Driver;

import static utilities.WaitUtils.waitFor;

public class DeanStepDefinitions {

    CommonPage commonPage = new CommonPage();
    AddDeanPage addDeanPage = new AddDeanPage();
    @Given("kullanici {string} sayfasina {string} olarak giris yapar")
    public void kullanici_sayfasina_olarak_giris_yapar(String url, String profile) {
//sayfaya git
        Driver.getDriver().get(url);
//login et
        commonPage.login("AdminAhmet","AhmetBayram1+");
        waitFor(3);
    }
    @Given("dean sayfasina gider ve su verilerle dean olusturulur : name {string}, surname {string}, birth_place {string}, gender {string}, date_of_birth {string}, phone {string}, ssn {string}, username {string}, password {string}")
    public void dean_sayfasina_gider_ve_su_verilerle_dean_olusturulur_name_surname_birth_place_gender_date_of_birth_phone_ssn_username_password
            (
            String name,
            String surname,
            String birth_place,
            String gender,
            String date_of_birth,
            String phone,
            String ssn,
            String username,
            String password
            ) {
        waitFor(1);

//        DEAN MANAGEMENT SAYFASINA GIDER
        addDeanPage.navigateToDeanManagement();

//        DEAN BILGILERINI GIRER
        addDeanPage.enterDeanInfo(
                name,surname,birth_place,gender,date_of_birth,phone,ssn,username,password
        );

    }

    @Then("dean olusturuldugunu ve {string} mesajini dogrulanir")
    public void dean_olusturuldugunu_ve_mesajini_dogrulanir(String message) {
        addDeanPage.verifyDeanRegistration(message);//message feature filedan geliyor. bu ornekte message = Dean Created.
    }

    @Then("uygulama kapalitir")
    public void uygulama_kapalitir() {
        Driver.closeDriver();
    }


}
