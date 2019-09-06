package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation() {
        Assert.assertTrue(isUserLoggedIn());
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm("My board","descr qa 21");
        confirmBoardCreation();
    }


}
