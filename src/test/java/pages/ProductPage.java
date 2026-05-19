package pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import utils.BaseMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage {

    private BaseMethods baseMethods;
    private final String addToCart = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    private final String shoppingCart = "[data-test=\\\"shopping-cart-link\\\"]";

    public ProductPage(Page page){
        baseMethods = new BaseMethods(page);
    }

    public void verifyPageTitle(){
        String title = baseMethods.getPageTitle();
        Assert.assertEquals(title, "Swag Labs");
    }


}
