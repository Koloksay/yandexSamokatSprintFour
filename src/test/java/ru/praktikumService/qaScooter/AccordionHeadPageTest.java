package ru.praktikumService.qaScooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AccordionHeadPageTest {
    // создали драйвер
    private WebDriver driver;
    private WebDriverWait wait;
    private String accordionHeading;
    private String expectedAccordionPanelText;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"accordion__heading-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"accordion__heading-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"accordion__heading-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"accordion__heading-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"accordion__heading-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"accordion__heading-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }
    // конструктор для класса, куда передают две переменные ФР и ОР
    public AccordionHeadPageTest(String accordionHeading, String expectedAccordionPanelText) {
        this.accordionHeading = accordionHeading;
        this.expectedAccordionPanelText = expectedAccordionPanelText;
    }

    @Before
    public void setUp() {
        /*System.setProperty("webdriver.gecko.driver", "C:\\browser_driver\\geckodriver.exe");
        driver = new FirefoxDriver();*/

        // Для запуска в Chrome, закомментируйте блок выше и раскомментируйте следующий блок
       System.setProperty("webdriver.chrome.driver", "C:\\browser_driver\\chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HeadPage headPage = new HeadPage(driver);
        headPage.clickToRccConfirmButton();
    }

    @Test
    public void testAccordionPanelText() {
        HeadPage headPage = new HeadPage(driver);
        // Прокручиваем до нужно элемента и кликаем на него
        headPage.scrollToAccordion(accordionHeading);
        headPage.clickAccordion(accordionHeading);

        // Получаем текст из выпадающего списка
        String actualAccordionPanelText = headPage.getAccordionPanelText(accordionHeading);

        // Проверяем, что текст соответствует ожидаемому
        Assert.assertEquals("Текст должен соответствовать ожидаемому", expectedAccordionPanelText, actualAccordionPanelText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}