package ru.praktikumService.qaScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStepTwoPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By inputDate = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // поле для ввода количества суток аренды class = "Dropdown-arrow"
    private By numberOfDaysArrow = By.className("Dropdown-control");
    private By orderButton = By.cssSelector("div.Order_Buttons__1xGrp>button.Button_Middle__1CSJM:nth-child(2)");

    public OrderStepTwoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    // выбор сегодняшней даты для доставки
    public void selectTodayDate() {
        driver.findElement(inputDate).click();
        // Создаем локатор, который найдет элемент с текущей датой
        By todayDateLocator = By.cssSelector("div.react-datepicker__day--today");

        // Кликаем по элементу с текущей датой после ожидания его появления
        wait.until(ExpectedConditions.elementToBeClickable(todayDateLocator)).click();

        // Ждем, пока поле ввода даты не станет непустым
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(inputDate), "value"));
    }

    // выбор количества дней аренды
    public void selectRentDuration(String duration) {
        driver.findElement(numberOfDaysArrow).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='" + duration + "']")).click();
    }

    // выбор цвета самоката
    public void selectColorOfScooter(String color){
        driver.findElement(By.id(color)).click();
    }

    // нажать на кнопку "Заказать"
    public void clickToOrderButton(){
        driver.findElement(orderButton).click();
    }

    public void setFormOrderPageTwo(String color, String duration){
        selectTodayDate();
        selectRentDuration(duration);
        selectColorOfScooter(color);
        clickToOrderButton();
    }
}