package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class HomePagesTests extends TestBase{

    @Test
public void openHomePageTest(){
isComponendFromPresent2();
    System.out.println(isComponendFromPresent2());
    isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
}
public boolean isComponendFromPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
}

    public boolean isComponendFromPresent2(){
        return isElementPresent2(By.cssSelector("div:nth-child(2)>div>div"));
    }

}

