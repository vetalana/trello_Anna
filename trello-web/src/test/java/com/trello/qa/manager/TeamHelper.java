package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromTeamPage() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public int getTeamsCount() /*throws InterruptedException*/ {
        // Thread.sleep(5000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {

    }

    public void deleteTeam() throws InterruptedException {
        Thread.sleep(5000);
        //new WebDriverWait(driver,10).
        //    until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings() {
        click(By.cssSelector(".icon-gear.icon-sm.OiX3P2i2J92Xat"));
    }

    public void clickOnFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

    public void initEditTeamProfil() {
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String name, String description) {
        type(By.name("displayName"), name);
        type(By.name("desc"), description);
    }


    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public boolean isTeamsPresent() {
        return getTeamsCount() > 0;
    }

    public void createTeam() {

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21-" + System.currentTimeMillis();
        fillTeamCreationForm(
                new TeamData().withTeamName(teamName)
                        .withDescription("descr qa 21"));
        clickContinueButton();

        returnToHomePage();
    }
}
