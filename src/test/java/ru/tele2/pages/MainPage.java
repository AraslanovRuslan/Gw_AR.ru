package ru.tele2.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPage {

    public MainPage openPage(){
        open("/");

        return this;
    }
    public MainPage searchPage(){
        $(".header-navbar-search").click();
        $("#search-text").setValue("Обмен минут на кино").pressEnter();
        $(".search-results__items").shouldHave(text("Обмен минут на кино"));

        return this;
    }

    public MainPage regionSearchOpener(){
        $("#regionSearchOpener").click();
        $(".text-field").setValue("Свердловская область").pressEnter();
        $("[href='https://ekt.tele2.ru/']").click();
        $("#regionSearchOpener").shouldHave(text("Свердловская область"));

        return this;
    }
    





}
