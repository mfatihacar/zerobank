package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AccountActivityStepDefs {

    @Then("the default account option should be {string}")
    public void the_default_account_option_should_be(String expectedDefaultOption) {
        String actualDefaultOption=new AccountActivityPage().accountOptionsList.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
    }

    @Then("the account dropdown should have the following options")
    public void the_account_dropdown_should_have_the_following_options(List<String> expectedAccountOptions) {
        List<WebElement> actualAccountOptions=new AccountActivityPage().accountOptionsList.getOptions();
        int i=1;
        for(String str:expectedAccountOptions){
            Assert.assertEquals(str,actualAccountOptions.get(i).getText());
            i++;
        }
    }

    @Then("the transactions table should have the following columns")
    public void the_transactions_table_should_have_the_following_columns(List<String> expectedTransactionsColumns) {
        List<WebElement> actualTransactionsColumns=new AccountActivityPage().transactionsColumns;
        int i=0;
        for(WebElement e:actualTransactionsColumns){
            Assert.assertEquals(expectedTransactionsColumns.get(i),e.getText());
            i++;
        }
    }
}
