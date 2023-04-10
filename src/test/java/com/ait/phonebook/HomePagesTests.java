package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePagesTests extends TestBase{

    @Test(priority = 1)
public void openHomePageTest(){
        Assert.assertTrue(app.getHome().isComponendFromPresent());
}
}

