package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FindTransactionsStepDefs {



    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.findTransactionsTab.click();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String dateTo) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.dateFrom,5);
        accountActivityPage.dateFrom.sendKeys(dateFrom);
        accountActivityPage.dateTo.sendKeys(dateTo);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateFrom, String dateTo){
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.latestDate,3);
        boolean lastDate,firstDate;
        int expectedMaxYear=Integer.parseInt(dateTo.split("-")[0]);
        int expectedMaxMonth=Integer.parseInt(dateTo.split("-")[1]);
        int expectedMaxDay=Integer.parseInt(dateTo.split("-")[2]);
        int expectedMinYear=Integer.parseInt(dateFrom.split("-")[0]);
        int expectedMinMonth=Integer.parseInt(dateFrom.split("-")[1]);
        int expectedMinDay=Integer.parseInt(dateFrom.split("-")[2]);
        int actualMaxYear=Integer.parseInt(accountActivityPage.getTransactionDate(1).getText().split("-")[0]);
        int actualMaxMonth=Integer.parseInt(accountActivityPage.getTransactionDate(1).getText().split("-")[1]);
        int actualMaxDay=Integer.parseInt(accountActivityPage.getTransactionDate(1).getText().split("-")[2]);
        int actualMinYear=Integer.parseInt(accountActivityPage.getTransactionDate(accountActivityPage.transactionDates.size()).getText().split("-")[0]);
        int actualMinMonth=Integer.parseInt(accountActivityPage.getTransactionDate(accountActivityPage.transactionDates.size()).getText().split("-")[1]);
        int actualMinDay=Integer.parseInt(accountActivityPage.getTransactionDate(accountActivityPage.transactionDates.size()).getText().split("-")[2]);

        if(expectedMaxYear>actualMaxYear){
            lastDate=true;
        }else if(expectedMaxYear==actualMaxYear){
            if(expectedMaxMonth>actualMaxMonth){
                lastDate=true;
            }else if(expectedMaxMonth==actualMaxMonth){
                if(expectedMaxDay>=actualMaxDay){
                    lastDate=true;
                }else{
                    lastDate=false;
                }
            }else{
                lastDate=false;
            }
        }else{
            lastDate=false;
        }

        if(expectedMinYear<actualMinYear){
            firstDate=true;
        }else if(expectedMinYear==actualMinYear){
            if(expectedMinMonth<actualMinMonth){
                firstDate=true;
            }else if(expectedMinMonth==actualMinMonth){
                if(expectedMinDay<=actualMinDay){
                    firstDate=true;
                }else{
                    firstDate=false;
                }
            }else{
                firstDate=false;
            }
        }else{
            firstDate=false;
        }
        Assert.assertTrue(lastDate && firstDate);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.latestDate,3);
        ArrayList<Integer> actualYears=new ArrayList<>();
        ArrayList<Integer> actualMonths=new ArrayList<>();
        ArrayList<Integer> actualDays=new ArrayList<>();
        ArrayList<Boolean> assertion=new ArrayList<>();

        for(int i=1;i<=accountActivityPage.transactionDates.size();i++){
            actualYears.add(Integer.parseInt(accountActivityPage.getTransactionDate(i).getText().split("-")[0]));
            actualMonths.add(Integer.parseInt(accountActivityPage.getTransactionDate(i).getText().split("-")[1]));
            actualDays.add(Integer.parseInt(accountActivityPage.getTransactionDate(i).getText().split("-")[2]));
        }

        for(int i=0;i<actualYears.size()-1;i++){
            if(actualYears.get(i).intValue()>actualYears.get(i+1).intValue()){
                assertion.add(true);
            }else if(actualYears.get(i).equals(actualYears.get(i+1))){
                if(actualMonths.get(i).intValue()>actualMonths.get(i+1).intValue()){
                    assertion.add(true);
                }else if(actualMonths.get(i).equals(actualMonths.get(i+1))){
                    if(actualDays.get(i).intValue()>=actualDays.get(i+1).intValue()){
                        assertion.add(true);
                    }else{
                        assertion.add(false);
                    }
                }else{
                    assertion.add(false);
                }
            }else{
                assertion.add(false);
            }
        }

        for(boolean b:assertion){
            Assert.assertTrue(b);
        }
    }

    @When("the user clears the date inputs")
    public void the_user_clears_the_date_inputs() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateTo.clear();
        accountActivityPage.transactionDates=null;
        BrowserUtils.waitFor(2);
    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String expectedDate) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        for(WebElement e:accountActivityPage.transactionDates){
            Assert.assertFalse(e.getText().equals(expectedDate));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.descriptionInputBox,3);
        accountActivityPage.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String expectedDescription) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.transactionDescriptions ) {
                Assert.assertTrue(w.getText().contains(expectedDescription));
            }
        }else if(accountActivityPage.rowCount()==1){
            Assert.assertTrue(accountActivityPage.transactionDescription.getText().contains(expectedDescription));
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
    }

    @When("the user clears the description input")
    public void the_user_clears_the_description_input() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.descriptionInputBox.clear();
        accountActivityPage.transactionDescriptions=null;
        accountActivityPage.firstRowCells=null;
        accountActivityPage.tableCells=null;
        BrowserUtils.waitFor(2);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String unexpectedDescription) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.transactionDescriptions ) {
                Assert.assertFalse(w.getText().contains(unexpectedDescription));
            }
        }else if(accountActivityPage.rowCount()==1){
            Assert.assertFalse(accountActivityPage.transactionDescription.getText().contains(unexpectedDescription));
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
    }

    @When("clicks search")
    public void clicks_search() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        BrowserUtils.waitFor(2);
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        boolean flag=false;
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.depositTransactions ) {
                if(!w.getText().isEmpty()){
                    flag=true;
                    break;
                }
            }
        }else if(accountActivityPage.rowCount()==1){
            if(!accountActivityPage.depositTransaction.getText().isEmpty()){
                flag=true;
            }
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        boolean flag=false;
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.withdrawalTransactions ) {
                if(!w.getText().isEmpty()){
                    flag=true;
                    break;
                }
            }
        }else if(accountActivityPage.rowCount()==1){
            if(!accountActivityPage.withdrawalTransaction.getText().isEmpty()){
                flag=true;
            }
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
        Assert.assertTrue(flag);
    }

    @When("user selects type {string}")
    public void user_selects_type(String accountType) {
        FindTransactionsPage findTransactionsPage=new FindTransactionsPage();
        BrowserUtils.waitForVisibility(new AccountActivityPage().descriptionInputBox,3);
        findTransactionsPage.accountTypesList.selectByVisibleText(accountType);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.withdrawalTransactions ) {
                Assert.assertTrue(w.getText().isEmpty());
            }
        }else if(accountActivityPage.rowCount()==1){
            Assert.assertTrue(accountActivityPage.withdrawalTransaction.getText().isEmpty());
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        if(accountActivityPage.rowCount()>1){
            for (WebElement w:accountActivityPage.depositTransactions ) {
                Assert.assertTrue(w.getText().isEmpty());
            }
        }else if(accountActivityPage.rowCount()==1){
            Assert.assertTrue(accountActivityPage.depositTransaction.getText().isEmpty());
        }else{
            Assert.assertTrue(accountActivityPage.noResultsMessage.isDisplayed());
        }
    }
}
