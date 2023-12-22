package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Underwriting extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[5]")
    WebElement uwCommentsField;

    @FindBy(xpath = "//table[@class='x-grid-item x-grid-item-selected']//tr//td[6]/div")
    WebElement overriddenSelect;

    @FindBy(xpath = "//span[text()='>>> accept']")
    WebElement acceptBtn;

    @FindBy(xpath = "//span[text()='OK']")
    WebElement acceptMsgBtn;

    @FindBy(xpath = "//label[text()='Email']")
    WebElement emailCheckbox;
    public Underwriting(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUWComments(String value){
        typeText(uwCommentsField,value,"UW Comments");
    }
    public void selectOverridden(String value) {
        clickElement(overriddenSelect, "overridden dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "overridden");
    }

    public void clickAcceptBtn() {
        clickElement(acceptBtn, "Accept");
    }
    public void clickAcceptMsgBtn() {
        clickElement(acceptMsgBtn, "Accept Msg");
    }
    public void clickEmailCheckbox() {
        clickElement(emailCheckbox, "Email Checkbox");
    }

    public void fillInUWQuestions(String comment, String overridden){
        enterUWComments(comment);
        selectOverridden(overridden);
        clickAcceptBtn();
        clickAcceptMsgBtn();
        clickEmailCheckbox();
    }

}
