package com.ait.phonebook;

import com.Ait.phonebook.FW.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(enabled = true
    )
    public void tearDown() {
        app.stop();
    }
    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start Test" + m.getName()+ "with data: " + Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSED: Test method "+ result.getMethod().getMethodName());
        }else {
            logger.info("FAILED: Test Method " + result.getMethod().getMethodName() +
                    "Screenshot: " + app.getContact().takeScreenShot());
        }
        logger.info("=========================================");
    }

}
