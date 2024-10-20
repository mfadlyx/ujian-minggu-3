package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utlis.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @AfterClass
    public void finish(){
        Utils.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testAddItemToCart(){
        loginPage.loginUser("standard_user", "secret_sauce");
        Utils.delay(3);
        homePage.setBtnAddToCart();
        Assert.assertEquals(homePage.getTxtDashboard(), "Swag Labs");
        Assert.assertEquals(homePage.getTxtRemoveYourCart(), "Remove");
        Assert.assertEquals(homePage.getTxtShopCartBadge(), "1");
        homePage.setBtnToCartLink();
        Assert.assertEquals(cartPage.getTxtItemName(), "Sauce Labs Bike Light");
    }
}
