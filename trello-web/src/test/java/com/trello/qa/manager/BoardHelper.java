package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void selectCreateBoardFromDropDown() {

        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }

    public void fillBoardCreationForm(String boardName, String s) {
        type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[type=button]"));

    }

    public String getBoardNameFromBoardPage() {
        return driver.findElement(By.cssSelector(".js-board-editing-target")).getText();
    }

    public void returnFromBoardToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        //new WebDriverWait(driver,10).
        //   until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("[name=house]"))));
        click(By.cssSelector("[name=house]"));
        click(By.cssSelector("[name=house]"));

    }

    public int getBoardsCount() throws InterruptedException {
        Thread.sleep(5000);
        //    new WebDriverWait(driver,10).
        //         until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void clickOnDeleteButton() {

        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickOnCloseBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));

    }

    public void clickOnMoreButtonInBoardMenu() throws InterruptedException {
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if (menuButton.getCssValue("visibility").equals("visibel")) {
            Thread.sleep(3000);
            click(By.cssSelector(".mod-show-menu"));
            click(By.cssSelector(".js-open-more"));
        } else {
            click(By.cssSelector(".js-open-more"));
        }
    }

    public void clickOnFirstPrivateBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }


    public void changBoardProfile(String boardName) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-board-editing-target")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-board-name-input")).sendKeys(boardName);
    }
}
