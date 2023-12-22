package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Policy extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Billing Method']/../../../..//input")
    WebElement billingMethodSelect;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextBtn;


    public Policy(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void billingMethod(String method) {
        clickElement(billingMethodSelect, "Billing method dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + method + "']")), "Billing method");
    }

    public void fillInPolicyPageCheckboxes(String providedMaterial, String existingDamage) throws InterruptedException {
        Thread.sleep(2000);
        clickElement(driver.findElement(By.xpath("//div[text()='Has anyone knowingly provided material, false, or misleading information ']/../../../..//label[text()='" + providedMaterial + "']/../span")), "Provided Material");
        Thread.sleep(2000);
        clickElement(driver.findElement(By.xpath("//div[text()='Does any vehicle have any existing damage? (excluding glass damage)']/../../../..//label[text()='" + existingDamage + "']/../span")), "Existing Damage");
    }

    public void clickNextBtn(){
        clickElement(nextBtn, "Next");
    }

    public void fillInPolicyPage(String method,String providedMaterial, String existingDamage) throws InterruptedException {
        billingMethod(method);
        fillInPolicyPageCheckboxes(providedMaterial,existingDamage);
        clickNextBtn();
    }
}
