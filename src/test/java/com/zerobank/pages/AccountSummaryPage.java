package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//div/h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//h2[.='Credit Accounts']/following-sibling::div[1]//th")
    public List<WebElement> creditAccountsColumns;

}
