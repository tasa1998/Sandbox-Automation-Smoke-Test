package pages.Transactions;


import Interfaces.ICancellation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class Cancellation extends BasePage implements ICancellation {

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

    @FindBy(xpath = "//div[text()='Cancel Reason']/../../../..//input")
    WebElement reason;

    @FindBy(xpath = "//div[text()='Cancellation Method']/../../../..//input")
    WebElement method;

    @FindBy(xpath = "//span[text()='>>> process'] ")
    WebElement process;

    @FindBy(xpath = "//span[text()='>>> process'] //span[text()='OK']")
    WebElement ok;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exit;

    public Cancellation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    public void startCancellation(String transactionType, String transactionEffectiveDate, String transactionDescription) {
        clickElement(transactions, "Transactions");
        clickElement(newTransaction, "New Transaction");
        typeText(type, transactionType, "Transaction Type");
        typeText(date, transactionEffectiveDate, "Effective Date");
        typeText(description, transactionDescription, "Transaction Description");
        clickElement(next, "Next");
    }

    @Override
    public void processCancellation(String cancelReason, String cancelMethod) {
        typeText(reason, cancelReason, "Cancellation Reason");
        typeText(method, cancelMethod, "Cancellation Method");
        clickElement(process, "Process");
        clickElement(ok, "OK");
        clickElement(exit, "Exit");
        Assert.assertEquals(getText(By.xpath("//span[contains(text(),'Cancellation - Insured')]"),"Cancellation - Insured"),"Cancellation - Insured");
        Assert.assertEquals(getText(By.xpath("//span[contains(text(), 'Cancel')]/../../following-sibling::td[10]"),"Cancellation"),"Processed");
    }
}
