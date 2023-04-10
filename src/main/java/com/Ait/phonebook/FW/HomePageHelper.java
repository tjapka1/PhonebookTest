package com.Ait.phonebook.FW;

import com.Ait.phonebook.FW.ApplicationManager;
import com.Ait.phonebook.FW.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isComponendFromPresent(){
            return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isComponendFromPresent2(){
        try {
            ApplicationManager.driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }
}
