package com.ait.phonebook;

import com.Ait.phonebook.FW.DataProviderContact;
import com.Ait.phonebook.model.Contact;
import com.Ait.phonebook.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isSingOutButtonPresent()) {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRecForm(new User().setEmail("tja@gm.de").setPassword("tja@gmde2S!"));
            app.getHeader().click(By.name("login"));
        }
    }

    @Test(enabled = false)
    public void addContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        app.getContact().clickOnAddLink();

        app.getContact().addContact(new Contact().setName("Karl" + i).setSurName("Adam").setPhone("1234567890").setEmail("adam@gm.co").setAddress("Koblenz").setDesc("torwart"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
//        logger.info("Contact present. Actual result: " +
//                app.getContact().isContactCreated("Karl") + ". Expected result: true");

    }



    @Test(enabled = false, dataProvider = "addContactWithData", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveTest(String name, String sureName, String phone, String email, String adress, String desc) {

        app.getContact().clickOnAddLink();

        app.getContact().addContact(new Contact().setName(name).setSurName(sureName).setPhone(phone).setEmail(email).setAddress(adress).setDesc(desc));
        app.getContact().clickOnSaveButton();
        app.getContact().pause(200);
        app.getContact().removeContact();
        app.getContact().pause(200);
    }



    @Test(dataProvider = "addContactFromCSV", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVTest(Contact contact) {

        app.getContact().clickOnAddLink();

        app.getContact().addContact(contact);
        app.getContact().clickOnSaveButton();
        app.getContact().pause(200);
        app.getContact().removeContact();
        app.getContact().pause(200);
    }
}

