package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.datatable.dependency.difflib.StringUtills;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

public class PayBillsStepDefs {

    String actualMessage;
    String summaryText="";


    @When("the user pays $ {int} from the {string} account to {string} on the {string} with {string} description")
    public void the_user_pays_$_from_the_account_to_on_the_with_description(Integer amount, String accountName, String payeeName, String date, String description) {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payeeOptionsList.selectByVisibleText(payeeName);
        payBillsPage.accountOptionsList.selectByVisibleText(accountName);
        payBillsPage.amount.sendKeys(amount.toString());
        payBillsPage.date.sendKeys(date);
        payBillsPage.descriptionInputBox.sendKeys(description);
        payBillsPage.payButton.click();
        actualMessage=payBillsPage.confirmationMessage.getText();
    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("the user pays $ {string} from the {string} account to {string} on the {string} with {string} description")
    public void the_user_pays_$_from_the_account_to_on_the_with_description(String amount, String accountName, String payeeName, String date, String description) {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payeeOptionsList.selectByVisibleText(payeeName);
        payBillsPage.accountOptionsList.selectByVisibleText(accountName);
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.descriptionInputBox.sendKeys(description);
        payBillsPage.payButton.click();
        if(!StringUtils.isAlphaSpace(date)) {
            summaryText = payBillsPage.summary.getAttribute("title");
        }
    }

    @Then("the error message {string} should be displayed on the date field")
    public void the_error_message_should_be_displayed_on_the_date_field(String expectedMessage) {
        String actualMessage=new PayBillsPage().date.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("the error message {string} should be displayed on the amount field")
    public void the_error_message_should_be_displayed_on_the_amount_field(String expectedMessage) {
        String actualMessage=new PayBillsPage().amount.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("the {string} should not accept the entry")
    public void the_field_should_not_accept_the_entry(String field) {
        Assert.assertTrue(StringUtils.isNumeric(summaryText.split(" ")[1]));
    }
}
