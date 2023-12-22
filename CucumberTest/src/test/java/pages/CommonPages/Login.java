package pages.CommonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class Login extends BasePage {
    WebDriver driver;
    public Login(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'PARTNER NUMBER')]/../../../..//input")
    WebElement partnerNumber;

    @FindBy(xpath = "//div[contains(text(),'USERNAME')]/../../../..//input")
    WebElement username;

    @FindBy(xpath = "//div[contains(text(),'PASSWORD')]/../../../..//input")
    WebElement password;

    @FindBy(xpath = "//span[contains(text(),'login')]")
    WebElement loginBtn;

    public void login(){
        typeText(partnerNumber, "0", "Partner Number Field");
        typeText(username, "nastasjadamjanac", "Username Field");
        typeText(password, "Oneshield123", "Password Field");
        clickElement(loginBtn, "Login Button");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='os-title-bar-greet']")).getText(),"Welcome");
    }
}
