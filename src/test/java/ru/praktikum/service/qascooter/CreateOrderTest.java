package ru.praktikum.service.qascooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.service.qascooter.po.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private WebDriver driver;
    private String name;
    private String family;
    private String address;
    private String metro;
    private String phoneNumber;
    private String color;
    private String duration;


    public CreateOrderTest(String name, String family, String address, String metro, String phoneNumber, String color, String duration) {
        this.name = name;
        this.family = family;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.color = color;
        this.duration = duration;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Александр", "Иванов", "Рокосовского, 49", "ВДНХ", "+79080000000", "black", "сутки"},
                {"Николай", "Петров", "Кутозовская, 16", "Охотный ряд", "+7910000000", "grey", "двое суток"}
        });
    }

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\browser_driver\\geckodriver.exe");
        driver = new FirefoxDriver();

        /*System.setProperty("webdriver.chrome.driver", "C:\\browser_driver\\chromedriver.exe");
        driver = new ChromeDriver();*/

        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeadPage headPage = new HeadPage(driver);
        headPage.clickToRccConfirmButton();
    }

    @Test
    public void testOrderProcessWithOrderButtonInHead() {
        HeadPage headPage = new HeadPage(driver);
        By orderButton = headPage.getOrderInHeadButton();
        headPage.scrollToOrderButton(orderButton);
        headPage.clickToOrderButton(orderButton);

        OrderStepOnePage orderStepOnePage = new OrderStepOnePage(driver);
        orderStepOnePage.SetForm(name, family, address, metro, phoneNumber);

        OrderStepTwoPage orderStepTwoPage = new OrderStepTwoPage(driver);
        orderStepTwoPage.setFormOrderPageTwo(color, duration);

        OrderStepThreePage orderStepThreePage = new OrderStepThreePage(driver);
        orderStepThreePage.clickToYesButton();

        OrderIsCreatedPage orderIsCreatedPage = new OrderIsCreatedPage(driver);
        // Проверка, что открылась страница с заголовком "Заказ оформлен"
        assertTrue("Ожидается появления окна с заголовком 'Заказ оформлен'", orderIsCreatedPage.isPopUpCreateOrderDisplayed());
    }

    @Test
    public void testOrderProcessWithOrderButtonInMiddle() {
        HeadPage headPage = new HeadPage(driver);
        By orderButton = headPage.getOrderInMiddleButton();
        headPage.scrollToOrderButton(orderButton);
        headPage.clickToOrderButton(orderButton);

        OrderStepOnePage orderStepOnePage = new OrderStepOnePage(driver);
        orderStepOnePage.SetForm(name, family, address, metro, phoneNumber);

        OrderStepTwoPage orderStepTwoPage = new OrderStepTwoPage(driver);
        orderStepTwoPage.setFormOrderPageTwo(color, duration);

        OrderStepThreePage orderStepThreePage = new OrderStepThreePage(driver);
        orderStepThreePage.clickToYesButton();

        OrderIsCreatedPage orderIsCreatedPage = new OrderIsCreatedPage(driver);
        // Проверка, что открылась страница с заголовком "Заказ оформлен"
        assertTrue("Ожидается появления окна с заголовком 'Заказ оформлен'", orderIsCreatedPage.isPopUpCreateOrderDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}