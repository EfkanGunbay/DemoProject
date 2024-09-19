package com.hepsiburada.step_definitions;

import com.hepsiburada.pages.LoginPage;
import io.cucumber.java.en.Given;

import java.security.PublicKey;

public class LoginStep {
    LoginPage loginPage=new LoginPage();


    @Given("Giris Yap veya Uye ol Tiklanir")
    public void girisYapVeyaUyeolTiklanir(){
      loginPage.girisYapveUyeOlButtonu.click();

    }








    @Given("Giris Yap Tiklanir")
    public void girisYapTiklanir(){

    }

    @Given("Eposta Girilir")
    public void epostagirilir(){

    }

    @Given("Password Girilir")
    public void passwordGirilir(){

    }

    @Given("Giris Buttonu Yap Tiklanir")
    public void girisButtonuYapTiklanir(){

    }

    @Given("Uye Ait anasayfa acildigi gorulur")
    public void uyeAitAnasayfaAcildigiGorulur(){

    }



}
