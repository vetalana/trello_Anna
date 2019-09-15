package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
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
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        while(before>3) {
            app.clickOnFirstTeam();
            app.openSettings();
            app.deleteTeam();
            before = app.getTeamsCount();
        }
        app.returnToHomePage();
    //    int after = getTeamsCount();
    //    Assert.assertEquals(after,before-1);

    }

}
