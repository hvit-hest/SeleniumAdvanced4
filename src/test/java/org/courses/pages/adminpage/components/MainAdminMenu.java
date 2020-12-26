package org.courses.pages.adminpage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainAdminMenu {

    private WebDriver myPersonalDriver;
    private String searchForMainItemXpath = "//li//span[contains(@class,'icon')]/following-sibling::span[.='%s']";
    private String searchForSubMenuItemXpath = "//li[starts-with(@id,'doc')]/*[.='%s']";

    public MainAdminMenu(WebDriver driver) {
        this.myPersonalDriver = driver;
    }

    public void selectMenuOption(String menuOption) {
        WebElement menuOptionWe = myPersonalDriver.
                findElement(By.xpath(String.format(searchForMainItemXpath, menuOption)));

        menuOptionWe.click();

        /*Sometimes driver is not clicking (very rare) without any message and reason when moving from bottom item of menu
        to top item.  That is why the second try.
         */
        menuOptionWe = myPersonalDriver.
                findElement(By.xpath(String.format(searchForMainItemXpath, menuOption)));
        if (!menuOptionWe.getCssValue("color").equals("rgba(255, 0, 0, 1)")) {
            myPersonalDriver.navigate().refresh();
            myPersonalDriver.findElement(By.xpath(String.format(searchForMainItemXpath, menuOption))).click();
        }
    }

    public void selectSubMenuOption(String subMenuOption) {

        WebElement subMenuOptionWe = myPersonalDriver.
                findElement(By.xpath(String.format(searchForSubMenuItemXpath, subMenuOption)));

        subMenuOptionWe.click();

         /*Sometimes driver is not clicking (very rare) without any message and reason when moving from bottom item of menu
        to top item.  That is why the second try.
         */
        subMenuOptionWe = myPersonalDriver.
                findElement(By.xpath(String.format(searchForSubMenuItemXpath, subMenuOption)));
        if (!subMenuOptionWe.getCssValue("color").equals("rgba(255, 0, 0, 1)")) {
            myPersonalDriver.navigate().refresh();
            myPersonalDriver.findElement(By.xpath(String.format(searchForSubMenuItemXpath, subMenuOption))).click();
        }

    }
}
