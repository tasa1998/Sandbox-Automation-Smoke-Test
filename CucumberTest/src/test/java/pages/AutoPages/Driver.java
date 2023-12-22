package pages.AutoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class Driver extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Gender']/../../../..//input")
    WebElement genderSelect;

    @FindBy(xpath = "//div[text()='Marital Status']/../../../..//input")
    WebElement maritalStatusSelect;

    @FindBy(xpath = "//div[text()='License Status']/../../../..//input")
    WebElement licenseStatusSelect;

    @FindBy(xpath = "//div[text()='Occupation']/../../../..//input")
    WebElement occupationSelect;

    @FindBy(xpath = "//div[text()='License State/Province']/../../../..//input")
    WebElement stateProvinceSelect;

    @FindBy(xpath = "//div[text()='License Year']/../../../..//input")
    WebElement licenseYearField;

    @FindBy(xpath = "//div[text()='License Number']/../../../..//input")
    WebElement licenseNumberField;

    @FindBy(xpath = "//span[text()='next']")
    WebElement nextBtn;

    @FindBy(xpath = "//span[text()='Add']")
    WebElement addIncident;

    @FindBy(xpath = "//input[@class='x-form-field x-form-text x-form-text-default ']")
    WebElement incidentDate;

    public Driver(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGender(String value) {
        clickElement(genderSelect, "Gender dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Gender");
    }

    public void selectMaritalStatus(String value) {
        clickElement(maritalStatusSelect, "Marital Status dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Marital Status");
    }

    public void fillInCertificateCheckbox(String certificate){
       clickElement(driver.findElement(By.xpath("//div[text()='SR-22/ Certificate of Insurance Required?']/../../../..//label[text()='" + certificate + "']")), "Certificate Required");
    }

    public void selectLicenseStatus(String value) {
        clickElement(licenseStatusSelect, "License Status dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "License Status");
    }
    public void selectOccupation(String value) {
        clickElement(occupationSelect, "Occupation dropdown");
        clickElement(driver.findElement(By.xpath("//li[text()='" + value + "']")), "Occupation");
    }

    public void enterLicenseYear(String value){
        typeText(licenseYearField,value,"License Year");
    }
    public void enterLicenseNumber(String value){
        typeText(licenseNumberField,value,"License Number");
    }

    public void enterIncident(String incidentdate){
        clickElement(addIncident, "Add Incident");
        typeText(incidentDate,incidentdate,"Set Incident Date");
    }

    public void clickNextBtn() {
        clickElement(nextBtn, "next");
    }

    public void fillInDriverPage(String gender, String maritalStatus, String certificate, String licenseStatus, String occupation, String licenseYear, String licenseNumber){
        selectGender(gender);
        selectMaritalStatus(maritalStatus);
        fillInCertificateCheckbox(certificate);
        selectLicenseStatus(licenseStatus);
        selectOccupation(occupation);
        enterLicenseYear(licenseYear);
        enterLicenseNumber(licenseNumber);
        clickNextBtn();
    }

    public void fillInDriverPageRegression(String gender, String maritalStatus, String certificate, String licenseStatus, String occupation, String licenseYear, String licenseNumber, String incidentdate){
        selectGender(gender);
        selectMaritalStatus(maritalStatus);
        fillInCertificateCheckbox(certificate);
        selectLicenseStatus(licenseStatus);
        selectOccupation(occupation);
        enterLicenseYear(licenseYear);
        enterLicenseNumber(licenseNumber);
        enterIncident(incidentdate);
        clickNextBtn();
    }
}
