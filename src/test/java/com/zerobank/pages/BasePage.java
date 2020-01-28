package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Account Summary']")
    public WebElement accountSummary;

    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement accountActivity;

    @FindBy(xpath = "//a[.='Transfer Funds']")
    public WebElement transferFunds;

    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBills;

    @FindBy(xpath = "//a[.='My Money Map']")
    public WebElement myMoneyMap;

    @FindBy(xpath = "//a[.='Online Statements']")
    public WebElement onlineStatements;

    public void navigateToPage(String pageName){
        switch (pageName){
            case "Account Summary":
                accountSummary.click();
                break;
            case "Account Activity":
                accountActivity.click();
                break;
            case "Transfer Funds":
                transferFunds.click();
                break;
            case "Pay Bills":
                payBills.click();
                break;
            case "My Money Map":
                myMoneyMap.click();
                break;
            case "Online Statements":
                onlineStatements.click();
                break;
        }
    }
}
