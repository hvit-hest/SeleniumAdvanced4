package org.courses.pages.adminpage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

        /*Sometimes it is not clicking without any message. That is why the second try.
         */
        WebElement we = myPersonalDriver.
                    findElement(By.xpath(String.format(searchForMainItemXpath, menuOption)));
        if (!we.getCssValue("color").equals("rgba(255, 0, 0, 1)")) {
            Actions action = new Actions(myPersonalDriver);
            action.moveToElement(we).click().build().perform();
        }
    }

    public void selectSubMenuOption(String subMenuOption) {
        WebElement subMenuOptionWe = myPersonalDriver.
                findElement(By.xpath(String.format(searchForSubMenuItemXpath, subMenuOption)));

         subMenuOptionWe.click();

          /*Sometimes it is not clicking without any message. That is why the second try.
           */
        WebElement we = myPersonalDriver.
                findElement(By.xpath(String.format(searchForSubMenuItemXpath, subMenuOption)));
        if (!we.getCssValue("color").equals("rgba(255, 0, 0, 1)")) {
            Actions action = new Actions(myPersonalDriver);
            action.moveToElement(we).click().build().perform();
        }

    }
}
