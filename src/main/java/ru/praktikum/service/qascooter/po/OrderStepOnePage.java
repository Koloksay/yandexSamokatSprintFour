package ru.praktikum.service.qascooter.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStepOnePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By inputName = By.cssSelector("input[placeholder='* Имя']");
    private By inputFamily = By.cssSelector("input[placeholder='* Фамилия']");
    private By inputAddress = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By inputMetro = By.cssSelector(".select-search__input");
    private By inputMetroOption = By.cssSelector(".select-search__select .select-search__row");
    private By inputPhoneNumber = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By buttonToNext = By.cssSelector("button.Button_Middle__1CSJM");
    private By orderHeader = By.cssSelector(".Order_Text__2broi");

    public OrderStepOnePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void setName(String name) {
        WebElement nameField = driver.findElement(inputName);
        nameField.sendKeys(name);
    }

    public void setFamily(String family) {
        WebElement familyField = driver.findElement(inputFamily);
        familyField.sendKeys(family);
    }

    public void setAddress(String address) {
        WebElement addressField = driver.findElement(inputAddress);
        addressField.sendKeys(address);
    }

    public void setMetro(String station) {
        WebElement metroInput = driver.findElement(inputMetro);
        metroInput.sendKeys(station);

        // Ждем, пока отобразится выпадающий список и выбираем первый вариант
        WebElement metroOption = wait.until(ExpectedConditions.elementToBeClickable(inputMetroOption));
        metroOption.click();
    }

    public void setPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField = driver.findElement(inputPhoneNumber);
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void clickToNext() {
        WebElement nextButton = driver.findElement(buttonToNext);
        nextButton.click();
    }

    public boolean isOrderHeaderDisplayed() {
        WebElement header = driver.findElement(orderHeader);
        return header.isDisplayed();
    }

    public void SetForm(String name, String family, String address, String station, String phoneNumber ) {
        setName(name);
        setFamily(family);
        setAddress(address);
        setMetro(station);
        setPhoneNumber(phoneNumber);
        clickToNext();
    }
}