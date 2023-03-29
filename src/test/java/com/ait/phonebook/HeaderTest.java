package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderTest extends TestBase {

    @Test
    public void aboutTest(){
        driver.findElement(By.xpath("//a[contains(.,'ABOUT')]")).click();
        Assert.assertTrue(isElementPresent2(By.className("about_main__2Uv5W")));

    }
    @Test
    public void homeTest(){
        driver.findElement(By.xpath("//a[contains(.,'ABOUT')]")).click();
        Assert.assertTrue(isElementPresent2(By.className("about_main__2Uv5W")));
        driver.findElement(By.xpath("//a[contains(.,'HOME')]")).click();
        Assert.assertTrue(isElementPresent2(By.xpath("//h1[contains(.,'Home Component')]")));

    }

    @Test
    public void loginTest() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));

        }



    }



