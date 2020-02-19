package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage=new PayBillsPage();

    @When("the user creates new payee using following information")
    public void the_user_creates_new_payee_using_following_information(Map<String,String> payeeDetails) {
        BrowserUtils.waitForVisibility(payBillsPage.payeeInfoBoard,3);
        payBillsPage.payeeNameInputBox.sendKeys(payeeDetails.get("Payee Name"));
        payBillsPage.payeeAddressInputBox.sendKeys(payeeDetails.get("Payee Address"));
        payBillsPage.accountInputBox.sendKeys(payeeDetails.get("Account"));
        payBillsPage.payeeDetailsInputBox.sendKeys(payeeDetails.get("Payee Details"));
        payBillsPage.addButton.click();
    }

    @Then("the payee added message {string} should be displayed")
    public void the_payee_added_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,payBillsPage.payeeAddedConfirmationMessage.getText());
    }
}
