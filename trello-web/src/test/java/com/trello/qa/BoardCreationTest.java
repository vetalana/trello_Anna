package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
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

    public String getBoardNameFromBoardPage() {
        return driver.findElement(By.cssSelector(".js-board-editing-target")).getText();
    }

    public void returnFromBoardToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector("[name=house]"));
        click(By.cssSelector("[name=house]"));

    }


    public int getBoardsCount() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

}
