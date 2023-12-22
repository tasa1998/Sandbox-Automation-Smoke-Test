package steps;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    WebDriver driver;
    DriverManager driverManager;

    public void setup(String browser, int wait) {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public void basequit() {
        driverManager.quit();
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
