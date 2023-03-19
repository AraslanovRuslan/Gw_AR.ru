package ru.tele2.tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@Tag("web")
public class SearchTest extends TestBase{

     @Test
     @DisplayName("Проверка поисковой строки")
     void searchStringsTests() {
         mainPage.openPage()
                 .searchPage();
    }

    @Test
    @DisplayName("Проверка смены региона")
    void region() {
        mainPage.openPage()
                .regionSearchOpener();
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
        mainPage.openPage();
        step("Нажать на кнопку поиска", () ->
            $(".icon-search-desctop").click());
        step("В поисковой строке ввести название тарифа", () ->
            $("#search-text").setValue(searchTariff).pressEnter());
        step("Проверить отображение тарифа в поисковой странице", () ->
            $(".result-item_tariff").shouldHave(text(expectedTariff)));
    }
}










