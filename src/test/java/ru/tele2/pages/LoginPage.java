package ru.tele2.pages;

import ru.tele2.config.UserCreds;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LoginPage {
    public LoginPage openLogin(){
        open("/");
        $(".gtm-new-navigation-login").click();
        $(byTagAndText("button", "По паролю")).click();

        return this;
    }

    public LoginPage data(){
        $x("//input[@id='keycloakAuth.phone']").setValue(UserCreds.USER_LOGIN);
        $("[name='password']").setValue(UserCreds.USER_PASSWORD);
        $(".btn-black").click();

        return this;
    }

    public LoginPage verifyResults(){
         $(".dashboard-container__row").shouldHave(text("Руслан"));

        return this;
    }

    public LoginPage remains(){
        $("[href='/lk/remains']").click();
        $(".subscriber-detailed-remnants__tariff-name")
                        .shouldHave(text("Мой онлайн+ 12_2021"));

        return this;
    }
}
