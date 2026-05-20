package utils;

import com.microsoft.playwright.Page;
import org.testng.Assert;

public class AssertionUtils {

    private Page page;

    public AssertionUtils(Page page){

        this.page = page;
    }

    public void verifyText(String locator, String expectedText){

        String actualText = page.locator(locator).innerText();

        Assert.assertEquals(actualText, expectedText, "Text mismatch");
    }

    public void verifyVisible(String locator){

        Assert.assertTrue(page.locator(locator).isVisible(), "Element not visible");
    }

    public void verifyURL(String expectedURL){

        Assert.assertEquals(page.url(), expectedURL, "URL mismatch");
    }

    public void verifyTitle(String expectedTitle){
        Assert.assertEquals(page.title(), expectedTitle);
    }
}
