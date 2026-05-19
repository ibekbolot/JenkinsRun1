package ebay;

import kg.ebay.NewUserSignUp;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.browser;

public class BaseTest {

    //protected NewUserSignUp newUserSignUp;
    NewUserSignUp newUserSignUp = new NewUserSignUp();

    @BeforeAll
    static void setUp(){
        browser = "chrome";

    }
}
