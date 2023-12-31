package pages.Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class EndOfQuoteCreation extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='retrieve reports']")
    WebElement retrieveReportsBtn;
    @FindBy(xpath = "//span[text()='save changes']")
    WebElement saveChangesBtn;
    @FindBy(xpath = "//span[text()='>>> rate quote']")
    WebElement rateQuoteBtn;
    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[3]")
    WebElement approveReferralTd;
    @FindBy(xpath = "//span[text()='>>> refer']")
    WebElement referToUWBtn;
    @FindBy(xpath = "//span[text()='>>> send note to underwriter']")
    WebElement sendNoteToUWBtn;
    @FindBy(xpath = "//span[text()='exit']")
    WebElement exitBtn;
    @FindBy(xpath = "//a[@class='x-btn os_bread_crumb_link_div x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-btn-over']/span")
    WebElement navigateQuoteBtn;
    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected x-grid-item-over']//tr[1]/td[1]/div")
    WebElement quoteNumberTable;


    public EndOfQuoteCreation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String endOfQuoteCreation(String uwComments) throws InterruptedException {
        clickElement(retrieveReportsBtn, "Retrieve Reports");
        clickElement(saveChangesBtn, "Save Changes");
        clickElement(rateQuoteBtn, "Rate quote");
        Thread.sleep(1000);
        typeText(approveReferralTd, uwComments, "UW Comments");
        clickElement(referToUWBtn, "Refer");
        Thread.sleep(2000);
        clickElement(sendNoteToUWBtn, "Send note to UW");
        clickElement(navigateQuoteBtn, "Quote navigate");
        String quoteNumber = getText(By.xpath("//table[@class='x-grid-item x-grid-item-selected x-grid-item-over']//tr[1]/td[1]/div"), "Table, quote number");
        clickElement(exitBtn, "Exit");
        return quoteNumber;

    }
}
