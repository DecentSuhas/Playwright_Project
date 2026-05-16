package pages;

import base.BaseTest;
import com.microsoft.playwright.Page;

public class CartPage extends BaseTest {

    private Page page;
    private String checkOut = "[data-test=\"checkout\"]";

    public void CartPage(Page page){
        this.page = page;

    }
}
