package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("annabalabuha77@gmail.com", "annadorosh77");
        }
    }
    @BeforeMethod
    public void isOnHomePage()  {
        if(!isTherePersonalBoards()){
            app.getBoardHelper().returnToHomePage();
        }
    }

    public boolean isTherePersonalBoards() {
        return app.getBoardHelper().isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        String boardName = "My board";
        app.getBoardHelper().fillBoardCreationForm(boardName, "descr qa 21");
        app.getBoardHelper().click(By.cssSelector("._1vk4y48RR5OmqE"));
        app.getBoardHelper().click(By.xpath("//span[contains(text(),'No team')]"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnFromBoardToHomePage();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }


}
