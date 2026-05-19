package xiaomi;

import com.codeborne.selenide.Selenide;
import kg.xiaomi.page.HomePage;
import kg.xiaomi.page.SearchPage;
import kg.utils.file.ConfigurationManager;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


//public class DemoTest{ //extends BaseTest {
//
//    HomePage homePage = new HomePage();
//    SearchPage searchPage = new SearchPage();
//
//    @Test
//    void demoTest(){
//        open("https://mashina.kg/");
//    }
//
//    @Test
//    void searchBtnTest(){
//        //Selenide.open(ConfigurationManager.getBaseConfig().baseUrl());
//        homePage.waitForPageToBeLoaded();
//        homePage.goToSearchPage();
//        searchPage.SelectMark("99"); //lexus
//        searchPage.SelectModel("LX");
//        searchPage.selectGeneration("300000212");
//        Selenide.sleep(2000);
//        searchPage.searchSpec();
//        Selenide.sleep(6000);
//
//    }
//}
