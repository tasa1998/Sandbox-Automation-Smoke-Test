package pages.Transactions;

import Interfaces.IGenerateDocuments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class GenerateDocuments extends BasePage implements IGenerateDocuments {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[text()='New Business']")
    WebElement newBusiness;

    @FindBy(xpath = "//span[text()='documents']")
    WebElement documents;


    public GenerateDocuments(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void GenerateDocuments() {
        clickElement(transactions, "Transactions");
        clickElement(newBusiness, "New Business");
        clickElement(documents, "Documents");
    }
}
