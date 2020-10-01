package com.wa.qa.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wa.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashBoardPage extends TestBase {

    // Page Elements / Object Repository

    @FindBy(css = "div.ev-tooltip-description")
    private WebElement toolTip ;

    @FindBy(xpath = "//img[@alt='Evive Logo']")
    private List<WebElement> logo;

    // Initialization of elements
    public DashBoardPage(){
        PageFactory.initElements(driver, this);
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }

    // Actions :
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String toolTipContent(){
        return toolTip.getText();
    }

    public boolean logoIsDisplayed(){
        return logo.get(0).isDisplayed();
    }

}
