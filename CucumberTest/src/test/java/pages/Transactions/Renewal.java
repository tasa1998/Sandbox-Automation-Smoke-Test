package pages.Transactions;


import Interfaces.IRenewal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class Renewal extends BasePage implements IRenewal {
WebDriver driver;

    @FindBy(xpath = "//span[text()='transactions']")
    WebElement newTransaction;

    @FindBy(xpath = "//span[text()='create renewal']")
    WebElement createRenewal;

    @FindBy(xpath = "//span[text()='OK']")
    WebElement ok;

    @FindBy(xpath = "//span[text()='policy image']")
    WebElement policyImage;

    @FindBy(xpath = "//span[text()='>>> change summary']")
    WebElement changeSummaryBtn;

    @FindBy(xpath = "//span[text()='>>> renewal premium']")
    WebElement renewalPremiumBtn;

    @FindBy(xpath = "//span[text()='>>> next']")
    WebElement NextBtn;

    @FindBy(xpath = "//span[text()='>>> process']")
    WebElement processBtn;

    @FindBy(xpath = "//span[text()='exit']")
    WebElement exitBtn;

    @FindBy(xpath = "//span[text()='Renewal']")
    WebElement hyperLink;




    public Renewal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void startRenewal(){
        clickElement(newTransaction, "Transactions");
        clickElement(createRenewal, "CreateRenewal");
        clickElement(ok, "Ok");
        Assert.assertEquals(getText(By.xpath("//span[contains(text(),'Renewal')]/../../following-sibling::td[10]/div"),"Renewal Created"),"Created");
        clickElement(hyperLink, "Renewal");
        clickElement(policyImage, "PolicyImage");
        clickElement(changeSummaryBtn, "ChangeSummary");
        clickElement(renewalPremiumBtn, "RenewalPremium");
        clickElement(NextBtn, "Next");
        clickElement(NextBtn, "Next");
    }

    @Override
    public void processRenewal() {
        clickElement(processBtn, "Process");
        clickElement(ok, "Ok");
        clickElement(exitBtn, "Exit");
        clickElement(newTransaction, "Transactions");
        Assert.assertEquals(getText(By.xpath("//span[contains(text(),'Renewal')]/../../following-sibling::td[10]/div"),"Renewal Processed"),"Processed");
    }
}
