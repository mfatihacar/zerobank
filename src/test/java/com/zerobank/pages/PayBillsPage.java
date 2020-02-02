package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
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
}
