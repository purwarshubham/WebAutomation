package main.java.com.wa.qa.util;


import main.java.com.wa.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT= 10;

    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    public static String takeScreenShot() throws IOException {

        // String currentDirectory = System.getProperty("user.dir")+ "/screenshots/";
        String fileName = "screenshots/" + System.currentTimeMillis() + ".png";
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destination = new File(fileName);

        FileUtils.copyFile(screenShotFile, destination);
        return String.valueOf(destination);

    }
}
