package steps.hooks;

import base.baseStep;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import support.driverHelpers;

import java.beans.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class hooks extends baseStep {

    private driverHelpers driverHelper = new driverHelpers();

    @Before()
    public void testInitialize(Scenario scenario) throws Exception {
        driver = driverHelper.retrieveDriver();
        ScenarioName = scenario.getName();
    }

    @After()
    public void teardown(Scenario scenario) throws Exception {

        if(scenario.isFailed()) {

            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());

                String timestamp = new SimpleDateFormat("dd.mm.yyy.HH.mm.ss").format(new Date());
                String folderPath = "target/screenshots/";
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File destfile = new File(folderPath + scenario.getName() + ".png");
                FileUtils.copyFile(screenshot, destfile);

                byte[] data = FileUtils.readFileToByteArray(screenshot);
                scenario.embed(data, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

        driverHelper.deleteAllCookies(driver);

        if (scenario.getSourceTagNames().contains("@reset")) {
            driverHelper.close(driver);
        } else {
            driverHelper.release(driver);
        }
    }




}

