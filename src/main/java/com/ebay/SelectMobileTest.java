package com.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectMobileTest extends Main{

    @Test(priority = 1)
    @Parameters({"url"})
    public void getUrl(String url){
       webDriver.get(url);
    }
    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyUrl(String url){
        Assert.assertEquals(webDriver.getCurrentUrl(),url);
    }

    @Test(priority = 3)
    public void selectCategory() {
        WebElement mainDropDown = webDriver.findElement(By.id("gh-cat"));
        Select select = new Select(mainDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    // Search for "Mobile phone"
    @Test(priority = 4)
    public void searchMobile() {
        WebElement searchBox = webDriver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        webDriver.findElement(By.id("gh-btn")).click();
    }

    // Select brand as "Apple" from side panel
    @Test(priority = 5)
    public void selectApple() {
        // Select brand as "Apple" from side panel
        WebElement appleCheckBox = webDriver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleCheckBox.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"))));
    }

    // Select the first search item
    @Test(priority = 6)
    public void selectFirstItem() throws InterruptedException {
        // Select the first search item
        WebElement firstItem = webDriver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div"));
        firstItem.click();
        // wait until the  x-item-title__mainTitle element is displayed
        Thread.sleep(5000);

    }


}
