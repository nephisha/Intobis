package page;

import base.baseStep;
import cucumber.api.Scenario;
import org.junit.Assert;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.PropertyReader;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;

//import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class basePage extends baseStep {

    public basePage() {
        wait = new WebDriverWait(driver,90);
        configfile = new PropertyReader("config");
    }

    public String EnvURLSelection(String envtype) {
        String URL = "";

        //If we forget to enter the envtype by default we shall execute on UAT Env
        if(envtype==null) envtype="UAT";

        switch (envtype.toUpperCase()) {
            case "PROD":
                URL = configfile.readProperty("web_prod_url");
                break;
            case "UAT":
                URL = configfile.readProperty("web_uat_url");
                break;
            default:
                LOGGER.info("The Env Type mentioned is incorrect");
        }
        return URL;
    }

    /**
     * This function is to move the mouse pointer to the specified location
     *
     * @param element
     *            - By object to locate the element to which mouse pointer has
     *            to be moved
     */
    public void mouseOver(WebElement element)
    {
        try
        {
            new Actions(driver).moveToElement(element)
                    .build().perform();
            LOGGER.info("Mouse hover is performed on element with"
                    + element.toString().replace("By.", " "));
        }
        catch (NoSuchElementException e)
        {
            LOGGER.info("Unable to perform MouseOver; The element with");
        }
    }

    public void switchWindows (String number)
    {
        try
        {
            Set<String> AllWindowHandles = driver.getWindowHandles();

            if(number.equals("new"))
            {
                String window2 = (String) AllWindowHandles.toArray()[1];
                driver.switchTo().window(window2);
            }
            else if(number.equals("old"))
            {
                String window1 = (String) AllWindowHandles.toArray()[0];
                driver.switchTo().window(window1);
            }
        }
        catch (WebDriverException e)
        {
            LOGGER.info("Unable to returm the window handle: " + e.getStackTrace());
            throw new WebDriverException("Unable to return the window handle");
        }
    }
}
