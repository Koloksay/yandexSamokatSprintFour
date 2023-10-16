package ru.praktikum.service.qascooter.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderIsCreatedPage {

    private WebDriver driver;

    public OrderIsCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By PopUpCreateOrder = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");

    public boolean isPopUpCreateOrderDisplayed() {
        WebElement header = driver.findElement(PopUpCreateOrder);
        return header.isDisplayed();
    }
}