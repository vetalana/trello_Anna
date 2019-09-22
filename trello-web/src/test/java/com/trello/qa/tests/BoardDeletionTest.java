package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("annabalabuha77@gmail.com", "annadorosh77");
        }
    }

    @BeforeMethod
    public void isOnHomePage() {
        if (!isTherePersonalBoards()) {
            app.getBoardHelper().returnToHomePage();
        }
    }

    public boolean isTherePersonalBoards() {
        return app.getBoardHelper().isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void deleteBoards() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        System.out.println(before);

        while (before > 3) {
            app.getBoardHelper().clickOnFirstPrivateBoard();
            Thread.sleep(5000);
            app.getBoardHelper().clickOnMoreButtonInBoardMenu();
            app.getBoardHelper().clickOnCloseBoard();
            app.getBoardHelper().clickOnDeleteButton();
            Thread.sleep(5000);
            app.getBoardHelper().returnToHomePage();
            before = app.getBoardHelper().getBoardsCount();
            System.out.println(before);
        }

        //    int after = getBoardsCount();
        //    Assert.assertEquals(after,before-1);
    }


}
