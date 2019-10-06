package com.trello.qa.manager;

import com.trello.qa.model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(TeamData team) throws InterruptedException {

        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        Thread.sleep(5000);
        type(By.cssSelector("._15aIJYNKhrO4vB"), team.getDescription());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromTeamPage() throws InterruptedException {
        Thread.sleep(3000);
        //waitElement(By.cssSelector("h1"));
        return driver.findElement(By.xpath("//h1[@class='u-inline']")).getText();
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
        waitElement(By.cssSelector(".quiet-button"));
        //new WebDriverWait(driver,10).
        //    until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        waitElement(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings() throws InterruptedException {
        Thread.sleep(3000);
    //   waitElement(By.xpath("//span[contains(text(),'Settings')]"));
        click(By.xpath("//span[contains(text(),'Settings')]"));
    }

    public void clickOnFirstTeam() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

    public void initEditTeamProfil() {
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String name, String description) throws InterruptedException {
        type(By.name("displayName"), name);
        type(By.name("desc"), description);
    }


    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public boolean isTeamsPresent() {
        return getTeamsCount() > 0;
    }

    public void createTeam() throws InterruptedException {

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21-" + System.currentTimeMillis();
        fillTeamCreationForm(
                new TeamData().withTeamName(teamName)
                        .withDescription("descr qa 21"));
        clickContinueButton();

        returnToHomePage();
    }

    public void closeTeamMembersFill() {
        click(By.xpath("//button[@class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));
    }
}
