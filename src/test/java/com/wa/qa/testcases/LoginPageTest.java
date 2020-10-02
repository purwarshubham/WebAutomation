package test.java.com.wa.qa.testcases;

import main.java.com.wa.qa.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import main.java.com.wa.qa.pages.*;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String actualTitleSeen = loginPage.loginPageTitle();
        Assert.assertEquals(actualTitleSeen, "MyEvive");
    }

    @Test(priority = 2)
    public void validateLogoIsDisplayed() throws InterruptedException {
        Assert.assertTrue(loginPage.logoIsDisplayed());
    }

    @Test(priority = 3)
    public void loginTest(){
        dashBoardPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }



}
