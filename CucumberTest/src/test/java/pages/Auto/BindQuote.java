package pages.Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    @FindBy(xpath = "//div[contains(text(),'PA')]")
    WebElement policyNum;
    public BindQuote(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String bindQuote(String quoteNumber) throws InterruptedException {
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
        clickElement(saveChangesBtn, "Save");
        Thread.sleep(1000);
        clickElement(nextBtn, "Next");
        Thread.sleep(1000);
        clickElement(nextBtn, "Next");
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath("//div[text()='4.00']"),"Payments Schedule"),"4.00");
        clickElement(bindBtn, "Bind");
        Thread.sleep(1000);
        Assert.assertTrue(policyNum.isDisplayed());
        String policyNumber= getText(By.xpath("//div[text()='Policy Number']/../../../following-sibling::div/div"), "Policy number");
        return policyNumber;
    }
}
