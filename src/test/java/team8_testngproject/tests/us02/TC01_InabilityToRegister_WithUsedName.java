package team8_testngproject.tests.us02;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC01_InabilityToRegister_WithUsedName {
@Test
    public void cannotSignUpWithUsedData1(){
    Driver.getDriver().get(ConfigReader.getProperty("URL"));
    Faker faker = new Faker();
    P01_HomePage homePage=new P01_HomePage();
    homePage.userRegisterButton.click();
    P02_RegisterPage registerPage = new P02_RegisterPage();
    registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUsername1"));
    registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
    registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
    registerPage.policyAgreementBox.click();
    registerPage.userSignUpButton.click();

    Assert.assertTrue(registerPage.alreadyUsedUsernameStatement.isDisplayed());
    Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());

    waitFor(3);
    Driver.closeDriver();
}

}
