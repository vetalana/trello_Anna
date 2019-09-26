package com.trello.qa.tests;

import com.trello.qa.manager.BoardData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class BoardCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validBoard() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name", "description"});
        list.add(new Object[]{"NAME", "DESC"});
        list.add(new Object[]{"1234", "456745"});
        list.add(new Object[]{"$%&*", "@##$("});
        list.add(new Object[]{"name", ""});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validBoardFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader
                        (new File("src/test/resources/Board.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new BoardData()
                    .withBoardName(split[0])
                    .withS(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

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
    public void testBoardCreation() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        String boardName = "My board";
        app.getBoardHelper().fillBoardCreationForm
                (new BoardData()
                        .withBoardName(boardName));
        //            .withS("descr qa 21"));
        app.getBoardHelper().click(By.cssSelector("._1vk4y48RR5OmqE"));
        app.getBoardHelper().click(By.xpath("//span[contains(text(),'No team')]"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnFromBoardToHomePage();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }
    @Test(dataProvider = "validBoard" )
    public void testBoardCreationWithDataProvider(String boardName,String s) throws InterruptedException {
        BoardData board = new BoardData().withBoardName(boardName).withS(s);
        int before = app.getBoardHelper().getBoardsCount();
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();

        app.getBoardHelper().fillBoardCreationForm(board);


        //            .withS("descr qa 21"));
        app.getBoardHelper().click(By.cssSelector("._1vk4y48RR5OmqE"));
        app.getBoardHelper().click(By.xpath("//span[contains(text(),'No team')]"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnFromBoardToHomePage();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }
   /* @Test(dataProvider = "validBoard" )
    public void testBoardCreationWithDataProviderFromCsv(BoardData board) throws InterruptedException {
        BoardData board = new BoardData().withBoardName(boardName).withS(s);
        int before = app.getBoardHelper().getBoardsCount();
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();

        app.getBoardHelper().fillBoardCreationForm(board);


        //            .withS("descr qa 21"));
        app.getBoardHelper().click(By.cssSelector("._1vk4y48RR5OmqE"));
        app.getBoardHelper().click(By.xpath("//span[contains(text(),'No team')]"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnFromBoardToHomePage();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(createdBoardName, boardName);
        Assert.assertEquals(after, before + 1);
    }*/



}
