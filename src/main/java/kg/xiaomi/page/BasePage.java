package kg.xiaomi.page;

public abstract class BasePage <T extends BasePage>{

    public abstract T waitForPageToBeLoaded();


}
