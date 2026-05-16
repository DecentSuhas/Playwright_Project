package pages;

import base.BaseTest;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BaseTest {

    private Page page;
    private String firstName = "[data-test=\"firstName\"]";
    private String lastName = "[data-test=\"lastName\"]";
    private String postalCode = "[data-test=\"postalCode\"]";
    private String continueButton = "[data-test=\"continue\"]";
    private String finishButton = "[data-test=\"Finish\"]";
    private String successMessage = "[data-test=\"complete-header\"]";

    public void CheckoutPage(Page page){
        this.page = page;
    }
}
