package kg.ebay;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewUserSignUp {
    SelenideElement name = $("[data-qa=\"signup-name\"]");
    SelenideElement email = $("[data-qa=\"signup-email\"]");
    SelenideElement btn = $("[data-qa=\"signup-button\"]");
    SelenideElement maleRadioBtn = $("label[for='id_gender1']");
    SelenideElement femaleRadioBtn = $("label[for='id_gender2']");
    SelenideElement password = $("[data-qa=\"password\"]");
    SelenideElement bDay = $("#days");
    SelenideElement bMonth = $("#months");
    SelenideElement bYear = $("#years");


    public NewUserSignUp enterName(String userName){
        name.shouldBe(visible).click();
        name.sendKeys(userName);
        return this;
    }

    public NewUserSignUp enterEmail (String userEmail){
        email.shouldBe(visible).click();
        email.sendKeys(userEmail);
        return this;
    }

    public void clickSignUpBtn(){
        btn.shouldBe(visible).click();
    }

    public NewUserSignUp clickGenderRadioBtn(String gender){
        if(gender.equalsIgnoreCase("male")){
            maleRadioBtn.shouldBe(visible).click();
        }
        else{
            femaleRadioBtn.shouldBe(visible).click();
        }
        return this;
    }

    public NewUserSignUp passwordSet (String pass){
        password.scrollTo().shouldBe(visible).click();
        password.sendKeys(pass);
        return this;
    }

    public NewUserSignUp birthDay (String day){
        bDay.shouldBe(visible).click();
        bDay.scrollTo().selectOptionByValue(day);
        return this;
    }

    public NewUserSignUp birthMonth (String month){
        bMonth.shouldBe(visible).click();
        bMonth.selectOptionByValue(month);
        return this;
    }

    public NewUserSignUp birthYear (String year){
        bYear.shouldBe(visible).click();
        bYear.selectOptionByValue(year);
        return this;
    }
}
