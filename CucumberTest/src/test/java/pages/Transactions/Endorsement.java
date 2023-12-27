package pages.Transactions;

import Interfaces.ITransactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Endorsement extends BasePage implements ITransactions {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[text()='>>> new'")
    WebElement newTransaction;

    @FindBy(xpath = "//div[text()='Choose Transaction Type']/../../../..//input")
    WebElement type;

    @FindBy(xpath = "//div[text()='Choose Transaction Sub Type']/../../../..//input")
    WebElement subtype;

    @FindBy(xpath = "//div[text()='Endorsement Reason']/../../../..//input")
    WebElement reason;

    @FindBy(xpath = "//div[text()='New Transaction Effective Date']/../../../..//input")
    WebElement date;

    @FindBy(xpath = "//textarea")
    WebElement description;

    @FindBy(xpath = "//span[text()='>>> next']")
    WebElement next;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exitBtn;

    @FindBy(xpath = "//span[text()='add vehicle']")
    WebElement addVehicle;

    @FindBy(xpath = "//div[text()='Year']/../../../..//input[@value='- Select -']")
    WebElement year;

    @FindBy(xpath = "//div[text()='Make']/../../../..//input[@value='- Select -']")
    WebElement make;

    @FindBy(xpath = "//div[text()='Model']/../../../..//input[@value='- Select -']")
    WebElement model;

    @FindBy(xpath = "//div[text()='Specification']/../../../..//input[@value='- Select -']")
    WebElement specification;

    @FindBy(xpath = "//div[text()='Vehicle Use']/../../../..//input[@value='- Select -']")
    WebElement use;

    @FindBy(xpath = "//div[text()='Ownership']/../../../..//input[@value='- Select -']")
    WebElement ownership;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextnode;

    @FindBy(xpath = "//span[text()='save changes']")
    WebElement save;

    @FindBy(xpath = "//span[text()='>>> change summary']")
    WebElement changeSummary;

    @FindBy(xpath = "//span[text()='>>> premium impact']")
    WebElement premiumImpact;

    @FindBy(xpath = "//span[text()='>>> process'] ")
    WebElement process;

    @FindBy(xpath = "//span[text()='>>> process'] //span[text()='OK']")
    WebElement ok;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exit;


    public Endorsement(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void startTransaction() {

    }

    @Override
    public void bodyOfTheTransaction() {
          }

    @Override
    public void endTransaction() {

    }

    public void body(String yearvalue, String makevalue, String modelvalue, String specificationvalue, String usagevalue, String ownershipvalue) {
        clickElement(nextnode, "Next Node");
        clickElement(nextnode, "Next Node");
        clickElement(addVehicle, "Add Vehicle");
        clickElement(year, "Year dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + yearvalue + "']")), "Year");
        clickElement(make, "Make dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + makevalue + "']")), "Make");
        clickElement(model, "Model dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + modelvalue + "']")), "Model");
        clickElement(specification, "Specification dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + specificationvalue + "']")), "Specification");
        clickElement(use, "VehicleUse dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + usagevalue + "']")), "VehicleUse");
        clickElement(ownership, "Ownership dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + ownershipvalue + "']")), "Ownership");
        clickElement(nextnode, "Next Node");
    }

    public void end() {
        clickElement(save, "Save Changes");
        clickElement(changeSummary, "Change Summary");
        clickElement(premiumImpact, "Premium Impact");
        clickElement(next, "Next");
        clickElement(next, "Next");
        clickElement(process, "Process");
        clickElement(ok, "OK");
        clickElement(exit, "Exit");
    }

    public void start(String transactionType, String transactionSubtype, String transactionReason, String transactionEffectiveDate, String transactionDescription) {
        clickElement(transactions, "Transactions");
        clickElement(newTransaction, "New Transaction");
        typeText(type, transactionType, "Transaction Type");
        typeText(subtype, transactionSubtype, "Transaction Sub Type");
        typeText(reason, transactionReason, "Transaction Reason");
        typeText(date, transactionEffectiveDate, "Effective Date");
        typeText(description, transactionDescription, "Transaction Description");
        clickElement(next, "Next");
    }
}
