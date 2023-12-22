package steps;

import excel_core.GetExcelData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import pages.AutoPages.*;
import pages.CommonUtility;
import pages.CommonPages.Login;
import pages.CommonPages.NewQuoteCreation;
import pages.CommonPages.QuoteRegistration;
import pages.HomePages.EndOfQuoteCreation;
import pages.HomePages.LocationCoverage;
import pages.HomePages.PolicyInformation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Steps extends BaseSteps {

    Map<String, String> customerData = new HashMap<>();
    Map<String, String> homePageData = new HashMap<>();
    Map<String, String> homeOwnersData = new HashMap<>();
    Map<String, String> personalAutoData = new HashMap<>();

    final String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    final String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");

    @Before
    public void beforeCucumber() {
        setup(BROWSER, Integer.parseInt(WAIT));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String fileName = scenario.getName() + "_" + System.currentTimeMillis();
            String desc = "Screenshot when scenario failed: " + scenario.getName();

            try {
                reportScreenshot(fileName, desc);
                basequit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
         basequit();
    }



    @Given("the user opens the sandbox")
    public void theUserOpensTheSandbox() {driver.get("https://inforcedev.oneshield.com/oneshield/");
    }

    @And("user enters {string} in {string}")
    public void userEntersIn(String arg0, String arg1) throws IOException {
        String jsonFilePath = System.getProperty("user.dir") + "/src/webElements.json";
        driver.findElement(By.xpath(CommonUtility.getWebLocator("webLocators." + arg1 + ".xpath", jsonFilePath))).sendKeys(arg0);
    }

    @Then("user logs in")
    public void userLogsIn() {
        new Login(driver).login();
    }

    @Given("load data from excel file {string}, {string},{string},{string}")
    public void loadDataFromExcelFile(String arg0, String arg1, String arg2, String arg3) throws IOException {
        customerData = new GetExcelData().getRowData(arg0, "CustomerData", Integer.parseInt(arg2));
        homeOwnersData = new GetExcelData().getRowData(arg0, "Homeowners", Integer.parseInt(arg1));
        homePageData = new GetExcelData().getRowData(arg0, "HomePage", Integer.parseInt(arg3));
    }

    @Given("load data from Auto excel file {string}, {string},{string},{string}")
    public void loadDataFromAutoExcelFile(String arg0, String arg1, String arg2, String arg3) throws IOException {
        customerData = new GetExcelData().getRowData(arg0, "CustomerData", Integer.parseInt(arg2));
        homePageData = new GetExcelData().getRowData(arg0, "HomePage", Integer.parseInt(arg3));
        personalAutoData= new GetExcelData().getRowData(arg0, "PersonalAutoData", Integer.parseInt(arg1));
    }

    @Then("user create new customer")
    public void userCreateNewCustomer() throws InterruptedException {
        new NewQuoteCreation(driver).enterCustomerInformation(customerData.get("FirstName"), customerData.get("LastName"), customerData.get("DOB"), customerData.get("Email"), customerData.get("Phone"), customerData.get("Address Line 1"), customerData.get("ZIP Code"));
    }

    @And("user register quote")
    public void userRegisterQuote() {
        new QuoteRegistration(driver).fillInQuoteRegistration(homePageData.get("Producer"), homePageData.get("Effective Date"), homePageData.get("Program"));
    }

    @And("user fill in policy information")
    public void userFillInPolicyInformation() throws InterruptedException {
        new PolicyInformation(driver).fillInPolicyInformation(homeOwnersData.get("Billing Method"), homeOwnersData.get("Program Type"), homeOwnersData.get("Is Child or Day Care run out of the home?"), homeOwnersData.get("Any underground oil or storage tanks?"), homeOwnersData.get("Is the residence rented more than 10 weeks per year?"), homeOwnersData.get("Is the residence vacant?"), homeOwnersData.get("Are there any animals or exotic pets kept on the premises?"));
    }

    @And("user fill in location coverage")
    public void userFillInLocationCoverage() {
        if (homeOwnersData.get("Residence Type").equals("Tenants")) {
            new LocationCoverage(driver).fillInLocationCoverageTenant(homeOwnersData.get("Residence Type"), homeOwnersData.get("Contents"), homeOwnersData.get("Loss of Use"), homeOwnersData.get("Policy Coverage Option"), homeOwnersData.get("All Perils Deductible"), homeOwnersData.get("Windstorm or Hail Deductible"), homeOwnersData.get("Liability"), homeOwnersData.get("Medical Payments"), homeOwnersData.get("Year Built"), homeOwnersData.get("Roof Type"), homeOwnersData.get("Construction Type"), homeOwnersData.get("Any losses in the last three years?"), homeOwnersData.get("# of Floors"));
        } else {
            new LocationCoverage(driver).fillInLocationCoverage(homeOwnersData.get("Residence Type"), homeOwnersData.get("Replacement Cost"), homeOwnersData.get("Policy Coverage Option"), homeOwnersData.get("All Perils Deductible"), homeOwnersData.get("Windstorm or Hail Deductible"), homeOwnersData.get("Liability"), homeOwnersData.get("Medical Payments"), homeOwnersData.get("Year Built"), homeOwnersData.get("Roof Type"), homeOwnersData.get("Construction Type"), homeOwnersData.get("Any losses in the last three years?"), homeOwnersData.get("# of Floors"));
        }
    }

    @And("user binds quote")
    public void userBindsQuote() throws InterruptedException, IOException {
        new EndOfQuoteCreation(driver).bindQuote(homeOwnersData.get("Existing Agency Client?"), homeOwnersData.get("Has any company cancelled or refused to insure in the past 3 years?"), homeOwnersData.get("Has coverage been non-renewed or Declined?"));

    }

    @And("user fill in policy information Personal Auto")
    public void userFillInPolicyInformationPersonalAuto() throws InterruptedException {
        new Policy(driver).fillInPolicyPage(personalAutoData.get("Billing Method"),personalAutoData.get("Has anyone knowingly provided material"),personalAutoData.get("Does any vehicle have any existing damage?"));
    }

    @And("user fill in driver page")
    public void userFillInDriverPage() {
        new Driver(driver).fillInDriverPage(personalAutoData.get("Gender"),personalAutoData.get("Marital Status"),personalAutoData.get("SR-22/ Certificate of Insurance Required?"), personalAutoData.get("License Status"), personalAutoData.get("Occupation"),personalAutoData.get("License Year"),personalAutoData.get("License Number"));
    }

    @And("user fill in vehicle page")
    public void userFillInVehiclePage() throws InterruptedException {
        new Vehicle(driver).fillInVehiclePage(personalAutoData.get("Year"),personalAutoData.get("Make"),personalAutoData.get("Model"),personalAutoData.get("Specification"),personalAutoData.get("Vehicle Use"));
    }

    @And("user fill in coverage page")
    public void userFillInCoveragePage() {
        new Coverage(driver).fillInCoveragePage(personalAutoData.get("Policy Coverage Option"));
    }

    @And("user override underwriting referral")
    public void userOverrideUnderwritingReferral() {
        new Underwriting(driver).fillInUWQuestions(personalAutoData.get("Underwriter's Comments"),personalAutoData.get("Overridden"));
    }

    @And("user fill in wind mitigation")
    public void userFillInWindMitigation() {
        new LocationCoverage(driver).fillInLocationCoverageRegression(homeOwnersData.get("Residence Type"), homeOwnersData.get("Replacement Cost"), homeOwnersData.get("Policy Coverage Option"), homeOwnersData.get("All Perils Deductible"), homeOwnersData.get("Windstorm or Hail Deductible"), homeOwnersData.get("Liability"), homeOwnersData.get("Medical Payments"), homeOwnersData.get("Year Built"), homeOwnersData.get("Roof Type"), homeOwnersData.get("Construction Type"), homeOwnersData.get("Any losses in the last three years?"), homeOwnersData.get("# of Floors"),homeOwnersData.get("Roof Shape"),homeOwnersData.get("Secondary Water Resistance"),homeOwnersData.get("Opening Protection"),homeOwnersData.get("Roof Deck"),homeOwnersData.get("Distance to Shore"),homeOwnersData.get("Roof Deck Attachment"),homeOwnersData.get("Roof Wall Connection"));

    }

    @And("user fill in driver page with incidents")
    public void userFillInDriverPageWithIncidents() {
        new Driver(driver).fillInDriverPageRegression(personalAutoData.get("Gender"),personalAutoData.get("Marital Status"),personalAutoData.get("SR-22/ Certificate of Insurance Required?"), personalAutoData.get("License Status"), personalAutoData.get("Occupation"),personalAutoData.get("License Year"),personalAutoData.get("License Number"), personalAutoData.get("Incident Date"));

    }

    @And("user fill in vehicle page with extra vehicle")
    public void userFillInVehiclePageWithExtraVehicle() throws InterruptedException {
        new Vehicle(driver).fillInVehiclePageRegression(personalAutoData.get("Year"),personalAutoData.get("Make"),personalAutoData.get("Model"),personalAutoData.get("Specification"),personalAutoData.get("Vehicle Use"), personalAutoData.get("Original Cost"), personalAutoData.get("Stated Amount"), personalAutoData.get("Make2"), personalAutoData.get("Model2"), personalAutoData.get("Specification2"), personalAutoData.get("Vehicle Use2"), personalAutoData.get("Vehicle Type"), personalAutoData.get("Ownership"), personalAutoData.get("Ownership2"));
    }


    @When("verify that the appropriate referral is displayed")
    public void verifyThatTheAppropriateReferralIsDisplayed() {
        if(homePageData.get("Program").equals("Homeowner"))
            Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Roof Wall Connection Type is Toe Nails and NOT located in zones 15,16,17,18,19']")).getText(), "Roof Wall Connection Type is Toe Nails and NOT located in zones 15,16,17,18,19");
        else
            Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Roof Wall Connection Type is Toe Nails and NOT located in zones 15,16,17,18,19']")).getText(), "Roof Wall Connection Type is Toe Nails and NOT located in zones 15,16,17,18,19");

    }

    @Then("verify that the policy has been issued")
    public void verifyThatThePolicyHasBeenIssued() {
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='mode3']/span")).getText(), "Cannot bind this quote for this customer due to existing policy.");
    }
}
