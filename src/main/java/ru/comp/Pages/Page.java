package ru.comp.Pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/** Абстрактный класс страницы веб-приложения*/
public class Page {
    /** Член класса - драйвер веб-браузера*/
    protected final WebDriver driver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /** Метод получения заголовка страницы
     * @return текст заголовка страницы
     * */
    public String getTitle() {
        return driver.getTitle();
    }
}
