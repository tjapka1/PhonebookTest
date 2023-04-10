package com.Ait.phonebook.FW;

import com.Ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillLoginRecForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());

        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void clickOnSingOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isSingOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnRegButton() {
        click(By.name("registration"));
    }

    public boolean isLoginRegFormPresent() {
        return isElementPresent(By.className("login_login__3EHKB"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }
}
