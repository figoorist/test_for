package ru.comp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
    /**
     * Конструктор
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получить WebElement - поле для ввода поискового запроса
     * @return
     */
    public WebElement getSearchLine(){
        return driver.findElement(By.id("text"));
    }

    /**
     * Получить WebElement - кнопка Найти
     * @return
     */
    public WebElement getSearchButton(){
        return driver.findElement(By.tagName("button"));
    }


}
