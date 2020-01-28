package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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
}
