package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void precodition() throws InterruptedException {
        if (!app.getTeamHelper().isTeamsPresent()) {
            app.getTeamHelper().createTeam();
        }
    }

    @Test
    public void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfil();
        String teamName = "hh";
        app.getTeamHelper().changeTeamProfile(teamName, "hha");
        app.getTeamHelper().confirmEditTeam();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
       // Assert.assertEquals(createdTeamName, teamName);
        app.getTeamHelper().returnToHomePage();
    }
}
