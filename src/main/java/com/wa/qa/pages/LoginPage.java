package com.wa.qa.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
    // PageFactory => Object Factory
    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//img[@alt='Evive Logo']")
    private List<WebElement> logo;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    // Initializing the Page Objects

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions

    public String loginPageTitle(){
        return driver.getTitle();
    }

    public boolean logoIsDisplayed() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        return logo.get(0).isDisplayed();
    }

    public DashBoardPage login(String un, String pw){
        userName.sendKeys(un);
        password.sendKeys(pw);
        submit.click();
        return new DashBoardPage();
    }
}
