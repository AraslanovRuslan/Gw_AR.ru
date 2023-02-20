package com.trudvsem.pages;

import com.codeborne.selenide.Condition;
import com.trudvsem.config.UserCreds;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationPageRT {
    public static void openPageRegRT(){
        step("Заходим на страницу неавторизованного соискателя",
                RegistrationPageRT::unauthorizedApplicantPage);
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
    public static void menuCompanyVacancies(){
        $("#megaMenuDropdown1").click();
    }

    public static void unauthorizedApplicantPage(){
            open("/");
    }

}
