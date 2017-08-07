import org.openqa.selenium.*;

import java.io.IOException;


/**
 * Created by Michał on 2017-08-07.
 */
public class HomeTest {

    public void homeTest(WebDriver driver) throws IOException{

        driver.get("http://localhost:8080/home");

        //Test 0 - czy jest to strona główna?

        WebElement homePageId = driver.findElement(By.id("homePage"));
        UITest.takeScreenshoot(driver, "home0.png");


        //Test 1 - czy link na stronie głównej przekierowuje do logowania?

        WebElement link = driver.findElement(By.tagName("a"));
        link.click();

        WebElement loginPageId = driver.findElement(By.id("loginPage"));
        UITest.takeScreenshoot(driver, "home1.png");

    }
}
