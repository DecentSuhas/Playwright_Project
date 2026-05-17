package pages;

import base.BaseTest;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage extends BaseTest {

    private Page page;
    private String addToCart = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    private String shoppingCart = "[data-test=\\\"shopping-cart-link\\\"]";



    public ProductPage(Page page){
        this.page = page;
    }

    public void verifyPageTitle(){
        String pageTitle = page.title();
        assertThat(page).hasTitle("Sauce");
    }


}
