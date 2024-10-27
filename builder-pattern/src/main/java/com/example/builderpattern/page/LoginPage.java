package com.example.builderpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String username;
    private String password;

    // Private constructor
    private LoginPage(Builder builder) {
        this.driver = builder.driver;
        this.username = builder.username;
        this.password = builder.password;
    }

    // Static Builder class
    public static class Builder {
        private WebDriver driver;
        private String username;
        private String password;

        public Builder(WebDriver driver) {
            this.driver = driver;
        }

        public Builder inputUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder inputPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginPage build() {
            LoginPage loginPage = new LoginPage(this);
            loginPage.performLogin();
            return loginPage;
        }
    }

    private void performLogin() {
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }
}