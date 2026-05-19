package xiaomi;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AmazonComTest {//extends BaseTest{

    @Test
    void AmazonTest() throws InterruptedException{
        open("https://Amazon.com");
        Thread.sleep(5000);
        $(By.id("twotabsearchtextbox")).sendKeys("iPhone" + Keys.RETURN);
        Thread.sleep(3000);

        // Click AT&T filter
        $$("ul[id^='filter-p_n_g'] li a.s-navigation-item")
                .findBy(text("AT&T"))
                .scrollIntoView(false)
                .click();
        Thread.sleep(5000);

        // Page is now filtered by AT&T — Cricket filter should still be in the sidebar
        // Re-fetch the collection fresh and click Cricket on top of AT&T
        $$("ul[id^='filter-p_n_g'] li a.s-navigation-item")
                .findBy(text("Cricket"))
                .scrollIntoView("{block: 'center'}")
                .click();
        Thread.sleep(5000);

        // original class code
//        ElementsCollection carriers = $$("ul[id^='filter-p_n_g'] li a.s-navigation-item");
//
//        for (SelenideElement carrier : carriers) {
//            carrier.scrollTo().click();
//            Thread.sleep(3000);
//        }

        // Code given by Claude to cycle by pressing all buttons.
        // Get the total count ONCE before the loop
//        int totalCarriers = $$("ul[id^='filter-p_n_g'] li a.s-navigation-item").size();
//
//        for (int i = 0; i < totalCarriers; i++) {
//            // Re-fetch the collection fresh on every iteration
//            ElementsCollection carriers = $$("ul[id^='filter-p_n_g'] li a.s-navigation-item");
//
//            if (i >= carriers.size()) break; // safety guard
//
//            carriers.get(i).scrollTo().click();
//            Thread.sleep(6000);
//
//            // Navigate back to the results page to restore the filter list
//            back();
//            Thread.sleep(6000);
//        }

        $$("ul[id^='filter-p_n_g'] li a.s-navigation-item")
                .findBy(text("Cricket"))
                .scrollIntoView("{block: 'center'}");
        Thread.sleep(6000);

    }
}
