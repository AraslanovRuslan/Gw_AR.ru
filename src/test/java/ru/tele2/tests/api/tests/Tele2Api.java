package ru.tele2.tests.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tele2.tests.api.models.CartItem;

import java.util.Collections;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

@Tag("api")
public class Tele2Api {

        @BeforeAll
        public static void setUp() {
            RestAssured.baseURI = "https://chelyabinsk.tele2.ru";
        }

    @Test
    @DisplayName("Проверка добавления товара в корзину (API)")
    void addingProductBasket() throws JsonProcessingException {
        CartItem item = new CartItem(
                new CartItem.Item(
                        "internetStoreService",
                        new CartItem.CatalogId("prod5630018", "sku4990211"),
                        2
                )
        );
        String body = new ObjectMapper().writeValueAsString(Collections.singletonList(item));

        given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0;" +
                        " Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 " +
                        "Safari/537.36")
                .contentType(JSON)
                .body(body)
                .when()
                .put("/api/cart/items?siteId=siteCHELYABINSK")
                .then()
                .log().all()
                .statusCode(200)
                .body("meta.status", equalTo("OK"));
    }
        @Test
        @DisplayName("Проверка ответа со статусом 403 (API)")
        void testUnauthorizedAccess() {
             given()
                .contentType(JSON)
                .when()
                .put("/api")
                .then()
                .log().all()
                .statusCode(403);
    }
}


