package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.PurchaseForeignCurrencyTab;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @When("the user waits for the page to load")
    public void the_user_waits_for_the_page_to_load() {
        PayBillsPage payBillsPage=new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.foreignCurrencyBoard,3);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyList) {
        PurchaseForeignCurrencyTab purchaseForeignCurrencyTab=new PurchaseForeignCurrencyTab();
        Select currencyOptionsList=new Select(purchaseForeignCurrencyTab.currencyOptions);
        List<WebElement> actualCurrencyList =currencyOptionsList.getOptions();
        int i=1;
        for (String s : expectedCurrencyList) {
            Assert.assertEquals(s,actualCurrencyList.get(i).getText());
            i++;
        }
    }
}
