package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        new AccountSummaryPage().navigateToPage(pageName);

    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String pageName) {
        String expectedTitle="Zero"+" - "+pageName;
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the page should contain the following account types")
    public void the_page_should_contain_the_following_account_types(List<String> expectedAccountTypes) {
        List<WebElement> actualAccountTypes=new AccountSummaryPage().accountTypes;
        int i=0;
        for(WebElement e:actualAccountTypes){
            Assert.assertEquals(expectedAccountTypes.get(i),e.getText());
            i++;
        }
    }

    @Then("the credit accounts table should have the following columns")
    public void the_credit_accounts_table_should_have_the_following_columns(List<String> expectedCreditAccountColumns) {
        List<WebElement> actualCreditAccountColumns=new AccountSummaryPage().creditAccountsColumns;
        int i=0;
        for(WebElement e:actualCreditAccountColumns){
            Assert.assertEquals(expectedCreditAccountColumns.get(i),e.getText());
            i++;
        }
    }
}
