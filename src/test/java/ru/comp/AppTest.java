package ru.comp;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.comp.Pages.HomePage;
import ru.comp.Pages.ResultsPage;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class AppTest extends TestNgTestBase {

  /** Свойство - объект стартовой страницы*/
  private HomePage homepage;

  /** Свойство - объект страницы с поисковой выдачей*/
  private ResultsPage resultsPage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
    resultsPage = PageFactory.initElements(driver, ResultsPage.class);
  }

  @Test
  @Parameters({"siteUrl", "queryString", "wantedLink", "gasisTitle"})
  public void testGazIs(String siteUrl,
                        String queryString,
                        String wantedLink,
                        String gasisTitle) throws MalformedURLException {
    //заходим на yandex.ru
    driver.get(siteUrl);
    //вводим запрос
    homepage.getSearchLine().sendKeys(queryString);
    //нажимаем Найти
    homepage.getSearchButton().click();
    //кликаем ссылку на нужный сайт
    resultsPage.getResultByLink(wantedLink).click();

    //получаем массив закладок
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    //переходим на последнюю открытую
    driver.switchTo().window(tabs.get(tabs.size() - 1));

    //проверяем title
    Assert.assertEquals(homepage.getTitle(), gasisTitle);
  }
}
