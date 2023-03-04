package ru.tele2.pages;

import com.codeborne.selenide.Condition;
import ru.tele2.config.UserCreds;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PageTele2 {
    public static void openPageRegRT(){
        step("Заходим на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Нажимаем на кнопку [Войти]", () ->
                $(".gtm-new-navigation-login").click());
        step("Нажимаем на кнопку [По паролю]", () ->
                $(byTagAndText("button", "По паролю")).click());
        step("Вводим логин и пароль", () -> {
            $("[name='username']").setValue(UserCreds.USER_LOGIN);
            $("[name='password']").setValue(UserCreds.USER_PASSWORD);
        });
        step("Нажимаем на кнопку [Войти]", () ->
                $(".btn-black").click());
        step("Проверяем ФИО абонента", () ->
                $(".inner-dashboard-numbers__main-info").shouldHave(text("Арасланов Руслан Гусманович")));
    }
    public static void waitingForDownload(){
        $("#darkLogoFill").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


    public static void unauthorizedApplicantPage(){
            open("/");
    }


    public static void addingBlackTariffToTheBasket(){
        step("Нажать на пункт меню [Тарифы]", () ->
                $("[href='/tariffs']").click());
        step("Нажать на тариф [Black]", () ->
                $(byTagAndText("h3", "Black")).click());
        step("Нажать на кнопку [Купить SIM]", () ->
                $(".btn-black").click());
        step("Проверить открытие модального окна Тариф [Black]", () ->
                $(".popup-inner-wrapper").shouldHave(text("Тариф «Black»")));
        step("Нажать на кнопку [Продолжить]", () ->
                $(byTagAndText("a", "Продолжить")).click());
    }
    public static void AddingTheTariffMyOnlineToTheBasket() {
        step("Нажать на тариф [Мой онлайн]", () ->
                $(byTagAndText("h3", "Мой онлайн")).click());
        step("Нажать на кнопку [Купить SIM]", () ->
                $(".sim-buy-col").click());
        step("Проверить открытие модального окна Тариф [Мой онлайн]", () ->
                $(".popup-inner-wrapper").shouldHave(text("Тариф «Мой онлайн»")));
        step("Нажать на кнопку [Продолжить]", () ->
                $(byTagAndText("a", "Продолжить")).click());
        step("Проверить в корзине добавление двух тарифов", () ->
                $(".header-navbar-cart").shouldHave(text("В корзине 2 товара")));
    }


}
