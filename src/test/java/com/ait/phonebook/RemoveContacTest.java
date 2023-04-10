package com.ait.phonebook;

import com.Ait.phonebook.model.Contact;
import com.Ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContacTest extends TestBase {


    //precondition: login, add contact
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getUser().clickOnSingOutButton();
        }else {
            app.getHeader().clickOnLoginLink();
            app.getUser().fillLoginRecForm(new User().setEmail("tja@gm.de").setPassword("tja@gmde2S!"));
            app.getHeader().click(By.name("login"));

            app.getContact().clickOnAddLink();
            app.getContact().addContact(new Contact().setName("Karl").setSurName( "Adam").setPhone("1234567890").setEmail("adam@gm.co").setAddress("Koblenz").setDesc("torwart"));
            app.getContact().clickOnSaveButton();
        }
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        //check Contact is removed
        Assert.assertEquals(sizeBefore-1,sizeAfter);
    }


}
