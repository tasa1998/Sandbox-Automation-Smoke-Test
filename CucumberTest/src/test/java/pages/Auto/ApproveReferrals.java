package pages.Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ApproveReferrals extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='quotes']")
    WebElement quotesBtn;
    @FindBy(xpath = "//span[text()='>>> review underwriting issues']")
    WebElement reviewUWIssuesBtn;
    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[5]")
    WebElement uwCommentsField;
    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[6]/div")
    WebElement overriddenSelect;
    @FindBy(xpath = "//span[text()='>>> accept']")
    WebElement acceptBtn;
    @FindBy(xpath = "//span[text()='OK']")
    WebElement okButton;
    @FindBy(xpath = "//span[text()='>>>Next']")
    WebElement nextBtn;
    @FindBy(xpath = "//label[text()='Email']/..//input")
    WebElement emailCheckbox;
    @FindBy(xpath = "//span[text()='exit']")
    WebElement exitBtn;
    @FindBy(xpath = "//span[text()='home']")
    WebElement homeTab;
    @FindBy(xpath = "//span[contains(text(), 'logout')]")
    WebElement logoutBtn;


    public ApproveReferrals(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCreatedQuote(String quoteNumberText){
        clickElement(quotesBtn,"Quotes");
        clickElement(driver.findElement(By.xpath("//div[text()='"+quoteNumberText+"']/../following-sibling::td/div/span")), "Quote Number");
    }

    public void approveReferrals() throws InterruptedException {
        clickElement(reviewUWIssuesBtn, "review UW issues");
        typeText(uwCommentsField,"Verified and Approved", "Verified and Approved");
        clickElement(overriddenSelect, "Override");
        clickElement(driver.findElement(By.xpath("//li[text()='Yes']")), "overridden");
        clickElement(acceptBtn, "Accept");
        Thread.sleep(1000);
        clickElement(okButton, "OK");
        Thread.sleep(1000);
        clickElement(nextBtn,"Next");
        Thread.sleep(1000);
        clickElement(emailCheckbox, "Email checkbox");
        Thread.sleep(1000);
        clickElement(nextBtn,"Next");
        Thread.sleep(1000);
        clickElement(acceptBtn, "Accept");
        Thread.sleep(1000);
        clickElement(exitBtn, "Exit");
        Thread.sleep(1000);
        clickElement(homeTab, "Home tab");
        Thread.sleep(1000);
        clickElement(logoutBtn, "Logout");
    }
}
