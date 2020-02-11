package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr[1]/td[1]")
    public WebElement latestDate;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> transactionDates;

    public WebElement getTransactionDate(int index){
        return transactionDates.get(index-1);
    }

}
