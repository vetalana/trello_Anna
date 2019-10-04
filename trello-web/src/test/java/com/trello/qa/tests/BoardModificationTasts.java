package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTasts extends TestBase {
    @BeforeMethod
    public void precodition() throws InterruptedException {
        if(!app.getBoardHelper().isBoardPresent()){
            app.getBoardHelper().createBoard();
        }
    }
    @Test
    public void testRenameBoard() throws InterruptedException {
        app.getBoardHelper().clickOnFirstPrivateBoard();
        String boardName = "QA-21-Anna";
        app.getBoardHelper().changBoardProfile(boardName);
        Thread.sleep(3000);
        app.getBoardHelper().returnFromBoardToHomePage();
       // String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
      //  Assert.assertEquals(createdBoardName, boardName);
    }
}
