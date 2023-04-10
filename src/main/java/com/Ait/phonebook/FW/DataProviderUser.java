package com.Ait.phonebook.FW;

import com.Ait.phonebook.model.Contact;
import com.Ait.phonebook.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> LogFromCSVNeg() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("Z:/Java/selenium/PhonebookTest/src/main/resources/LoginNeg.csv"));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line=reader.readLine();
        }
        return list.iterator();
    }


}
