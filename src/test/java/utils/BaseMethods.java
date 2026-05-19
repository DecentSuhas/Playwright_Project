package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseMethods {

    private Page page;
    private static final Logger logger = LoggerFactory.getLogger(BaseMethods.class);

    public BaseMethods(Page page) {
        this.page = page;
    }

    public void clickElement(String webElement){

        try {
            Locator locator = page.locator(webElement);
            locator.waitFor();
            locator.click();
            logger.info("Clicked element: {}", webElement);

        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot();
            logger.error("Failed to click element: {}", webElement);
            logger.error( "Screenshot captured at: {}", screenshotPath);
            throw new RuntimeException(e);
        }
    }


    public void enterTextToInput(String webElement, String inputText){

        try {
            Locator locator = page.locator(webElement);
            locator.waitFor();
            locator.fill(inputText);
            logger.info("Entered text '{}' into element '{}'", inputText,webElement);

        } catch (Exception e) {
            logger.info("Failed to enter text '{}' into element '{}'", inputText,webElement);
            throw new RuntimeException(e);
        }
    }


    public String getElementText(String webElement){
        try{
            Locator locator = page.locator(webElement);
            locator.waitFor();
            return locator.innerText();
        } catch(Exception e){
            logger.info("Failed to get the element text {}",webElement);
            throw new RuntimeException(e);
        }

    }

    public String getPageTitle(){
        return page.title();
    }

    public boolean buttonCheckedState(String webElement){
        return page.locator(webElement).isChecked();
    }

    public void checkCheckBox(String webElement){
        try {
            Locator locator = page.locator(webElement);
            locator.waitFor();
            locator.click();
            logger.info("Checked the checkbox: {}", webElement);

        } catch (Exception e) {
            logger.info("Failed to check the checkbox: {}", webElement);
            throw new RuntimeException(e);
        }
    }

    public void selectOptionByValue(String webElement, String value){
        page.locator(webElement).selectOption(value);
    }

    public void doubleClick(String webElement){
        page.locator(webElement).dblclick();
    }

    public void rightClick(String webElement){
        page.locator(webElement).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }
    
    public void hoverOnElement(String webElement){
        page.locator(webElement).hover();
    }

    public void dragAndDrop(String webElementFrom, String webElementTo){
        page.locator(webElementFrom).dragTo(page.locator(webElementTo));
    }
}
