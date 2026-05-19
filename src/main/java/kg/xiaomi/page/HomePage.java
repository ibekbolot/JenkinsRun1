package kg.xiaomi.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage <HomePage> {
    //SelenideElement mashinaKgLogo = $x("//img[@imgfield='tn_img_1725391054689']");
    SelenideElement search = $x("//div[@class  = 'input-group-btn find-btn']");

    //@Override
    public HomePage waitForPageToBeLoaded() {
        search.shouldBe(visible);
        return Selenide.page(this);
    }

    public void goToSearchPage(){
        search.shouldBe(visible).click();
        Selenide.page(SearchPage.class);
    }
}
