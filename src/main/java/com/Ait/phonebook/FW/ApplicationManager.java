package com.Ait.phonebook.FW;

import com.Ait.phonebook.FW.ContactHelper;
import com.Ait.phonebook.FW.HeaderHelper;
import com.Ait.phonebook.FW.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager{
    static WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;
    HeaderHelper header;

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user=new UserHelper(driver);
        contact=new ContactHelper(driver);
        home = new HomePageHelper(driver);
        header = new HeaderHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
/*
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }
*/
}
