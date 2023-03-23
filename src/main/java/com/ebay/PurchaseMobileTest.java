package com.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseMobileTest extends Main {

    private String itemTitleText;
    private String priceValue;
    private String quantity;

    @Test(priority = 7)
    public void selectNewWindow() {
        // Select newly opened window
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }
    // select model pf the device
    @Test(priority = 8)
    public void selectModel() {
        try {
            WebElement selectBox = webDriver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Model dropdown is not found");
        }
    }

    // select carrier of the device
    @Test(priority = 9)
    public void selectCarrier() {
        try {
            WebElement selectBox = webDriver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier dropdown is not found");
        }
    }

    // select storage capacity of the device
    @Test(priority = 10)
    public void selectStorageCapacity() {
        try {
            WebElement selectBox = webDriver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity'], select[selectboxlabel='Storage']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage Capacity dropdown is not found");
        }
    }

    @Test(priority = 11)
    public void selectColor() {
        try {
            WebElement selectBox = webDriver.findElement(By.cssSelector("select[selectboxlabel='Color'], select[selectboxlabel='Colour']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color dropdown is not found");
        }
    }

    // select cosmetic of the device
    @Test(priority = 12)
    public void selectCosmetic() {
        try {
            WebElement selectBox = webDriver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic dropdown is not found");
        }
    }

    // get item name
    @Test(priority = 13)
    public void getItemName() {
        itemTitleText = webDriver.findElement(By.cssSelector("h1.x-item-title__mainTitle")).getText().trim();
        System.out.println("Item title: " + itemTitleText);
    }

    // get item price
    @Test(priority = 14)
    public void getItemPrice() {
        priceValue = webDriver.findElement(By.xpath("//span[@itemprop='price']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item price : " + priceValue);
    }

    // get item condition
    @Test(priority = 15)
    public void getItemCondition() {
        String condition = webDriver.findElement(By.xpath("//div[@class='x-item-condition-text']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item condition : " + condition);
    }

    // get item quantity
    @Test(priority = 16)
    public void getItemQuantity() {
        String quantityValue = webDriver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item quantity : " + quantityValue);
    }

    // add item to the cart
    @Test(priority = 17)
    public void addItemToCart() {
        WebElement addToCartButton = webDriver.findElement(By.xpath("//a[@class='ux-call-to-action fake-btn fake-btn--fluid fake-btn--primary']//span[@class='ux-call-to-action__text' and text()='Add to cart']"));
        addToCartButton.click();
    }

    // check item name is the same
    @Test(priority = 18)
    public void checkItemName() {
        String title = webDriver.findElement(By.className("item-title")).getText().trim();
        Assert.assertEquals(title, itemTitleText,"Title is not the same");
    }

    // check item price is the same
    @Test(priority = 19)
    public void checkItemPrice() {
        String subtotalValue = webDriver.findElement(By.cssSelector("div[data-test-id='SUBTOTAL']")).getText().trim();
        Assert.assertEquals(subtotalValue, priceValue,"Price is not the same");
    }

    // check quantity is the same
    @Test(priority = 20)
    public void checkQuantity() {
        WebElement dropdown = webDriver.findElement(By.xpath("//label[text()='Qty']/following-sibling::span/select"));
        String selectedOption = dropdown.getAttribute("value");
        Assert.assertEquals(selectedOption, quantity, "Quantity is not the same");
    }

    // get shipping value
    @Test(priority = 21)
    public void getShippingValue() {
        WebElement shippingElement = webDriver.findElement(By.cssSelector("div[data-test-id='SHIPPING']"));
        String shippingValue = shippingElement.getText().trim();
        System.out.println("Shipping value : " + shippingValue);
    }

}
