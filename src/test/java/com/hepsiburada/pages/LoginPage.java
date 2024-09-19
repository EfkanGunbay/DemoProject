package com.hepsiburada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//span[.='Giriş Yapveya üye ol']")
    public WebElement girisYapveUyeOlButtonu;


}
