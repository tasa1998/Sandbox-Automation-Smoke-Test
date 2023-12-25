package pages.Auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class EndOfQuoteCreation extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='>>> rate quote']")
    WebElement rateQuoteBtn;
    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[3]")
    WebElement approveReferralTd;
    @FindBy(xpath = "//span[text()='>>> refer']")
    WebElement referToUWBtn;


    public EndOfQuoteCreation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void endOfQuoteCreation(String uwComments) throws InterruptedException {
        clickElement(rateQuoteBtn, "Rate quote");
        Thread.sleep(1000);
        typeText(approveReferralTd, uwComments, "UW Comments");
        clickElement(referToUWBtn, "Refer");

    }
}
