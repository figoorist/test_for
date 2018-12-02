package ru.comp;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  /** Свойство - драйвер браузера*/
  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() {
    driver = new ChromeDriver();
    //устанавливаем неявный таймаут ожидания для драйвера 30 секунд
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //во весь экран
    driver.manage().window().maximize();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }
}
