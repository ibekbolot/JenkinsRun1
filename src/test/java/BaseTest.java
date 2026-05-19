import kg.xiaomi.page.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    @BeforeAll
    public static void setUp(){
        browser = "chrome";
        //HomePage HomePage1 = new HomePage();
    }
}
