package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
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
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        while(before>3) {
            app.getTeamHelper().clickOnFirstTeam();
            app.getTeamHelper().openSettings();
            app.getTeamHelper().deleteTeam();
            app.getTeamHelper().returnToHomePage();
            before = app.getTeamHelper().getTeamsCount();
        }

    //    int after = getTeamsCount();
    //    Assert.assertEquals(after,before-1);

    }

}
