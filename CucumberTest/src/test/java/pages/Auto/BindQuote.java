package pages.Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class BindQuote extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='quotes']")
    WebElement quotesPage;

    @FindBy(xpath = "//span[text()='Details']")
    WebElement detailsTab;
    @FindBy(xpath = "//span[text()='>>> rate quote']")
    WebElement rateQuoteBtn;
    @FindBy(xpath = "//span[text()=' >>> request issue']")
    WebElement requestIssueBtn;
    @FindBy(xpath = "//div[text()='SR-22/ Certificate of Insurance Required?']/../../../..//label[text()='”certificate”']/../span")
    WebElement sr22certificateCheckbox;
    @FindBy(xpath = "//div[text()='Occupation']/../../../..//input[@value='- Select -']")
    WebElement occupationSelect;
    @FindBy(xpath = "//div[text()='Ownership']/../../../..//input")
    WebElement ownershipSelect;
    @FindBy(xpath = "//span[text()='save changes']")
    WebElement saveChangesBtn;
    @FindBy(xpath = "//span[text()='Print Quote Letter']")
    WebElement printQuoteLetterBtn;
    @FindBy(xpath = "//span[text()='>>> next ']")
    WebElement nextBtn;
    @FindBy(xpath = "//span[text()='next']")
    WebElement next;
    @FindBy(xpath = "//span[text()='>>> bind']")
    WebElement bindBtn;
    @FindBy(xpath = "//span[contains(text(), 'logout')]")
    WebElement logoutBtn;
    public BindQuote(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void bindQuote(String quoteNumber, String certificateOfInsurance, String occupation, String ownership) throws InterruptedException {
        clickElement(quotesPage, "Quotes tab");
        Thread.sleep(1000);
        clickElement(driver.findElement(By.xpath("//div[text()='"+quoteNumber+"']/../following-sibling::td/div/span")), "Quote number");
        Thread.sleep(1000);
        clickElement(detailsTab, "Details tab");
        Thread.sleep(1000);
        clickElement(rateQuoteBtn, "Rate button");
        Thread.sleep(1000);
        clickElement(requestIssueBtn, "Request Issue button");
        Thread.sleep(1000);
        clickElement(driver.findElement(By.xpath("//div[text()='SR-22/ Certificate of Insurance Required?']/../../../..//label[text()='" + certificateOfInsurance + "']")), "Certificate Required");
        clickElement(occupationSelect, "Occupation dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + occupation + "']")), "Occupation");
        clickElement(next, "Next");
        Thread.sleep(1000);
        clickElement(ownershipSelect, "Occupation dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + ownership + "']")), "Ownership");
        clickElement(saveChangesBtn, "Save");
        clickElement(rateQuoteBtn, "Rate");
        Thread.sleep(1000);
        clickElement(printQuoteLetterBtn, "Print Quote Letter");
        Thread.sleep(1000);
        clickElement(requestIssueBtn, "Request Issue");
        Thread.sleep(1000);
        clickElement(nextBtn, "Next");
        Thread.sleep(1000);
        clickElement(nextBtn, "Next");
        Thread.sleep(1000);
        clickElement(bindBtn, "Bind");
        Thread.sleep(1000);
        clickElement(logoutBtn, "Logout");
    }
}
