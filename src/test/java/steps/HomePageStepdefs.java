package steps;

import base.baseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page.HomePage;
import page.basePage;

public class HomePageStepdefs extends baseStep {

    private basePage basepageObject = new basePage();
    private HomePage homepageObject = new HomePage(driver);

    @Given("^I launch the Intobis website$")
    public void iLaunchTheIntobisWebsite() throws Throwable {

        String EnvURL = basepageObject.EnvURLSelection(System.getProperty("env.type"));
        homepageObject.NavigateTo(EnvURL);
    }

    @And("^I navigate to Product Portals$")
    public void iNavigateToProductPortals() throws Throwable {
        homepageObject.HoverOnProducts();
        homepageObject.ClickOnPortals();
    }

    @When("^I click on the \"([^\"]*)\"$")
    public void iClickOnThe(String link) throws Throwable {
        homepageObject.ClickOnAvailableLinks(link);
    }

    @Then("^I should be taken to the link homepage with \"([^\"]*)\"$")
    public void iShouldBeTakenToTheLinkHomepageWith(String title) throws Throwable {
        Assert.assertEquals(homepageObject.GetTheRedirectedLink(),title);
    }
}
