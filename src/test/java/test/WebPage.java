package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebPage {
    private WebDriver driver;

    public WebPage(WebDriver driver) {
        this.driver = driver;
    }

    //accept Cookies method
    public WebElement acceptCookies()
    {
        return driver.findElement(By.id("rcc-confirm-button"));
    }

    //Find element "arrow"
    public WebElement getArrow(int i) {
        return driver.findElement(By.xpath("//div[@id=\"accordion__heading-"+i+"\"]"));
    }
}
