package pages;

import base.BaseTest;
import com.microsoft.playwright.Page;

public class ProductPage extends BaseTest {

    private Page page;
    private String addToCart = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    private String shoppingCart = "[data-test=\\\"shopping-cart-link\\\"]";



    public void ProductPage(Page page){
        this.page = page;
    }


}
