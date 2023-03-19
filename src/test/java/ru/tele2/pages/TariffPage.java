package ru.tele2.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TariffPage {

    public TariffPage addingBlackTariffToTheBasket(){
        $("[href='/tariffs']").click();
        $(byTagAndText("h3", "Black")).click();
        $(".btn-black").click();
        $(".popup-inner-wrapper").shouldHave(text("Тариф «Black»"));
        $(byTagAndText("a", "Продолжить")).click();
        $("[href='/home']").click();
        $("[href='/tariffs']").click();

        return this;
    }
    public TariffPage addingTheTariffMyOnlineToTheBasket(){
        $(byTagAndText("h3", "Мой онлайн")).click();
        $(".sim-buy-col").click();
        $(".popup-inner-wrapper").shouldHave(text("Тариф «Мой онлайн»"));
        $(byTagAndText("a", "Продолжить")).click();
        $(".header-navbar-cart").shouldHave(text("В корзине 2 товара"));

        return this;
    }

    public TariffPage verifyBlackTariffToTheBasket(){
        $(".header-navbar-cart").shouldHave(text("В корзине 2 товара"));

        return this;
    }
    public TariffPage deleteTariff(){
        $(".icon-t2-trash-24").click();
        $(".shop-cart2__cart-body").shouldHave(text("Ваша корзина пока пуста"));

        return this;
    }

}
