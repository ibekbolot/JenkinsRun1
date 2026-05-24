package ebay;

import com.codeborne.selenide.Configuration;
import kg.ebay.NewUserSignUp;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    //protected NewUserSignUp newUserSignUp;
    NewUserSignUp newUserSignUp = new NewUserSignUp();

    // For Local runs:
//    @BeforeAll
//    static void setUp(){
//        browser = "chrome";
//
//    }

    // For Headless runs:
    public void setUp() {

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
