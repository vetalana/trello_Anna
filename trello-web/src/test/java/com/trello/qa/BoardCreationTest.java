package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
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
    public void testBoardCreation() throws InterruptedException {
        int before = getBoardsCount();
        Assert.assertTrue(isUserLoggedIn());
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        String boardName = "My board";
        fillBoardCreationForm(boardName, "descr qa 21");
        click(By.cssSelector("._1vk4y48RR5OmqE"));
        click(By.xpath("//span[contains(text(),'No team')]"));
        confirmBoardCreation();
        returnFromBoardToHomePage();
        String createdBoardName = getBoardNameFromBoardPage();
        int after = getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }


}
