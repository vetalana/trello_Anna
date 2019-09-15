package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
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
    public void testTeamCreation() {
        int before = app.getTeamsCount();
        Assert.assertTrue(app.isUserLoggedIn());
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        String teamName = "qa21-"+System.currentTimeMillis();
        app.fillTeamCreationForm(teamName, "descr qa 21");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        //return to home page
        app.returnToHomePage();
        int after = app.getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);


        //Assert.assertTrue(isUserLoggedIn());
    }

    @Test(enabled = false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() {
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("qa21", "descr qa 21");
        app.clickXButton();
        //Assert


        //   Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnLeftNavMenu();
        String teamName = "qa21";
        app.fillTeamCreationForm(teamName, "descr qa 21");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        //return to home page
        app.returnToHomePage();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);

    }

}


