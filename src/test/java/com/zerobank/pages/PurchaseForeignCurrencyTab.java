package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchaseForeignCurrencyTab {

    public PurchaseForeignCurrencyTab() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "pc_currency")
    public WebElement currencyOptions;

}
