package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends BasePage {

    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@name='type']")
    public WebElement accountTypes;

    public Select accountTypesList=new Select(accountTypes);
}
