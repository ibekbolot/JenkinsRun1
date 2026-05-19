package ebay;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class NewUserSignUp extends BaseTest{

    @Test
    void newUserSignUp() throws InterruptedException {
        open("https://automationexercise.com/login");
        newUserSignUp.enterName("sam").enterEmail("sam@cat.com").clickSignUpBtn();
        Thread.sleep(5000);
        newUserSignUp.clickGenderRadioBtn("female").passwordSet("pass123").birthDay("1").birthMonth("2").birthYear("1998");
        Thread.sleep(5000);



    }
}
