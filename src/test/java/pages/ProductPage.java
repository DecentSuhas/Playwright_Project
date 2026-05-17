package pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import utils.BaseMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage extends BaseMethods {

    private final String addToCart = "[data-test=\"add-to-cart-sauce-labs-backpack\"]";
    private final String shoppingCart = "[data-test=\\\"shopping-cart-link\\\"]";

    public ProductPage(Page page) {
        super(page);
    }

    public void verifyPageTitle(){
        String title = getPageTitle();
        Assert.assertEquals(title, "Sauce Labs");
    }


}
