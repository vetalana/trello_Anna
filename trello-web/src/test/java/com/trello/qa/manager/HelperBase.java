package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForElementAndClick(By locator, int time){
       new WebDriverWait(driver, time).
               until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(By locator) {

        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.name("add"));
    }

    public void returnToHomePage()  {
        waitForElementAndClick(By.cssSelector("[name=house]"),20);

    }

    public void clickOnPlusButtonOnLeftNavMenu() {

        click(By.cssSelector(".icon-add.icon-sm"));
    }
}
