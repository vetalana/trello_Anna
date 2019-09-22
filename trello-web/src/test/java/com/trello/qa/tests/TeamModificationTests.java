package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {

    @Test
    public void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfil();
        String teamName = "hh";
        app.getTeamHelper().changeTeamProfile(teamName, "hha");
        app.getTeamHelper().confirmEditTeam();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        Assert.assertEquals(createdTeamName, teamName);
        app.getTeamHelper().returnToHomePage();
    }
}
