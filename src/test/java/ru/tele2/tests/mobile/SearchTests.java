package ru.tele2.tests.mobile;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class SearchTests extends TestBase {

    @Test
    void searchTest() {
        back();
        step("Type search", () -> {
      //      $(accessibilityId("ru.tele2.mytele2:id/phoneText")).click();
            $(id("ru.tele2.mytele2:id/phoneText")).sendKeys("9000828506");
        });
//        step("Verify content found", () ->
//                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
//                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void searchTest2() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
