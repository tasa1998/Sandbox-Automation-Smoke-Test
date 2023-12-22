package pages.HomePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class PolicyInformation extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Billing Method']/../../../..//input")
    WebElement billingMethodSelect;
    @FindBy(xpath = "//div[text()='Program Type']/../../../..//input")
    WebElement programTypeSelect;


    public PolicyInformation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void billingMethod(String method) {
//        typeText(billingMethod, method, "");
        clickElement(billingMethodSelect, "Billing method dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + method + "']")), "Billing method");
    }

    public void programType(String type) throws InterruptedException {
//        typeText(programType, type, "");
        clickElement(programTypeSelect, "Program type dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + type + "']")), "Program type");
        clickElement(programTypeSelect, "Program type dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + type + "']")), "Program type");
    }

    public void isChildOrDayCareRunOutOfTheHome(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is Child or Day Care run out of the home?']/../../../..//label[text()='" + yesNo + "']")), "Child or Day Care");
    }

    public void anyUndergroundOilOrStorageTanks(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Any underground oil or storage tanks?']/../../../..//label[text()='" + yesNo + "']")), "Underground oil or storage tanks");
    }

    public void isTheResidenceRentedMoreThan10Weeks(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is the residence rented more than 10 weeks per year?']/../../../..//label[text()='" + yesNo + "']")), "Residence rented");
    }

    public void isTheResidenceVacant(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Is the residence vacant?']/../../../..//label[text()='" + yesNo + "']")), "Residence vacant");
    }

    public void areThereAnyAnimalsOrExoticPetsKeptOnThePremises(String yesNo) {
        clickElement(driver.findElement(By.xpath("//div[text()='Are there any animals or exotic pets kept on the premises?']/../../../..//label[text()='" + yesNo + "']")), "Animals or exotic pets");
    }

    public void fillInPolicyInformation(String billingMethod, String programType, String runOutOfHome, String undergroundOil, String rented, String vacant, String animalsAndExoticPets) throws InterruptedException {
        billingMethod(billingMethod);
        programType(programType);
        isChildOrDayCareRunOutOfTheHome(runOutOfHome);
        anyUndergroundOilOrStorageTanks(undergroundOil);
        isTheResidenceRentedMoreThan10Weeks(rented);
        isTheResidenceVacant(vacant);
        areThereAnyAnimalsOrExoticPetsKeptOnThePremises(animalsAndExoticPets);

    }

}
