package kg.xiaomi.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage extends BasePage <SearchPage>{

    SelenideElement markSelect = $x("//select[@class='dropdown show-tick mark-select no-border-radius']");
    SelenideElement modeSelect = $x("//select[@class='dropdown show-tick model-select no-border-radius']");
    SelenideElement generationSelect = $x("//select[@class='custom-select-search pokolenie pokolenie-select']");
    SelenideElement specSelect = $(By.id("search-submit"));

    public SearchPage SelectMark(String value){
        markSelect.selectOptionByValue(value);
        return this;
    }

    public SearchPage SelectModel(String value){
        modeSelect.selectOption(value);
        return this;
    }

    public SearchPage selectGeneration(String value){
        generationSelect.selectOptionByValue(value);
        return this;
    }

    public void searchSpec(){
        specSelect.scrollIntoCenter().shouldBe(visible).click();
        //$(By.id("search-submit")).scrollIntoCenter().click();
    }



    @Override
    public SearchPage waitForPageToBeLoaded() {
        return null;
    }
}
