package pages.CommonPages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class QuoteRegistration extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Producer']/../../../..//input")
    WebElement producer;
    @FindBy(xpath = "//div[text()='Effective Date']/../../../..//input")
    WebElement effDate;
    @FindBy(xpath = "//div[text()='Program']/../../../..//input")
    WebElement program;
    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextBtn;


    public QuoteRegistration(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInQuoteRegistration(String producerName, String effDate1, String program1){
        clickElement(producer,"Producer Dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='"+producerName+"']")), "Producer Name");
        typeText(effDate,effDate1,"Effective Date Field");
        clickElement(program,"Program Dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='"+program1+"']")), "Program Type");
        clickElement(nextBtn,"Next Button");
    }
}
