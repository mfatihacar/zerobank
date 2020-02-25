package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payeeOptions;

    public Select payeeOptionsList=new Select(payeeOptions);

    @FindBy(id = "sp_account")
    public WebElement accountOptions;

    public Select accountOptionsList=new Select(accountOptions);

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement descriptionInputBox;

    @FindBy (id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']//span")
    public WebElement confirmationMessage;

    public WebElement elementByName(String fieldName){
        switch(fieldName){
            case "amount":
                return amount;
            case "date":
                return date;
            default:
                return null;
        }
    }

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement summary;

    public WebElement accessTab(String tabName){
        String xpathOfTab="//a[.='"+tabName+"']";
        return Driver.get().findElement(By.xpath(xpathOfTab));
    }

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInputBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(xpath = "(//div[@class='board'])[2]")
    public WebElement payeeInfoBoard;

    @FindBy(id = "alert_content")
    public WebElement payeeAddedConfirmationMessage;

    @FindBy(xpath = "(//div[@class='board'])[2]")
    public WebElement foreignCurrencyBoard;

    @FindBy(id = "pc_amount")
    public WebElement amountInputBox;

    @FindBy(id = "pc_inDollars_true")
    public WebElement USDollarRadioButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;
}
