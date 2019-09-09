package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = getTeamsCount();
        Assert.assertTrue(isUserLoggedIn());
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21";
        fillTeamCreationForm(teamName, "descr qa 21");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        //return to home page
        returnToHomePage();
        int after = getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);


        //Assert.assertTrue(isUserLoggedIn());
    }

    @Test(enabled = false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() {
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("qa21", "descr qa 21");
        clickXButton();
        //Assert


        //   Assert.assertTrue(isUserLoggedIn());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnLeftNavMenu();
        String teamName = "qa21";
        fillTeamCreationForm(teamName, "descr qa 21");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        //return to home page
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);

    }

    private void clickOnPlusButtonOnLeftNavMenu() {

        click(By.cssSelector(".icon-add.icon-sm"));
    }

}


