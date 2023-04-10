package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {
/*
    @Test
    public void logoAssertTest(){
        //click on logo link
        driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
        //veryfiy Logo link displayed
        Assert.assertTrue(isElementPresent2(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }
  */
    @Test
    public void aboutTest(){
        app.getHeader().click(By.xpath("//a[contains(.,'ABOUT')]"));
        Assert.assertTrue(app.getUser().isElementPresent2(By.className("about_main__2Uv5W")));

    }
    @Test
    public void homeTest(){
        app.getHeader().click(By.xpath("//a[contains(.,'ABOUT')]"));
        Assert.assertTrue(app.getUser().isElementPresent2(By.className("about_main__2Uv5W")));
        app.getHeader().click(By.xpath("//a[contains(.,'HOME')]"));
        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//h1[contains(.,'Home Component')]")));

    }

    @Test
    public void loginTest() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }
        app.getUser().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        }



    }



