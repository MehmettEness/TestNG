package team8_testngproject.tests.us10;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P14_VendorRegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC01 {
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    P14_VendorRegisterPage vendorRegisterPage;
    //Kullanıcı url'e gider
    //Kullanıcı registor butonuna tıklar
    //Kullanıcı Become a Vendor linkine tıklar
    //Kullanıcı kayıtlı olduğu mail adresini girer
    //Kullanıcı password kısmına 6 karakterden küçük değer girer


    @Test
    public void us10_Tc01() {
        //Kullanıcı url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Kullanıcı registor butonuna tıklar
        homePage=new P01_HomePage();
        homePage.registerButonZb.click();

        //Kullanıcı Become a Vendor linkine tıklar
        registerPage=new P02_RegisterPage();
        registerPage.becomeVendorZb.click();

        //Kullanıcı kayıtlı olduğu mail adresini girer
         vendorRegisterPage=new P14_VendorRegisterPage();
         vendorRegisterPage.emailzb.sendKeys(ConfigReader.getProperty("vendor_mail"));

        //Kullanıcı password kısmına 6 karakterden küçük değer girer
        vendorRegisterPage.vendorPassowordZb.click();
        vendorRegisterPage.vendorPassowordZb.sendKeys(ConfigReader.getProperty("vendor_tooShort_psw"));
        Assert.assertEquals(vendorRegisterPage.pswCommentZb.getText(),"Too short");

    }




}
