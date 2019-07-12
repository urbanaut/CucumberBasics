package features.step_definitions;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    private BaseUtil base;
    public String chromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest() {
        System.out.println("Opening the browser : Chrome");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        base.driver = new ChromeDriver();
    }

    @After
    public void tearDownTest(Scenario scenario) {
        if(scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.driver.close();
    }
}
