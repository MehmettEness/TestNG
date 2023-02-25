package team8_testngproject.tests.us01;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC04_Incompatible_email {

    @Test
    public void UnsuccessfulRegistration_wrongEmail() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername1"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedEmail1"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword1"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
        waitFor(3);
        Driver.closeDriver();

    }
}
