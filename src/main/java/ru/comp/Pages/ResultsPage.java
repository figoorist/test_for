package ru.comp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class ResultsPage extends Page {
    /**
     * Конструктор
     * @param driver
     */
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получить WebElement - поле для ввода логина
     * @return
     */
    public WebElement getResultByLink(String link) throws MalformedURLException {
        URL url = new URL(link);
        return driver.findElement(By.linkText(url.getHost().replace("www.", "")));
    }
}
