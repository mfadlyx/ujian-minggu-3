package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utlis.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @AfterClass
    public void finish(){
        Utils.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    //positive test
    @Test(priority = 1)
    public void testDisplayImgCompanyBranding(){
        Utils.delay(3);
        Assert.assertTrue(loginPage.getImgCompanyBranding());
    }

    @Test(priority = 2)
    public void testValidLogin(){
        loginPage.loginUser("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.getTxtDashboard(), "Swag Labs");
    }


    //negative test
    @Test(priority = 3)
    public void testInvalidLogin(){
        homePage.logout();
        loginPage.loginUser("standard_user", "admin123");
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Username and password do not match any user in this service");
    }
}
