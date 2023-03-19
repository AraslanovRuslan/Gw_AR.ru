package ru.tele2.tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("web")
public class TariffTest extends TestBase{

    @Test
    @DisplayName("Добваление двух тарифов в корзину")
    void addTwoItemsToBasket() {
        loginPage.openLogin();
        tariffPage.addingBlackTariffToTheBasket()
                  .addingTheTariffMyOnlineToTheBasket()
                  .verifyBlackTariffToTheBasket();
    }

    @Test
    @DisplayName("Удаление тарифа из корзины")
    void removingTariffFromTheBasket() {
        loginPage.openLogin();
        tariffPage.addingBlackTariffToTheBasket()
                  .deleteTariff();
    }
}










