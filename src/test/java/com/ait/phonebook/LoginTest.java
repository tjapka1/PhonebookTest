package com.ait.phonebook;

import com.Ait.phonebook.FW.DataProviderUser;
import com.Ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }
    }
    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest(){
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRecForm(new User().setEmail("tja@gm.de").setPassword("tja@gmde2S!"));

        app.getHeader().click(By.name("login"));

        Assert.assertTrue(app.getUser().isSingOutButtonPresent());


    }

    @Test(enabled = false)
    public void loginRegisteredUserNegativeTest(){
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRecForm(new User().setEmail("tja@gm2.de").setPassword("tja@gmde2S!"));

        app.getHeader().click(By.name("login"));
        app.getHeader().pause(2000);
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test(enabled = false, dataProvider = "LogFromCSVNeg", dataProviderClass = DataProviderUser.class)
    public void loginRegisteredUserNegativeCSVTest(User user){
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRecForm(user);

        app.getHeader().click(By.name("login"));
        app.getHeader().pause(12000);
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
