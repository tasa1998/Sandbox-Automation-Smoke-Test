package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Coverage extends BasePage {

    @FindBy(xpath = "//div[text()='Policy Coverage Option']/../../../..//input")
    WebElement policyCoverageOptionSelect;

    @FindBy(xpath = "//span[text()='>>> rate quote']")
    WebElement rateBtn;

    WebDriver driver;
    public Coverage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPolicyCoverageOption(String value) {
        clickElement(policyCoverageOptionSelect, "Policy Coverage Option dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Policy Coverage Option");
    }

    public void clickRateBtn(){
        clickElement(rateBtn, "rate");
    }

    public void fillInCoveragePage(String policyCoverageOption){
        selectPolicyCoverageOption(policyCoverageOption);
        clickRateBtn();
    }
}
