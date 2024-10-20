package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utlis.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class= 'app_logo']")
    private WebElement txtDashboard;
    @FindBy(xpath = "//button[@id= 'react-burger-menu-btn']")
    private WebElement menuBar;
    @FindBy(xpath = "//a[@id= 'logout_sidebar_link']")
    private WebElement btnLogout;
    @FindBy(xpath = "//button[@name= 'add-to-cart-sauce-labs-bike-light']")
    private WebElement btnAddToCart;
    @FindBy(xpath = "//a[@class= 'shopping_cart_link']")
    private WebElement btnToCartLink;
    @FindBy(xpath = "//span[@class= 'shopping_cart_badge']")
    private WebElement txtShopCartBadge;
    @FindBy(xpath = "//button[@id= 'remove-sauce-labs-bike-light']")
    private WebElement txtRemoveYourCart;


    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public void logout(){
        menuBar.click();
        Utils.delay(3);
        btnLogout.click();
    }

    public void setBtnAddToCart(){
        btnAddToCart.click();
    }

    public void setBtnToCartLink(){
        btnToCartLink.click();
    }

    public String getTxtShopCartBadge(){
        return txtShopCartBadge.getText();
    }

    public String getTxtRemoveYourCart(){
        return txtRemoveYourCart.getText();
    }
}
