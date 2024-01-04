package pages.Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Diary extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='policies']")
    WebElement policiesTab;
    @FindBy(xpath = "//span[text()='diary']")
    WebElement diaryTab;

    @FindBy(xpath = "//span[text()='new entry']")
    WebElement newEntryBtn;

    @FindBy(xpath = "//div[text()='Type']/../../../..//label[text()='tasktype']/../span")
    WebElement taskTypeRadio;

    @FindBy(xpath = "//div[text()='Category']/../../../..//input")
    WebElement categorySelect;

    @FindBy(xpath = "//div[text()='Sub Category']/../../../..//input")
    WebElement subCategorySelect;

    @FindBy(xpath = "//div[text()='To']/../../../..//input")
    WebElement receiverField;

    @FindBy(xpath = "//div[text()='Subject']/../../../..//input")
    WebElement subjectField;

    @FindBy(xpath = "//textarea")
    WebElement descriptionField;

    @FindBy(xpath = "//span[text()='>>> Save Changes']")
    WebElement saveBtn;

    public Diary(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createDiary(String policyNumber, String category, String subCategory, String email, String subject, String description) throws InterruptedException {
        clickElement(policiesTab, "Policies tab");
        Thread.sleep(1000);
        clickElement(driver.findElement(By.xpath("//span[contains(text(),'"+policyNumber+"')]")), "Policy number");
        Thread.sleep(1000);
        clickElement(diaryTab, "Diary tab");
        Thread.sleep(1000);
        clickElement(newEntryBtn,"New entry");
        Thread.sleep(1000);
        clickElement(taskTypeRadio, "Task type");
        clickElement(categorySelect, "Category dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + category + "']")), "Category");
        clickElement(subCategorySelect, "SubCategory dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + subCategory + "']")), "SubCategory");
        typeText(receiverField, email, "Receiver");
        typeText(subjectField, subject, "Subject");
        typeText(descriptionField, description, "Description");
        clickElement(saveBtn, "Save");


    }
}
