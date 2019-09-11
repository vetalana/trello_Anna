package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin(){
        if(!isUserLoggedIn()){
            login("annabalabuha77@gmail.com", "annadorosh77");
        }
    }
    @BeforeMethod
    public void isOnHomePage()  {
        if(!isTherePersonalBoards()){
            returnToHomePage();
        }
    }

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void deleteBoards() throws InterruptedException {
        int before = getBoardsCount();
        System.out.println(before);

        while(before>3) {
            clickOnFirstPrivateBoard();
            Thread.sleep(5000);
            clickOnMoreButtonInBoardMenu();
            clickOnCloseBoard();
            clickOnDeleteButton();
            returnToHomePage();
            before = getBoardsCount();
            System.out.println(before);
        }

    //    int after = getBoardsCount();
    //    Assert.assertEquals(after,before-1);
    }


}
