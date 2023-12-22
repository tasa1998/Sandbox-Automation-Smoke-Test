package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Vehicle extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//div[text()='Year']/../../../..//input[@value='- Select -']")
    WebElement yearSelect;

    @FindBy(xpath = "//div[text()='Make']/../../../..//input[@value='- Select -']")
    WebElement makeSelect;

    @FindBy(xpath = "//div[text()='Model']/../../../..//input[@value='- Select -']")
    WebElement modelSelect;

    @FindBy(xpath = "//div[text()='Specification']/../../../..//input[@value='- Select -']")
    WebElement specificationSelect;

    @FindBy(xpath = "//div[text()='Vehicle Use']/../../../..//input[@value='- Select -']")
    WebElement vehicleUseSelect;

    @FindBy(xpath = "//div[text()='Ownership']/../../../..//input[@value='- Select -']")
    WebElement ownershipSelect;

    @FindBy(xpath = "//div[text()='Vehicle Type']/../../../..//input")
    WebElement vehicleTypeSelect;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextBtn;

    @FindBy(xpath = "//span[text()='add vehicle']")
    WebElement addVehicleBtn;

    @FindBy(xpath = "//div[text()='Original Cost']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement originalCost;

    @FindBy(xpath = "//div[text()='Stated Amount']/../../../..//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement statedAmount;

    public Vehicle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectYear(String value) throws InterruptedException {
        clickElement(yearSelect, "Year dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Year");
    }
    public void selectMake(String value) {
        clickElement(makeSelect, "Make dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Make");
    }
    public void selectModel(String value) {
        clickElement(modelSelect, "Model dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Model");
    }
    public void selectSpecification(String value) {
        clickElement(specificationSelect, "Specification dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Specification");
    }
    public void selectVehicleUse(String value) {
        clickElement(vehicleUseSelect, "VehicleUse dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "VehicleUse");
            }

    public void selectOwnership(String ownership) {
        clickElement(ownershipSelect, "Ownership dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + ownership + "']")), "Ownership");
    }

    public void selectVehicleType(String type) {
        clickElement(vehicleTypeSelect, "Vehicle Type dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + type + "']")), "VehicleType");
    }

    public void clickNextBtn(){
        clickElement(nextBtn, "next");
    }

    public void addVehicle(String originalcost, String statedamount){
        clickElement(addVehicleBtn, "Add Vehicle");
        typeText(originalCost, originalcost, "Original Cost");
        typeText(statedAmount, statedamount, "Stated Amount");
           }

    public void fillInVehiclePage(String year, String make, String model, String specification, String vehicleUse) throws InterruptedException {
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        clickNextBtn();
        clickNextBtn();
    }

    public void fillInVehiclePageRegression(String year, String make, String model, String specification, String vehicleUse, String originalcost, String statedamount, String make2, String model2, String specification2, String vehicleUse2, String type, String ownership, String ownership2) throws InterruptedException {
        selectYear(year);
        selectMake(make);
        selectModel(model);
        selectSpecification(specification);
        selectVehicleUse(vehicleUse);
        selectOwnership(ownership);
        addVehicle(originalcost, statedamount);
        selectVehicleType(type);
        selectMake(make2);
        selectModel(model2);
        selectSpecification(specification2);
        selectVehicleUse(vehicleUse2);
        selectOwnership(ownership2);
        clickNextBtn();
        clickNextBtn();
    }
}
