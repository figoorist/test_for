package ru.comp;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.comp.Pages.HomePage;
import ru.comp.Pages.ResultsPage;

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
  public void testGazIs() {
    driver.get(baseUrl);

    homepage.getSearchLine().sendKeys(queryString);
    homepage.getSearchButton().click();
    resultsPage.getResultByLink(resultLink).click();

    Assert.assertFalse(false);
  }
}
