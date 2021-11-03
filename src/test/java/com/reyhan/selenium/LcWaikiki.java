package com.reyhan.selenium;

import org.openqa.selenium.WebDriver;

public class LcWaikiki
{
    WebDriver driver;

    public LcWaikiki(WebDriver driver){
        this.driver = driver;
    }

    public void gotoLc(){
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
    }

}
