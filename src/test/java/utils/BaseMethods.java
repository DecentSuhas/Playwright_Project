package utils;

import com.microsoft.playwright.Page;

public class BaseMethods {

    private Page page;

    public BaseMethods(Page page){
        this.page = page;
    }

    public void clickElement(String webElement){
        page.click(webElement);
    }

    public void enterTextToInput(String webElement, String inputText){
        page.fill(webElement, inputText);
    }

    public String getElementText(String webElement){
        return page.locator(webElement).innerText();

    }

    public String getPageTitle(){
        return page.title();
    }



}
