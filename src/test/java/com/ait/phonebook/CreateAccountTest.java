package com.ait.phonebook;

import com.Ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()){
            app.getUser().clickOnSingOutButton();
        }
    }

    @Test (enabled = false)
    public void newUserRegistrationPositiveTest(){
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRecForm(new User().setEmail("tja@gm.de").setPassword("tja@gmde2S!"));

        app.getUser().clickOnRegButton();

        Assert.assertTrue(app.getUser().isSingOutButtonPresent());

    }

    @Test (enabled = false)
    public void newUserRegistrationNegativeTest(){
        app.getUser().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRecForm(new User().setEmail("tja@gm.de"));

        app.getUser().clickOnRegButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
