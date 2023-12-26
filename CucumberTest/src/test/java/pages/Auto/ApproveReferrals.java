package pages.Auto;

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
}
