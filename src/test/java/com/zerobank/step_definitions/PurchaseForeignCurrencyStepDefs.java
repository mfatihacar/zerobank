package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.pages.PurchaseForeignCurrencyTab;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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

    @When("the user enters Amount {int} chooses US Dollar and clicks on Calculate Costs")
    public void the_user_enters_Amount_chooses_US_Dollar_and_clicks_on_Calculate_Costs(Integer amount) {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountInputBox.sendKeys(amount.toString());
        payBillsPage.USDollarRadioButton.click();
        payBillsPage.calculateCostsButton.click();
    }

    @When("the user selects {string} chooses US Dollar and clicks on Calculate Costs")
    public void the_user_selects_chooses_US_Dollar_and_clicks_on_Calculate_Costs(String currencyName) {
        PurchaseForeignCurrencyTab purchaseForeignCurrencyTab=new PurchaseForeignCurrencyTab();
        Select currencyOptionsList=new Select(purchaseForeignCurrencyTab.currencyOptions);
        currencyOptionsList.selectByVisibleText(currencyName);
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.USDollarRadioButton.click();
        payBillsPage.calculateCostsButton.click();
    }

    @Then("the error popup should display the message {string}")
    public void the_error_popup_should_display_the_message(String expectedErrorMessage) {
        Alert alert= Driver.get().switchTo().alert();
        String actualErrorMessage=alert.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }
}
