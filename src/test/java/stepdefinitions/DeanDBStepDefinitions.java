package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DeanDBStepDefinitions {
    @Given("Database baglantisi kurulur")
    public void database_baglantisi_kurulur() {
        DBUtils.createSMConnection();
    }
    @Then("database de dean olusturuldugu dogrulanir username {string}, ssn {string}, phone number {string} database {string} table")
    public void database_de_dean_olusturuldugu_dogrulanir_username_ssn_phone_number_database_table(String expectedUsername, String expectedSsn, String expectedPhoneNumber, String tableName) {
        try {

//   Database baglandik
//        db name = school_management
//        table name = dean

//   dean table icin query olurtur
            String query  = "select * from "+tableName+"";
//   dean table icin olusturulan query i okuyalim
            DBUtils.executeMyQuery(query);
//        datalari atrik bu java class a alabilirim
//        sonraki satira atladik
            DBUtils.getMyResultset().next();
//        Bu satirdaki username i ver
            System.out.println(DBUtils.getMyResultset().getString("username"));//ilk username
            System.out.println(DBUtils.getMyResultset().getString("ssn"));//139-91-2518//ilk ssn
            System.out.println(DBUtils.getMyResultset().getString("phone_number"));//520-123-1401//ilk phone number

//            tum username
            List<Object> usernameList = DBUtils.getMyColumnData(query,"username");
            System.out.println(usernameList);
//            tum ssn
            List<Object> ssnList = DBUtils.getMyColumnData(query,"ssn");
            System.out.println(ssnList);
//            tum phone number
            List<Object> phoneList = DBUtils.getMyColumnData(query,"phone_number");
            System.out.println(phoneList);

//            assertion - database de bekledigimiz kombinasyondaki dean varligi dogrulanir

            assertTrue(
                    "FAILED - Listede Beklenene kullanici bulunamadi!!!",
                    usernameList.contains(expectedUsername)
                            && ssnList.contains(expectedSsn)
                            && phoneList.contains(expectedPhoneNumber));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    class ends
}
