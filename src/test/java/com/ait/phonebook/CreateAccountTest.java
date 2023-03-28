package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))){
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
    }
    @Test
    public void newUserRegistrationTest(){
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("tja@gm.de");

        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("tja@gmde2S!");

        driver.findElement(By.name("registration")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

    }
}
