package pages.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Logout extends BasePage {

    WebDriver driver;
    @FindBy(xpath = "//span[contains(text(), 'logout')]")
    WebElement logoutBtn;
    @FindBy(xpath = "//span[text()='OK']")
    WebElement okButton;
    public Logout(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logout() throws InterruptedException {
        clickElement(logoutBtn, "Logout");
        Thread.sleep(1000);
        clickElement(okButton, "COnfirm");
    }
}
