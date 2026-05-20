package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitUtils {

    private Page page;

    public WaitUtils(Page page){

        this.page = page;
    }

    public void waitForVisible(String locator){

        page.locator(locator)
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    }

    public void waitForHidden(String locator){

        page.locator(locator)
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    public void waitForPageLoad(){

        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void waitForURL(String url){

        page.waitForURL(url);
    }
}
