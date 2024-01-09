package pages.Transactions;


import Interfaces.IReinstatement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class Reinstatement extends BasePage implements IReinstatement {

    WebDriver driver;
    @FindBy(xpath = "//span[text()='transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[text()='>>> new'")
    WebElement newTransaction;

    @FindBy(xpath = "//div[text()='Choose Transaction Type']/../../../..//input")
    WebElement type;

    @FindBy(xpath = "//div[text()='New Transaction Effective Date']/../../../..//input")
    WebElement date;

    @FindBy(xpath = "//textarea")
    WebElement description;

    @FindBy(xpath = "//span[text()='>>> next']")
    WebElement next;

    @FindBy(xpath = "//div[text()='Claims/Losses post cancellation?']/../../../..//input")
    WebElement claims;

    @FindBy(xpath = "//div[text()='Reinstatement Reason']/../../../..//input")
    WebElement reason;

    @FindBy(xpath = "//span[text()='>>> process'] ")
    WebElement process;

    @FindBy(xpath = "//span[text()='>>> process'] //span[text()='OK']")
    WebElement ok;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exit;

    public Reinstatement(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    public void startReinstatement(String transactionType, String transactionEffectiveDate, String transactionDescription) {
        clickElement(transactions, "Transactions");
        clickElement(newTransaction, "New Transaction");
        typeText(type, transactionType, "Transaction Type");
        typeText(date, transactionEffectiveDate, "Effective Date");
        typeText(description, transactionDescription, "Transaction Description");
        clickElement(next, "Next");
    }

    @Override
    public void processReinstatement(String reinstatementClaims, String reinstatementReason) {
        typeText(claims, reinstatementClaims, "Reinstatement Method");
        typeText(reason, reinstatementReason, "Reinstatement Reason");
        clickElement(next, "Next");
        clickElement(process, "Process");
        clickElement(ok, "OK");
        clickElement(exit, "Exit");
        Assert.assertTrue(true);
        Assert.assertTrue(true);
    }
}
