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
import pages.Auto.*;
import pages.CommonUtility;
import pages.Common.Login;
import pages.Common.NewQuoteCreation;
import pages.Common.QuoteRegistration;
import pages.Home.EndOfQuoteCreation;
import pages.Home.LocationCoverage;
import pages.Home.PolicyInformation;
import pages.Transactions.Endorsement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Steps extends BaseSteps {

    Map<String, String> customerData = new HashMap<>();
    Map<String, String> homePageData = new HashMap<>();
    Map<String, String> homeOwnersData = new HashMap<>();
    Map<String, String> personalAutoData = new HashMap<>();
    Map<String, String> vehicleData = new HashMap<>();
    Map<String, String> vehicleToAddData = new HashMap<>();
    Map<String, String> endorsementData = new HashMap<>();
    String quoteNumber;

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


//    @Given("load data from excel file {string}, {string},{string},{string}")
//    public void loadDataFromExcelFile(String arg0, String arg1, String arg2, String arg3) throws IOException {
//        customerData = new GetExcelData().getRowData(arg0, "CustomerData", Integer.parseInt(arg2));
//        homeOwnersData = new GetExcelData().getRowData(arg0, "Homeowners", Integer.parseInt(arg1));
//        homePageData = new GetExcelData().getRowData(arg0, "HomePage", Integer.parseInt(arg3));
//
//    }

    @Given("load data from Auto excel file {string}, {string},{string},{string}")
    public void loadDataFromAutoExcelFile(String arg0, String arg1, String arg2, String arg3) throws IOException {
        customerData = new GetExcelData().getRowData(arg0, "CustomerData", Integer.parseInt(arg2));
        personalAutoData= new GetExcelData().getRowData(arg0, "PersonalAutoData", Integer.parseInt(arg1));
        vehicleData = new GetExcelData().getRowData(arg0,"VehicleData", Integer.parseInt(arg3));
    }

    @Then("user create new customer")
    public void userCreateNewCustomer() throws InterruptedException {
        new NewQuoteCreation(driver).enterCustomerInformation(customerData.get("First_Name"), customerData.get("Last_Name"), customerData.get("DoB"), customerData.get("Email"), customerData.get("Phone"), customerData.get("Address"), customerData.get("ZIP_Code"));
    }

    @And("user register quote")
    public void userRegisterQuote() {
        new QuoteRegistration(driver).fillInQuoteRegistration(personalAutoData.get("Effective_Date"), personalAutoData.get("Program"));
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
        new BindQuote(driver).bindQuote(quoteNumber, customerData.get("SR-22/Certificate_of_Insurance_Required?"), customerData.get("Occupation"),vehicleData.get("Ownership"));
    }

    @And("user fill in policy information Personal Auto")
    public void userFillInPolicyInformationPersonalAuto() throws InterruptedException {
        new Policy(driver).fillInPolicyPage(personalAutoData.get("Billing_Method"),personalAutoData.get("Eligibility_in_case_of_false_information"),personalAutoData.get("Eligibility_in_case_of_existing_damage"));
    }

    @And("user fill in driver page")
    public void userFillInDriverPage() throws InterruptedException {
        new Driver(driver).fillInDriverPage(customerData.get("Gender"),customerData.get("Marital_Status"), customerData.get("License_Status"), personalAutoData.get("License_State/Province"));
    }

    @And("user fill in vehicle page")
    public void userFillInVehiclePage() throws InterruptedException {
        new Vehicle(driver).fillInVehiclePage(vehicleData.get("Year"),vehicleData.get("Make"),vehicleData.get("Model"),vehicleData.get("Specification"),vehicleData.get("Vehicle_Use"));
    }

    @And("user fill in coverage page")
    public void userFillInCoveragePage() {
        new Coverage(driver).fillInCoveragePage(personalAutoData.get("Policy_Coverage_Option"));
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

    @When("user refer to UW")
    public void userReferToUW() throws InterruptedException {
        quoteNumber = new pages.Auto.EndOfQuoteCreation(driver).endOfQuoteCreation(personalAutoData.get("Underwriter's_Comments"));
    }

    @Then("user logs in as Senior UW")
    public void userLogsInAsSeniorUW() {
        new Login(driver).loginAsSeniorUW();
    }

    @And("user search for quote")
    public void userSearchForQuote() {
        new ApproveReferrals(driver).selectCreatedQuote(quoteNumber);
    }

    @And("user approve referrals")
    public void userApproveReferrals() throws InterruptedException {
        new ApproveReferrals(driver).approveReferrals();
    }

    @When("user create an Endorsement {string},{string}")
    public void userCreateAnEndorsement(String arg0, String arg1) throws IOException {
        endorsementData = new GetExcelData().getRowData(arg0,"EndorsementData", Integer.parseInt(arg1));
        new Endorsement(driver).startEndorsement(endorsementData.get("Type"), endorsementData.get("Sub_Type"), endorsementData.get("Reason"),endorsementData.get("Effective_Date"),endorsementData.get("Description"));
    }
    @And("user add vehicle on Endorsement {string}, {string}")
    public void userAddVehicleOnEndorsement(String arg0, String arg1) throws IOException {
        vehicleToAddData = new GetExcelData().getRowData(arg0,"VehicleData", Integer.parseInt(arg1));
        new Endorsement(driver).bodyOfTheEndorsement(vehicleToAddData.get("Year"),vehicleToAddData.get("Make"),vehicleToAddData.get("Model"),vehicleToAddData.get("Specification"),vehicleToAddData.get("Vehicle_Use"),vehicleToAddData.get("Ownership"));
    }
    @Then("user process and Endorsement")
    public void userProcessAndEndorsement() {
        new Endorsement(driver).endEndorsement();
    }

    @And("user logs in as Agency Producer")
    public void userLogsInAsAgencyProducer() {
        new Login(driver).loginAsAgencyProducer();
    }
}