package ru.praktikum.service.qascooter.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStepThreePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By buttonYes = By.xpath("//button[text()='Да']");

    public OrderStepThreePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickToYesButton(){
        // Ждем, пока элемент станет кликабельным
        WebElement buttonYesElement = wait.until(ExpectedConditions.elementToBeClickable(buttonYes));
        // Кликаем по элементу
        buttonYesElement.click();
    }
}