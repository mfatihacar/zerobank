package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        HomePage homePage=new HomePage();
        homePage.signinButton.click();
    }

    @When("the user enters valid credentials {string} and {string}")
    public void the_user_enters_valid_credentials_and(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("the user should land in the {string} page")
    public void the_user_should_land_in_the_page(String pageName) {
       String expectedTitle="Zero"+" - "+pageName;
       String actualTitle= Driver.get().getTitle();
       Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void the_user_enters_invalid_credentials_and(String username, String password) {
        new LoginPage().login(username,password);
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage=new LoginPage().errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }
}
