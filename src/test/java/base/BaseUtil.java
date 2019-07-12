package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtil {

    public WebDriver driver;

    public WebDriver getDriver() {
        System.out.println("Opening the browser : Chrome");
        String chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        return driver;
    }

}
