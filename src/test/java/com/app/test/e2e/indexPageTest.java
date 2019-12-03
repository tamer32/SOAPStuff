package com.app.test.e2e;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class indexPageTest {

  @FindBy(id = "username")
  private WebElement pageUsername;

  @FindBy(id = "playerClass2")
  private WebElement classChoser;

  @FindBy(name = "indexSubmitButton")
  private WebElement submitButton;

  public void enterUsername(String username) {
    pageUsername.clear();
    pageUsername.sendKeys(username);
  }

  public void chooseClass() {
    this.classChoser.click();
    this.submitButton.click();
  }
}
