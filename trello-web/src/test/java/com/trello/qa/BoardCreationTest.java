package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin(){
        if(!app.isUserLoggedIn()){
            app.login("annabalabuha77@gmail.com", "annadorosh77");
        }
    }
    @BeforeMethod
    public void isOnHomePage()  {
        if(!isTherePersonalBoards()){
            app.returnToHomePage();
        }
    }

    public boolean isTherePersonalBoards() {
        return app.isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int before = app.getBoardsCount();
        Assert.assertTrue(app.isUserLoggedIn());
        app.clickOnPlusButtonOnHeader();
        app.selectCreateBoardFromDropDown();
        String boardName = "My board";
        app.fillBoardCreationForm(boardName, "descr qa 21");
        app.click(By.cssSelector("._1vk4y48RR5OmqE"));
        app.click(By.xpath("//span[contains(text(),'No team')]"));
        app.confirmBoardCreation();
        app.returnFromBoardToHomePage();
        String createdBoardName = app.getBoardNameFromBoardPage();
        int after = app.getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }


}
