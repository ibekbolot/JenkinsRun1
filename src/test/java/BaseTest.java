import com.codeborne.selenide.Configuration;
import kg.xiaomi.page.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

      // For local runs:
//    @BeforeAll
//    public static void setUp(){
//        browser = "chrome";
//        //HomePage HomePage1 = new HomePage();
//    }

    //For headless runs:
    @BeforeAll
    public static void setUp() {

        Configuration.browser = "chrome";
        Configuration.headless = true;

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        Configuration.browserCapabilities = options;
    }

}
