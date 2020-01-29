package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath ="//select[@id='aa_accountId']")
    public WebElement accountOptions;

    public Select accountOptionsList=new Select(accountOptions);

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionsColumns;


}
