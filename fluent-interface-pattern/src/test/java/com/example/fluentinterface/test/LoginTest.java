package com.example.fluentinterface.test;

import com.example.fluentinterface.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void testSuccessfulLogin() {
        new LoginPage(driver)
            .enterUsername("testuser");
            .enterPassword("testpassword");
            .clickLogin();
        // Add assertions to verify successful login
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}