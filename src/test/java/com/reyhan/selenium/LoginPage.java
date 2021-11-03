package com.reyhan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static String email;
    private static String pass;
    WebDriver driver;
    By byEmail = By.id("LoginEmail");
    By byPass = By.id("Password");
    By byButton = By.id("loginLink");
    By byLoginName=By.className("dropdown-label");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void loginLc(){
        try {
            driver.findElement(By.className("dropdown-label")).click();
            Thread.sleep(3000);
            driver.findElement(byEmail).sendKeys(email);
            driver.findElement(byPass).sendKeys(pass);
            driver.findElement(byButton).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String loginControl(){
        String byLoginControl = driver.findElement(byLoginName).getText();


        return byLoginControl;

    }
}
