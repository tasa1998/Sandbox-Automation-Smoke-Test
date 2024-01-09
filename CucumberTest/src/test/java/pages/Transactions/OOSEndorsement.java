package pages.Transactions;

import Interfaces.IOOSEndorsement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class OOSEndorsement extends BasePage implements IOOSEndorsement {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[text()='>>> new'")
    WebElement newTransaction;

    @FindBy(xpath = "//div[text()='Choose Transaction Type']/../../../..//input")
    WebElement type;

    @FindBy(xpath = "//div[text()='Endorsement Reason']/../../../..//input")
    WebElement reason;

    @FindBy(xpath = "//div[text()='New Transaction Effective Date']/../../../..//input")
    WebElement date;

    @FindBy(xpath = "//textarea")
    WebElement description;

    @FindBy(xpath = "//span[text()='>>> next']")
    WebElement next;

    @FindBy(xpath = "//span[text()='>>> modify out-of-sequence']")
    WebElement modifyOOS;

    @FindBy(xpath = "//span[text()='add driver']")
    WebElement addDriver;

    @FindBy(xpath = "//div[text()='First Name']/../../../..//input")
    WebElement name;

    @FindBy(xpath = "//div[text()='Last Name']/../../../..//input")
    WebElement lastName;

    @FindBy(xpath = "//div[text()='Gender']/../../../..//input")
    WebElement genderSelect;

    @FindBy(xpath = "//div[text()='Marital Status']/../../../..//input")
    WebElement maritalStatusSelect;

    @FindBy(xpath = "//div[text()='License Status']/../../../..//input")
    WebElement licenseStatusSelect;

    @FindBy(xpath = "//div[text()='Date of Birth']/../../../..//input")
    WebElement DOB;

    @FindBy(xpath = "//div[text()='Occupation']/../../../..//input")
    WebElement occupationSelect;

    @FindBy(xpath = "//span[text()='>>> change summary']")
    WebElement changeSummary;

    @FindBy(xpath = "//span[text()='>>> premium impact']")
    WebElement premiumImpact;

    @FindBy(xpath = "//span[text()='>>> view underwriting issues']")
    WebElement viewUWIssues;

    @FindBy(xpath = "//span[text()='>>> accept']")
    WebElement accept;

    @FindBy(xpath = "//span[text()='>>> process'] ")
    WebElement process;

    @FindBy(xpath = "//span[text()='>>> process'] //span[text()='OK']")
    WebElement ok;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exit;

    @FindBy(xpath = "//a[contains(text(), 'Automobile Policy')]")
    WebElement policynode;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextnode;

    @FindBy(xpath = "//span[contains(text(), 'Add')]")
    WebElement add;

    @FindBy(xpath = "//tr/td[2]/div[contains(text(), '- Select -')]")
    WebElement assignedName;

    @FindBy(xpath = "//tr/td[2]/div[contains(text(), '- Select -')]")
    WebElement assignedType;

    public OOSEndorsement(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void startOOSEndorsement(String transactionType, String transactionReason, String transactionEffectiveDate, String transactionDescription) {
        clickElement(transactions, "Transactions");
        clickElement(newTransaction, "New Transaction");
        typeText(type, transactionType, "Transaction Type");
        typeText(reason, transactionReason, "Transaction Reason");
        typeText(date, transactionEffectiveDate, "Effective Date");
        typeText(description, transactionDescription, "Transaction Description");
        clickElement(next, "Next");
        clickElement(modifyOOS, "Modify Out of Sequence");
    }

    @Override
    public void bodyOfTheOOSEndorsement(String firstName2, String lastName2, String dateOfBirth2, String gender2, String maritalStatus2, String certificate2, String occupation2, String licenceStatus2, String type2) {
        clickElement(policynode, "Automobile Policy");
        clickElement(nextnode, "Next");
        clickElement(addDriver, "Add Driver");
        typeText(name, firstName2, "First Name Field");
        typeText(lastName, lastName2, "Last Name Field");
        typeText(DOB, dateOfBirth2, "LoB Field");
        clickElement(genderSelect, "Gender dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + gender2 + "']")), "Gender");
        clickElement(maritalStatusSelect, "Marital Status dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + maritalStatus2 + "']")), "Marital Status");
        clickElement(driver.findElement(By.xpath("//div[text()='SR-22/ Certificate of Insurance Required?']/../../../..//label[text()='" + certificate2 + "']")), "Certificate Required");
        clickElement(occupationSelect, "Occupation dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + occupation2 + "']")), "Occupation");
        clickElement(licenseStatusSelect, "License Status dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + licenceStatus2 + "']")), "License Status");
        clickElement(nextnode, "Next");
        clickElement(nextnode, "Next");
        clickElement(add, "Add");
        clickElement(assignedName, "Assigned Driver Name Select");
        clickElement(driver.findElement(By.xpath("//ul/li[contains(text()," + firstName2 + ")]")), "Assigned Driver Name");
        clickElement(assignedType, "Assigned Driver Type Select");
        clickElement(driver.findElement(By.xpath("//ul/li[contains(text()," + type2 + ")]")), "Assigned Driver Name");
    }

    @Override
    public void endOOSEndorsement() {
        clickElement(changeSummary, "Change Summary");
        clickElement(premiumImpact, "Premium Impact");
        clickElement(viewUWIssues, "View UW Issues");
        clickElement(accept, "Accept");
        clickElement(ok, "OK");
        clickElement(accept, "Accept");
        clickElement(next, "Next");
        clickElement(next, "Next");
        clickElement(process, "Process");
        clickElement(ok, "OK");
        clickElement(exit, "Exit");
        Assert.assertTrue(true);
        Assert.assertTrue(true);
    }
}



