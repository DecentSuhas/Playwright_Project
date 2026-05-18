package pages;


import com.microsoft.playwright.Page;
import utils.BaseMethods;

public class CartPage  {

    private BaseMethods baseMethods;

    private String checkOut = "[data-test=\"checkout\"]";

    public CartPage(Page page){
        baseMethods = new BaseMethods(page);
    }

    public void clickCheckOut(){
        baseMethods.clickElement(checkOut);
    }
}

