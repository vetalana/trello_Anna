package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation() {
        Assert.assertTrue(isUserLoggedIn());
        boardCreationFromRightHeader();

    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public void boardCreationFromRightHeader() {
        click(By.name("add"));

        click(By.cssSelector("[data-test-id=header-create-board-button]"));

        type(By.cssSelector("[data-test-id=header-create-board-title-input]"), "My Board");
        click(By.cssSelector("[type=button]"));
    }


}
