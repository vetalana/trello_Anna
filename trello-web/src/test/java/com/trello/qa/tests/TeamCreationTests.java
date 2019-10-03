package com.trello.qa.tests;

import com.trello.qa.model.TeamData;
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

public class TeamCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]>validTeams()
    {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"name","description"});
        list.add(new Object[] {"NAME","DESC"});
        list.add(new Object[] {"1234","456745"});
        list.add(new Object[] {"$%&*","@##$("});
        list.add(new Object[] {"name",""});

       return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>validTeamsfromcsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
BufferedReader reader =
        new BufferedReader(new FileReader
                (new File("src/test/resources/Team.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(",");

            list.add(new Object[]{new TeamData()
                    .withTeamName(split[0])
                    .withDescription(split[1])});

            line = reader.readLine();
        }
        return list.iterator();
    }
    @BeforeClass
    public void ensurePreconditionsLogin() throws InterruptedException {
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("annabalabuha77@gmail.com", "annadorosh77");
        }
    }
    @BeforeMethod
    public void isOnHomePage()  {
        if(!isTherePersonalBoards()){
            app.getTeamHelper().returnToHomePage();
        }
    }

    public boolean isTherePersonalBoards() {
        return app.getTeamHelper().isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "qa21-"+System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(
                new TeamData().withTeamName(teamName));
                       // .withDescription("descr qa 21"));
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().closeTeamMembersFill();
      //  String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        //return to home page
        app.getTeamHelper().returnToHomePage();
        //int after = app.getTeamHelper().getTeamsCount();

     //   Assert.assertEquals(after, before + 1);
      //  Assert.assertEquals(createdTeamName, teamName);


        //Assert.assertTrue(isUserLoggedIn());
    }

    @Test(enabled = false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() throws InterruptedException {
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(
                new TeamData().withTeamName("qa21")
                        .withDescription( "descr qa 21"));
        app.getTeamHelper().clickXButton();
        //Assert


        //   Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        Thread.sleep(3000);
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        String teamName = "qa21";
        app.getTeamHelper().fillTeamCreationForm(
                new TeamData().withTeamName(teamName)
                        .withDescription("descr qa 21"));
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().closeTeamMembersFill();
 //       String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        //return to home page
        app.getTeamHelper().returnToHomePage();
  //      int after = app.getTeamHelper().getTeamsCount();
  //      Assert.assertEquals(after, before + 1);
   //     Assert.assertEquals(createdTeamName, teamName);

    }
    @Test(dataProvider = "validTeams")
    public void testTeamCreationFromLeftNavMenuWithDataProvider(String teamName, String description) throws InterruptedException {
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();
        Thread.sleep(3000);
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().closeTeamMembersFill();
       // String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        //return to home page
        app.getTeamHelper().returnToHomePage();
    //    int after = app.getTeamHelper().getTeamsCount();
      //  Assert.assertEquals(after, before + 1);
     //   Assert.assertEquals(createdTeamName, teamName);

    }
    @Test(dataProvider = "validTeamsfromcsv")
    public void testTeamCreationFromLeftNavMenuWithDataProviderFromcsv(TeamData team) throws InterruptedException {
       // TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();
        Thread.sleep(3000);
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        app.getTeamHelper().closeTeamMembersFill();
       // String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        //return to home page
        app.getTeamHelper().returnToHomePage();
      //  int after = app.getTeamHelper().getTeamsCount();
      //  Assert.assertEquals(after, before + 1);
      //  Assert.assertEquals(createdTeamName, teamName);

    }



}


