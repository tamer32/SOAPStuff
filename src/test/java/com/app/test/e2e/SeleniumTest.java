package com.app.test.e2e;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTest {

  private static WebDriver driver;
  static JavascriptExecutor js;

  @BeforeClass
  public static void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testCharacterCreationPage() {
    driver.navigate().to("http://localhost:8080/CRUDAppTheSecound/registerPage");
    IndexPageTest indexTest = new IndexPageTest();
    PageFactory.initElements(driver, indexTest);
    indexTest.enterUsername("Username");
    indexTest.chooseClass();
    assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText())
        .isEqualTo("Username");

    assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText())
        .isEqualTo("Bowman");
    driver.findElement(By.cssSelector("td:nth-child(7) > .btn")).click();
  }

  @Test
  public void testFightPage() {
    assertThat(driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText())
        .isEqualTo("Monster");
    assertFalse(driver.findElement(By.id("monsterName")).getSize() == null);
  }

  @Test
  public void testfighPhase() {
    FightPage fightPage = new FightPage();
    PageFactory.initElements(driver, fightPage);
    driver.findElement(By.xpath("//tr[2]/td[6]/input")).click();
    fightPage.checkText();
  }

  @Test
  public void testModifyUser() {
    String currUrl = driver.getCurrentUrl();
    String playerId = currUrl.substring(currUrl.lastIndexOf("/"));
    driver.navigate().to("http://localhost:8080/CRUDAppTheSecound/modifyPage" + playerId);
    RenamePage renamePage = new RenamePage();
    PageFactory.initElements(driver, renamePage);
    renamePage.renameUsername("Pesho");
    assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText())
        .isEqualTo("Pesho");
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }
}
