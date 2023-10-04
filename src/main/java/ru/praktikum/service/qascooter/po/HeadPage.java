package ru.praktikum.service.qascooter.po;

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
    private By orderInHeadButton = By.cssSelector("div.Header_Nav__AGCXC>.Button_Button__ra12g");
    private By orderInMiddleButton = By.cssSelector("button.Button_Middle__1CSJM");
    private By rccConfirmButton = By.id("rcc-confirm-button");



    public HeadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public By getOrderInHeadButton() {
        return orderInHeadButton;
    }

    public By getOrderInMiddleButton() {
        return orderInMiddleButton;
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

    public void clickToRccConfirmButton() {
        WebElement element = driver.findElement(rccConfirmButton);
        if (element != null && element.isDisplayed()) {
            element.click();
        }
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
