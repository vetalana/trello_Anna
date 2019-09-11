package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
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
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        while(before>3) {
            clickOnFirstTeam();
            openSettings();
            deleteTeam();
            before = getTeamsCount();
        }
        returnToHomePage();
    //    int after = getTeamsCount();
    //    Assert.assertEquals(after,before-1);

    }

}
