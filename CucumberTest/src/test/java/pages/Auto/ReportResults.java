package pages.Auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ReportResults extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='retrieve reports']")
    WebElement retreiveReportsBtn;
    @FindBy(xpath = "//span[text()='save changes']/../../..")
    WebElement saveChanges;

    public ReportResults(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickRetreiveReports() {
        clickElement(retreiveReportsBtn, "next");
        clickElement(saveChanges,"Save changes");
    }
}
