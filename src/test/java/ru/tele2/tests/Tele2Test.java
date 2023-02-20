package ru.tele2.tests;
import com.trudvsem.config.UserCreds;
import com.trudvsem.pages.RegistrationPageRT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Tele2Test extends TestBase{


        @Test
        @DisplayName("Проверка поисковой строки")
        void searchStringsTests() {
            step("Заходим на страницу неавторизованного соискателя",
                    RegistrationPageRT::unauthorizedApplicantPage);
            step("Нажимаем на кнопку [Поиск]" , () ->
                    $(".header-navbar-search").click());
            step("В строку поиска вводим [Обмен минут на кино] и нажимаем на Enter", () ->
                    $("#search-text").setValue("Обмен минут на кино").pressEnter());
            step("В поисковой странице проверяем отображение [Обмен минут на кино]", () ->
                    $(".search-results__items").shouldHave(text("Обмен минут на кино")));
    }

    @Test
    @DisplayName("Проверка смены региона")
    void vacanciesEmployer() {
        step("Заходим на страницу неавторизованного соискателя",
                RegistrationPageRT::unauthorizedApplicantPage);
        step("Нажимаем на регион", () ->
            $("#regionSearchOpener").click());
        step("В строке поиск региона вводим [Свердловская область]", () ->
                $(".text-field").setValue("Свердловская область").pressEnter());
        step("Кликаем по региону [Свердловская область]", () ->
                $("[href='https://ekt.tele2.ru/']").click());
        step("Проверяем отображение измененного региона", () ->
                $("#regionSearchOpener").shouldHave(text("Свердловская область")));

    }

    @Test
    @DisplayName("Проверка авторизации работодателя")
    void rtportalAvtEmployerTests() {
        step("Заходим на главную страницу неавторизованного соискателя",
                RegistrationPageRT::unauthorizedApplicantPage);
        step("Нажимаем на кнопку [Войти]", () ->
                $(".mega-menu__user-button").click());
        step("Проверяем открытие страницы [Авторизации]", () ->
                $(".content__title").shouldHave(text("Вход")));
        step("Переходим на таб [Для работодателей]", () ->
                $("[data-target='#employer']").click());
        step("Вводим логин и пароль", () -> {
            $("[name='login']").setValue(UserCreds.USER_LOGIN);
            $("[name='password']").setValue(UserCreds.USER_PASSWORD);
        });
        step("Нажимаем на кнопку [Войти]", () ->
                $("[data-action='submit']").click());
        step("Ожидаем, пока загрузится главная страница",
                RegistrationPageRT::waitingForDownload);
        step("Раскрываем информацию о компании", () ->
                $("#megaMenuDropdownUser").click());
        step("Проверяем ФИО менеджера", () ->
                $(".mega-menu__user-name").shouldHave(text("Воронцов Сергей ")));
        step("Проверяем название компании", () ->
                $(".mega-menu__user-text").shouldHave(text("ИП Воронцов С.С. ")));
    }

    @Test
    @DisplayName("Проверка открытия страницы [Вакансии компании]")
    void listVacanci(){

        step("Авторизация работодателя",
                RegistrationPageRT::openPageRegRT);
        step("Ожидаем, пока загрузится главная страница",
                RegistrationPageRT::waitingForDownload);
        step("Нажимаем на пункт меню [Вакансии компании]",
                RegistrationPageRT::menuCompanyVacancies);
        step("Нажимаем на пункт меню [Управление вакансиями]", () ->
                $("[aria-labelledby='megaMenuDropdown1']")
                        .find("[href='/auth/manager/vacancies']").click());
        step("Проверяем открытие страницы [Вакансии компании]", () ->
                $(".content__title").shouldHave(text("Вакансии компании")));
    }

    @Test
    @DisplayName("Проверка страницы  [Создание вакансии]")
    void rtportalNewVacancyTests() {
        step("Авторизация работодателя",
                RegistrationPageRT::openPageRegRT);
        step("Ожидаем, пока загрузится главная страница",
                RegistrationPageRT::waitingForDownload);
        step("Нажимаем на пункт меню [Вакансии компании]",
                RegistrationPageRT::menuCompanyVacancies);
        step("Нажимаем на пункт меню [Добавить вакансию]", () ->
                $("[aria-labelledby='megaMenuDropdown1']")
                        .find("[href='/auth/manager/vacancies/new']").click());
        step("Проверяем открытие страницы [Создание вакансии]", () ->
                $(".content__title").shouldHave(text("Создание вакансии")));
    }

    @Test
    @DisplayName("Проверка страницы [Тесты для вакансии]")
    void rtportalVacancyTests() {
        step("Авторизация работодателя",
                RegistrationPageRT::openPageRegRT);
        step("Ожидаем, пока загрузится главная страница",
                RegistrationPageRT::waitingForDownload);
        step("Нажимаем на пункт меню [Вакансии компании]",
                RegistrationPageRT::menuCompanyVacancies);
        step("Нажимаем на пункт меню [Тесты для вакансии]", () ->
                $("[aria-labelledby='megaMenuDropdown1']")
                        .find("[href='/auth/manager/tests']").click());
        step("Проверяем открытие страницы [Тесты]", () ->
                $(".content__title").shouldHave(text("Тесты")));
    }

    @Test
    @DisplayName("Проверка страницы [Частные агентства занятости]")
    void rtportalPrivateAgency() {
        step("Авторизация работодателя",
                RegistrationPageRT::openPageRegRT);
        step("Ожидаем, пока загрузится главная страница",
                RegistrationPageRT::waitingForDownload);
        step("Нажимаем на пункт меню [Все сервисы]", () ->
                $(".mega-menu__toggle").click());
        step("Нажимаем на пункт меню [Частные агентства занятости]", () ->
                $("[href='/private-employment-agency']").click());
        step("Проверяем открытие страницы [Частные агентства занятости]", () ->
                $(".content__title").shouldHave(text("Частные агентства занятости")));
    }
}










