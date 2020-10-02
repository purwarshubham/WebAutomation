package test.java.com.wa.qa.testcases;

import main.java.com.wa.qa.base.TestBase;
import main.java.com.wa.qa.pages.DashBoardPage;
import main.java.com.wa.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static main.java.com.wa.qa.base.TestBase.initialization;

public class DashBoardPageTest extends TestBase {

    Logger log = Logger.getLogger(String.valueOf(DashBoardPage.class));

    DashBoardPage dashBoardPage;
    // TestUtil testUtil;

    public DashBoardPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        // testUtil = new TestUtil();
        dashBoardPage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void validateCurrentUrl(){
        log.info("+++++++++  This is log testing ++++++++++");
        Assert.assertEquals(dashBoardPage.getUrl(), "https://ehealthreminders.net/dashboard/");
    }

    @Test
    public void validateToolTipContent(){
        // testUtil.switchToFrame("dummyFrame");
        Assert.assertEquals(dashBoardPage.toolTipContent(), "Passing Incorrect values");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
