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

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public WebElement transactionDescription;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> transactionDescriptions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td")
    public List<WebElement> tableCells;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr[1]/td")
    public List<WebElement> firstRowCells;

    @FindBy(xpath = "//div[@class='well']")
    public WebElement noResultsMessage;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> depositTransactions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> withdrawalTransactions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public WebElement depositTransaction;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public WebElement withdrawalTransaction;

    public int rowCount(){
        if(tableCells.size()==0){
            return 0;
        }else {
            return tableCells.size() / firstRowCells.size();
        }
    }
}
