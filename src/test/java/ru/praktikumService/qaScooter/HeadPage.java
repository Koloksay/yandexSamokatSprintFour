package ru.praktikumService.qaScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadPage {
    private WebDriver driver;
    private WebDriverWait wait;
    // кнопка "Заказать" в шапке страницы
    private By orderButtonInHead = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    private By orderButtonInMiddle = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");

    public HeadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public By getOrderButtonInHead() {
        return orderButtonInHead;
    }

    public By getOrderButtonInMiddle() {
        return orderButtonInMiddle;
    }

    public void scrollToAccordion(String accordionHeading) {
        WebElement element = driver.findElement(By.id(accordionHeading));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToOrderButton(By orderButton) {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickToOrderButton(By orderButton) {
        driver.findElement(orderButton).click();
    }


    public void clickAccordion(String accordionHeading) {
        WebElement accordionElement = driver.findElement(By.id(accordionHeading));
        wait.until(ExpectedConditions.elementToBeClickable(accordionElement));
        accordionElement.click();
    }

    public String getAccordionPanelText(String accordionHeading) {
        WebElement panelElement = driver.findElement(By.id("accordion__panel-" + accordionHeading.charAt(accordionHeading.length() - 1)));
        return panelElement.getText();
    }
}
