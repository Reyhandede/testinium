package com.reyhan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaskedOperation {

    WebDriver driver;
    By byBasked = By.xpath("//*[@id=\"pd_add_to_cart\"]");
    By byProductPrice = By.xpath("//*[@class='basket-discount']");
    
    By byGotoBasked = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");
    By byBaskedProductPrice = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span");

    By byBaskedProductUp = By.xpath("//*[@class='oq-up plus']");
    By byRemoveProduct = By.xpath("//*[@class='fa fa-trash-o']");
    private static String baskedPrice;
    private static String productPrice;

    public BaskedOperation(WebDriver driver){
        this.driver = driver;
    }

    public String getBaskedPrice() {
        return baskedPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void addBasked(){
        productPrice = driver.findElement(byProductPrice).getText();
        driver.findElement(byBasked).click();
    }

    public void goToBasked(){
        try {
            Thread.sleep(2000);
            driver.findElement(byGotoBasked).click();
            baskedPrice = driver.findElement(byBaskedProductPrice).getText();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void baskedProductUp(){

        try {
            driver.findElement(byBaskedProductUp).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String baskedProductUpControl(){

        String control = driver.findElement(By.xpath("//*[@class='spinnerField ']/input")).getAttribute("value");
        return control;
    }

    public void baskedProductRemove(){
        try {
            driver.findElement(byRemoveProduct).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String productRemoveControl(){
        String control = driver.findElement(By.xpath("//*[@class='cartEmptyText']/h2")).getText();
        return control;
    }
}
