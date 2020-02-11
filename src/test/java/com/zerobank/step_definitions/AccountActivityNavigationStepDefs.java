package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class AccountActivityNavigationStepDefs {

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountName) {
        new AccountSummaryPage().selectAccount(accountName).click();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedSelection) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        String actualSelection=accountActivityPage.accountOptionsList.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSelection,actualSelection);
    }

}
