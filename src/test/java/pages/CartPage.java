package pages;


import com.microsoft.playwright.Page;
import utils.BaseMethods;

public class CartPage extends BaseMethods {

    private Page page;
    private String checkOut = "[data-test=\"checkout\"]";

    public CartPage(Page page) {
        super(page);
    }

    public void clickCheckOut(){
        clickElement(checkOut);
    }
}

