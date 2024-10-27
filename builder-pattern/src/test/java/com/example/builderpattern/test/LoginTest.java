package com.example.builderpattern.test;

import com.example.builderpattern.page.LoginPage;
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
        // Using the Builder pattern to create and perform login
        LoginPage loginPage = new LoginPage.Builder(driver)
            .inputUsername("testuser")
            .inputPassword("testpassword")
            .build(); // Builds and performs login

        // Add assertions to verify successful login
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}