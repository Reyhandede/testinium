package com.reyhan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductOperations {

    List<WebElement> result;
    WebDriver driver;
    By bySearch = By.id("search_input");
    By byButton = By.className("searchButton");
    By byModel = By.id(" model_2247185_5723315");




    By byPage =By.id("pageIndex");
    private String searchWord = "pantolon";

    public ProductOperations(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchWord(String searchWord) {
        driver.findElement(bySearch).click();
        this.searchWord = searchWord;
    }

    public void sendAndClickSearch(){
        try {
            driver.findElement(bySearch).sendKeys(searchWord);
            driver.findElement(byButton).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void secondPage(){
        try {
            driver.findElement(byPage).click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void productSelect(){

            driver.findElement(byModel).click();


    }
}
