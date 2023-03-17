package com.qa.mis.locators;

import org.openqa.selenium.By;

public class LeaveManagementLocator {

    public static By menu_parentTabs(String parentTab) {
        return By.xpath("//ul[@class='side-menu-list']//span[text()='" + parentTab + "']");
    }

    public static By menu_childTabs(String childTab) {
        return By.xpath("//ul[@class='side-menu-list']//ul/li//span[text()='" + childTab + "']");
    }

    public static By heading_Page = By.xpath("//div[@class='card-block']/h5");

    public static By navigation_tabs(String tab) {
        return By.xpath("//ul[@class='nav']/li//span[contains(text(),'" + tab + "')]");
    }

    public static By title_LeaveFields(String tab) {
        return By.xpath("//div[@id='" + tab + "']/section/div/div/div[not(contains" +
                "(@style,'none'))]//label");
    }

    public static By SkillPopup = By.id("mypopupUpdateSkills");

    public static By skillClosebtn = By.id("btnskillsClose");

    public static By Location = By.xpath("//div[text()='Canaan Tower']");

    public static By Dashboardheading = By.xpath("//span[text()='Dashboard']");

    public static By lgnusernm=By.id("username");
    public static By lgnpwd=By.id("password");
    public static By sgnupbtn=By.id("btnLogin");

}
