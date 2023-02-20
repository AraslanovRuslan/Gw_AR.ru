package com.trudvsem.pages;

import com.codeborne.selenide.Condition;
import com.trudvsem.config.UserCreds;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationPageRT {
    public static void openPageRegRT(){
        step("Заходим на главную страницу неавторизованного соискателя", () ->
                open("/"));
        step("Нажимаем на кнопку [Войти]", () ->
                $(".mega-menu__user-button").click());
        step("Ожидаем, пока загрузится главная страница работодателя", () ->
            $("[aria-label='Логотип']").shouldBe(Condition.visible, Duration.ofSeconds(15)));
        step("Переходим на таб [Для работодателей]", () ->
                $("[data-target='#employer']").click());
        step("Вводим логин и пароль", () -> {
            $("[name='login']").setValue(UserCreds.USER_LOGIN);
            $("[name='password']").setValue(UserCreds.USER_PASSWORD);
        });
        step("Нажимаем на кнопку [Войти]", () ->
                $("[data-action='submit']").click());
        step("Ожидаем, пока загрузится главная страница работодателя", () ->
              $("[aria-label='Логотип']").shouldBe(Condition.visible, Duration.ofSeconds(15)));
        step("Расскрываем информацию о компании", () ->
              $("#megaMenuDropdownUser").click());
        step("Проверяем ФИО менеджера", () ->
              $(".mega-menu__user-name").shouldHave(text("Воронцов Сергей ")));
        step("Проверяем название компании", () ->
              $(".mega-menu__user-text").shouldHave(text("ИП Воронцов С.С. ")));
    }
    public static void waitingForDownload(){
        $("[aria-label='Логотип']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
    public static void menuCompanyVacancies(){
        $("#megaMenuDropdown1").click();
    }

        public static void unauthorizedApplicantPage(){
            open("/");
    }

}
