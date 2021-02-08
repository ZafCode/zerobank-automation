package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//div[@class='span12']/div/ul/li")
    public List<WebElement> pages;


    public void navigateTo(String pageName){
        List<WebElement> mainPages = pages;
        for (WebElement page : mainPages) {
            if(page.getText().equals(pageName)){
                page.click();
                break;
            }

        }
    }

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
