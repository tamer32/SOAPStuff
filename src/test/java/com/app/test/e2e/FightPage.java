package com.app.test.e2e;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FightPage {
  @FindBy(how = How.XPATH, using = "//*[@id=\"battleOutcome\"]")
  private WebElement checkText;

  @FindBy(how = How.XPATH, using = "//*[@id=\"showCharacter\"]")
  private WebElement characterScreenButton;

  @FindBy(how = How.XPATH, using = "//*[@id=\"fightAgain\"]")
  private WebElement fightButton;

  @FindBy(xpath = "//*[@id=\"createNewCharacter\"]")
  private WebElement legacyButton;

  @FindBy(xpath = "//*[@id=\"rollTheDice\"]")
  private WebElement fighButton;

  public void checkText() {

    fighButton.click();
    if (checkText.getText().contains("Victory")) {
      assertThat(characterScreenButton.isDisplayed()).isFalse();
      assertThat(fightButton.isDisplayed()).isTrue();
      assertThat(legacyButton.isDisplayed()).isFalse();
    } else if (checkText.getText().contains("Create a new character")) {
      assertThat(legacyButton.isDisplayed()).isTrue();
      assertThat(characterScreenButton.isDisplayed()).isFalse();
      assertThat(fightButton.isDisplayed()).isFalse();
    }
  }
}
