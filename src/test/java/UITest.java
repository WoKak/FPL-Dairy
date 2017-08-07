import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michał on 2017-08-07.
 */
public class UITest {

    public static void takeScreenshoot(WebDriver driver, String filename) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filename));
    }

    //WARNING! - in order to perform test you need to create Paths class with all necessary paths
    public static void main(String args[]) throws IOException {

        System.setProperty("webdriver.firefox.bin", Paths.pathToMozilla);
        System.setProperty("webdriver.gecko.driver", Paths.pathToGecko);
        WebDriver driver = new FirefoxDriver();

        System.out.println("------------------------------- Test \"/home\" ----------------------------------");
        HomeTest homeTest = new HomeTest();
        homeTest.homeTest(driver);
    }
}
