package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends basePage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,60), this);
    }

    @FindBy(how = How.ID, using = "menu-item-177")
    private WebElement productlink;

    @FindBy(how = How.ID, using = "menu-item-988")
    private WebElement portallink;

    @FindBy(how = How.CSS, using = ".sow-image-container > a")
    private List<WebElement> availableportallinks;

    @FindBy(how = How.CSS, using = "title")
    private WebElement redirectedlinktitle;

    public void NavigateTo(String url) {
        driver.get(url);
    }

    public void HoverOnProducts() {
        mouseOver(productlink);
    }

    public void ClickOnPortals() {
        portallink.click();
    }

    public void ClickOnAvailableLinks(String link) {
        availableportallinks.stream()
                .filter(i -> i.getAttribute("href")
                        .contains(link)).findFirst().get().click();
    }

    public String GetTheRedirectedLink() {
        switchWindows("new");
        return driver.getTitle();
    }
}
