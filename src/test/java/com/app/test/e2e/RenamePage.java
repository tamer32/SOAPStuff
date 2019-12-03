package com.app.test.e2e;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RenamePage {
  @FindBy(id = "username")
  private WebElement username;

  @FindBy(id = "renameButton")
  private WebElement renameButton;

  protected void renameUsername(String username) {
    this.username.clear();
    this.username.sendKeys(username);
    renameButton.click();
  }
}
