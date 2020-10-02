package main.java.com.wa.qa.ExtentReportListener;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {


    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        htmlReporter.config().enableTimeline(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("extent.html");
        // htmlReporter.config().setCSS(".test-status.skip {color : #009dff ;}");
        htmlReporter.config().setCSS(".r-img { width: 30%; }");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        ExtentReports extent = new ExtentReports();
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester Name", "Shubham Purwar");
        extent.setSystemInfo("environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        return extent;

    }

}



// Old code


/*
*
*
*
*         public ExtentReports getInstance() {

            if (null == extent) {
                createInstance( "/Users/shubhampurwar/Documents/Projects/Ionic/RestAssured_Framework/src/test/java/"+ "extent.html");
            }
            return extent;
        }
*
*
        public static ExtentReports createInstance(String fileName) {

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
            try {
                String filepath = new ClassPathResource("extent-config.xml").getFile().getAbsolutePath();
                htmlReporter.loadConfig(filepath);
                htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
                htmlReporter.config().setChartVisibilityOnOpen(true);
                htmlReporter.config().setTheme(Theme.STANDARD);
                htmlReporter.config().setDocumentTitle(fileName);
                htmlReporter.config().setEncoding("utf-8");
                htmlReporter.config().setReportName(fileName);
                extent = new ExtentReports();
                extent.attachReporter(htmlReporter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return extent;
        }

*
* */