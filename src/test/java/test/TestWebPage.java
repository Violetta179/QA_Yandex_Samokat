package test;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWebPage {
    private WebDriver driver;
    private WebPage webPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/bitter_coffee/Загрузки/chromedriver");
        driver = new ChromeDriver();
        webPage = new WebPage(driver);
    }
    @Test
    public void testClickArrow() {
        setUp();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        webPage.acceptCookies().click();
        for (int i =0; i<8;i++)
        {
            webPage.getArrow(i).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //get text from arrow-element
            WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"accordion__panel-"+i+"\"]")));
            assertTrue(textElement.isDisplayed());
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
