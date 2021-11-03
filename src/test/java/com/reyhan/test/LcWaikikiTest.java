package com.reyhan.test;
import com.reyhan.selenium.ProductOperations;
import com.reyhan.selenium.BaskedOperation;
import com.reyhan.selenium.LcWaikiki;
import com.reyhan.selenium.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LcWaikikiTest {
    WebDriver driver ;
    @Test
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LcWaikiki lcWaikiki = new LcWaikiki(driver);
        lcWaikiki.gotoLc();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lcwaikiki.com/tr-TR/TR");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("reyhandede_@hotmail.com");
        loginPage.setPass("reyhan12");
        loginPage.loginLc();
        Assert.assertEquals(loginPage.loginControl(),"Hesabım");
        ProductOperations productOperations = new ProductOperations(driver);
        productOperations.setSearchWord("pantolon");
        productOperations.sendAndClickSearch();
        productOperations.secondPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.lcwaikiki.com/tr-TR/TR/arama?q=pantolon&PageIndex=2");
        productOperations.productSelect();

        BaskedOperation baskedOperation = new BaskedOperation(driver);
        baskedOperation.addBasked();
        baskedOperation.goToBasked();
        Assert.assertEquals(baskedOperation.getBaskedPrice(),baskedOperation.getProductPrice());
        baskedOperation.baskedProductUp();
        Assert.assertEquals(baskedOperation.baskedProductUpControl(),"2");
        baskedOperation.baskedProductRemove();
        Assert.assertEquals(baskedOperation.productRemoveControl(),"Sepetiniz Boş");

        System.out.println("Successful");
    }



}
