package pages.Transactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class RollforwardTransactions extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='>>> workflowdriven roll-fwd']")
    WebElement rollFwdBtn;
    public RollforwardTransactions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void rollfwd() throws InterruptedException {
        clickElement(rollFwdBtn, "Roll fwd btn");
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath("//div[contains(text(),'Cancellation')]/../following-sibling::td[8]/div"),"Cancellation Processed"),"Processed");
        clickElement(rollFwdBtn, "Roll fwd btn");
        Thread.sleep(1000);
        Assert.assertEquals(getText(By.xpath("//span[contains(text(),'Reinstatement')]/../../following-sibling::td[10]/div"),"Reinstatement Processed"),"Processed");
    }
}
