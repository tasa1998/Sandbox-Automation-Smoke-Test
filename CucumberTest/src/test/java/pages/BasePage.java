package pages;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasePage {

    WebDriver driver;
    int waitTime = 30;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement webElement, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).click().build().perform();
            System.out.println("Clicked " + text);
        } catch (StaleElementReferenceException e) {
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).click().build().perform();
            System.out.println("Clicked " + text);
        }
    }

    public void typeText(WebElement element, String text, String log) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            System.out.println("Typed: " + text + " into " + log);
        } catch (StaleElementReferenceException e) {
            element.clear();
            element.sendKeys(text);
            System.out.println("Typed: " + text + " into " + log);
        }
    }

    public void selectElementByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public String getText(By by, String log) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
            System.out.println("Get text from: " + log);
            return driver.findElement(by).getText();

        } catch (StaleElementReferenceException e) {
            System.out.println("Get text from: " + log);
            return driver.findElement(by).getText();
        }
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

     public void takeScreenshot (String fileName) throws IOException {
         File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(file, new File("results/screenshots/"+fileName+".png"));
     }
     public void reportScreenshot(String fileName, String desc) throws IOException {
        takeScreenshot(fileName);
        Path path = Paths.get("results/screenshots/"+fileName+".png");
         InputStream is = Files.newInputStream(path);
         Allure.addAttachment(desc, is);
     }

}
