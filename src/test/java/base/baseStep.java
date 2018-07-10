package base;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import support.PropertyReader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

public class baseStep {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static PropertyReader configfile;
    protected static Logger LOGGER = Logger.getLogger(baseStep.class.getName());
    protected static String ScenarioName = "";
}