package com.juaracoding.stepdefinition;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRecruitment {
    public static WebDriver driver;
    public LoginPage loginPage;
    public RecruitmentPage rect;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        rect = new RecruitmentPage();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        delay(1);
        loginPage.login();
    }

    @Test(priority = 1)
    public void testRect(){
        delay(2);
        rect.recruitment();
        Assert.assertEquals(rect.getTextDashboard(),"Application Stage");
    }

    @AfterClass
    public void quitBrowser() {
        DriverSingleton.closeObjectInstance();
    }

    private static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
