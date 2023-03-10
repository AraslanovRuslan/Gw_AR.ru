package ru.tele2.tests.web;
import org.junit.jupiter.api.Tag;
import ru.tele2.config.UserCreds;
import ru.tele2.pages.PageTele2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



@Tag("web")
public class Tele2Test extends TestBase{


        @Test
        @DisplayName("Проверка поисковой строки")
        void searchStringsTests() {
            step("Заходим на страницу неавторизованного абонента",
                    PageTele2::unauthorizedApplicantPage);
            step("Нажимаем на кнопку [Поиск]" , () ->
                    $(".header-navbar-search").click());
            step("В строку поиска вводим [Обмен минут на кино] и нажимаем на Enter", () ->
                    $("#search-text").setValue("Обмен минут на кино").pressEnter());
            step("В поисковой странице проверяем отображение [Обмен минут на кино]", () ->
                    $(".search-results__items").shouldHave(text("Обмен минут на кино")));
    }

    @Test
    @DisplayName("Проверка смены региона")
    void region() {
        step("Заходим на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Нажимаем на регион", () ->
            $("#regionSearchOpener").click());
        step("В строке поиск региона вводим [Свердловская область]", () ->
                $(".text-field").setValue("Свердловская область").pressEnter());
        step("Кликаем по региону [Свердловская область]", () ->
                $("[href='https://ekt.tele2.ru/']").click());
        step("Проверяем отображение измененного региона", () ->
                $("#regionSearchOpener").shouldHave(text("Свердловская область")));

    }
    private final String LOGIN = System.getProperty("login");
    private final String PASSWORD = System.getProperty("password");
    @Test
    @DisplayName("Проверка авторизации")
    void authorization() {
        step("Заходим на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Нажимаем на кнопку [Войти]", () ->
                $(".gtm-new-navigation-login").click());
        step("Нажимаем на кнопку [По паролю]", () ->
                $(byTagAndText("button", "По паролю")).click());
        step("Вводим логин и пароль", () -> {
            $x("//input[@id='keycloakAuth.phone']").setValue(LOGIN);
            $("[name='password']").setValue(PASSWORD);
        });


        step("Нажимаем на кнопку [Войти]", () ->
                $(".btn-black").click());
        step("Проверяем ФИО абонента", () ->
                $(".dashboard-container__row").shouldHave(text("Руслан")));
        }
    @Test
    @DisplayName("Проверка тарифа [Мой онлайн+ 12_2021]")
    void tariff(){
        step("Авторизация абонента",
                PageTele2::openPageRegRT);
        step("Проверка загрузки логотипа",
                PageTele2::waitingForDownload);
        step("Нажимаем на пункт меню [Тариф и остатки]", () ->
                  $("[href='/lk/remains']").click());
        step("Проверяем отображение тарифа [Мой онлайн+ 12_2021]", () ->
                $(".subscriber-detailed-remnants__tariff-name")
                        .shouldHave(text("Мой онлайн+ 12_2021")));
    }

    @Test
    @DisplayName("Добваление двух тарифов в корзину")
    void addTwoItemsToBasket() {
        step("Войти на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Проверить загрузку логотипа",
                PageTele2::waitingForDownload);
        step("Добавление в корзину [Тарифа Black]",
                PageTele2::addingBlackTariffToTheBasket);
        step("Перейти на страницу[Тарифы для смартфонов]", () -> {
            $("[href='/home']").click();
            $("[href='/tariffs']").click();
        });
        step("Добавление в корзину [Тарифа Мой онлайн]",
                PageTele2::AddingTheTariffMyOnlineToTheBasket);
        step("Проверить в корзине добавление двух тарифов", () ->
                $(".header-navbar-cart").shouldHave(text("В корзине 2 товара")));
    }
    @Test
    @DisplayName("Удаление тарифа из корзины")
    void removingTariffFromTheBasket() {
        step("Войти на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Проверить загрузку логотипа",
                PageTele2::waitingForDownload);
        step("Добавление в корзину [Тарифа Black]",
                PageTele2::addingBlackTariffToTheBasket);
        step("Нажать на кнопку удаления", () ->
                $(".icon-t2-trash-24").click());
        step("Проверить отсутствие тарифов в корзине", () ->
                $(".shop-cart2__cart-body").shouldHave(text("Ваша корзина пока пуста")));
}
    @ParameterizedTest
    @DisplayName("Проверка наличия тарифа {1} в поисковой выдаче по запросу {0}")
    @CsvSource({
            "Black, Black",
            "Супер онлайн+, Супер онлайн+",
            "Игровой, Игровой",
            "Premium, Premium",
            "Мой разговор, Мой разговор"
    })
    void searchVacanciTest(String searchTariff, String expectedTariff){
        step("Войти на страницу неавторизованного абонента",
                PageTele2::unauthorizedApplicantPage);
        step("Проверить загрузку логотипа",
                PageTele2::waitingForDownload);
        step("Нажать на кнопку поиска", () ->
                $(".icon-search-desctop").click());
        step("В поисковой строке ввести название тарифа", () ->
                $("#search-text").setValue(searchTariff).pressEnter());
        step("Проверить отображение тарифа в поисковой странице", () ->
                $(".result-item_tariff").shouldHave(text(expectedTariff)));
    }
}










