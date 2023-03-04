package ru.tele2.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class SearchTests extends TestBase1 {

    @Test
    @DisplayName("Проверка отправки смс с кодом")
    void sendCodeViaSms() {
        step("Ввод телефонного номера и отправка смс с кодом ", () -> {
            $(id("ru.tele2.mytele2:id/phoneText")).sendKeys("9000828506");
        });
        step("Проверка отправки смс с кодом", () ->
                $(id("ru.tele2.mytele2:id/codeSentToHint"))
                        .shouldHave(text("Код отправлен на номер +7 900 082 85 06")));
    }

    @Test
    @DisplayName("Проверка кнопки [Вход по паролю]")
    void рasswordLoginButton() {
        step("Ввод телефонного номера", () -> {
            $(id("ru.tele2.mytele2:id/phoneText")).sendKeys("9000828506");
        });
        step("Кликнуть по кнопке [Вход по паролю]", () -> {
            $(id("ru.tele2.mytele2:id/otherWays")).click();
        });
        step("Проверка открытия страницы Вход по паролю", () ->
                $(id("ru.tele2.mytele2:id/tvTitle"))
                        .shouldHave(text("Вход по паролю")));
    }
}
