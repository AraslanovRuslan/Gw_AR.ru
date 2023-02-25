package ru.tele2.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

public class TeleApi {

        @BeforeAll
        public static void setUp() {
            RestAssured.baseURI = "https://chelyabinsk.tele2.ru";
        }

        @Test
        void addingProductBasket() {
            String body = "[{\"item\":{\"type\":\"internetStoreService\",\"catalogId\"" +
                    ":{\"productId\":\"prod5630018\",\"skuId\":" +
                    "\"sku4990211\"},\"quantity\":2}}]\"";

            given()
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0;" +
                            " Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 " +
                            "Safari/537.36")
                    .contentType("application/json")
                    .body(body)
                    .when()
                    .put("/api/cart/items?siteId=siteCHELYABINSK")
                    .then()
                    .log().all()
                    .statusCode(200);
   //                .body("amount", is(2))
  //                  .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
        }

    }
