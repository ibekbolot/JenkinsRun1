package kg.ebay;

public abstract class BasePage<T extends BasePage>{

    public abstract T waitForPageToBeLoaded();


}
