package com.tech.swivel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;

    @Test
    public void testAmazon1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.get("https://www.amazon.com/");

        Select allDropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        allDropdown.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("automation");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.findElement(By.xpath("//section[@aria-label='4 Stars & Up']"));

        driver.findElement(By.xpath("//li[starts-with(@id,'p_n_feature_nine_browse-bin')]"));

        String secondBookName = driver.findElement(By.xpath("//div[@data-index='3']//h2")).getText();

        driver.findElement(By.xpath("//div[@data-index='3']//h2")).click();

        String secondBookPrice = driver.findElement(By.xpath("//span[@id='price']")).getText();

        String bookName = driver.findElement(By.id("productTitle")).getText();

        Assert.assertEquals(bookName, secondBookName);
    }

    @Test
    public void testAmazon2() {

    }
}
