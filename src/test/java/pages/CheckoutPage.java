package pages;
import com.microsoft.playwright.Page;
import utils.BaseMethods;

public class CheckoutPage {

    private BaseMethods baseMethods;
    private final String firstNameField = "[data-test=\"firstName\"]";
    private final String lastNameField = "[data-test=\"lastName\"]";
    private final String postalCodeField = "[data-test=\"postalCode\"]";
    private final String continueButton = "[data-test=\"continue\"]";
    private final String finishButton = "[data-test=\"Finish\"]";
    private final String successMessage = "[data-test=\"complete-header\"]";

    public CheckoutPage(Page page){
        baseMethods = new BaseMethods(page);
    }

    public void enterFirstName(String firstName){
        baseMethods.enterTextToInput(firstNameField, firstName );
    }

    public void enterLastName(String lastName){
        baseMethods.enterTextToInput(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode){
        baseMethods.enterTextToInput(postalCodeField, postalCode);
    }

    public void clickContinueButton(){
        baseMethods.clickElement(continueButton);
    }

    public void clickFinishButton(){
        baseMethods.clickElement(finishButton);
    }

    public void clickSuccessButton(){
        baseMethods.clickElement(successMessage);
    }

    public void enterCustomerDetails(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinueButton();
        clickFinishButton();
        clickSuccessButton();
    }

}
