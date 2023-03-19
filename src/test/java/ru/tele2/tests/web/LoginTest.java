package ru.tele2.tests.web;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Tag("web")
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Проверка авторизации")
    void authorization() {
        loginPage.openLogin()
                .data()
                .verifyResults();
    }

    @Test
    @DisplayName("Проверка тарифа [Мой онлайн+ 12_2021]")
    void tariff() {
        loginPage.openLogin()
                .data()
                .verifyResults()
                .remains();
    }
}








