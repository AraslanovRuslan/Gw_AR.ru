package ru.tele2.tests.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TeleApi {

    @Test
    void numberSearchTest() {

        given()
//                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//               .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("language=ru-RU; user-separator=part9; JSESSIONID=bImCeaU0D1vVyR0BhA8zxmmiXWAYDvXjM9-BPl8p1XBB-2QgHcg8!293722606; session-cookie=1746b2c4946d14ca3065de4dbeb261f5e512c79d3cdcc7e61bbb0f7f93f1eda4354f7e4817d13112e389bf058d486c9b")

                .header("Postman-Token", "<calculated when request is sent>")
                .header("Host", "<calculated when request is sent>")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
                .when()
                .post("https://ekt.tele2.ru/api/shop/products/numbers/bundles/1/groups?query=9014143038&exclude&siteId=siteEKT")
                .then()
                .log().all()
                .statusCode(200);
//                .body("[{"item":{"type":"internetStoreService","catalogId":{"productId":"prod5940068","skuId":"sku5290072"},"quantity":6}}]")
//                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
    @Test
    void n2umberSearchTest() {

        given()
//
//               .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("language=ru-RU; shop-id=DIGhPToeyOgRTCom6jbwYuxvEiHj; user-separator=part9; JSESSIONID=nqSDAO9kQKEVbsiNpPSsN0mHdf8HX0v3e4mPUOgzBD_kgaH-Poex!-819815606; session-cookie=1746ba9e5c78393b3065de4dbeb261f52133f41e0eb564a5e938e5ce0342aae4446368c88a94f9107c8ae2aba006bb07")
                .header("Postman-Token", "584ba3e4-49c4-40ef-9ab9-eebab00a2633")
                .body("item\n" +
                        "type internetStoreService\n" +
                        "catalogId\n" +
                        "productId prod5940068\n" +
                        "skuId sku5290072\n" +
                        "quantity 1\n")
                .header("Content-Length", "116")
                .header("Host", "chelyabinsk.tele2.ru")
           //     .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJFclYtZ2pITHdoQjk1eXhTZC05U0t3QzFJQ2RabEFvQUV0WFV4czJYaGRjIn0.eyJqdGkiOiI2MWVmZjc2NS1kZDc3LTQ0MGItOWE2Yy02N2RlYjM0ZGZkZTAiLCJleHAiOjE2NzcyNDcyNjUsIm5iZiI6MCwiaWF0IjoxNjc3MjMyODY1LCJpc3MiOiJodHRwczovL3Nzby50ZWxlMi5ydS9hdXRoL3JlYWxtcy90ZWxlMi1iMmMiLCJhdWQiOiJkaWdpdGFsLXN1aXRlLXdlYi1hcHAiLCJzdWIiOiJhOGM5ZWFmMy0zZmQyLTRlNWQtOTQ3Yy01Mjk1MzRjMDA0MmIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJkaWdpdGFsLXN1aXRlLXdlYi1hcHAiLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiJiMmI4NTI3YS1mMWJlLTRhZDctYWY3MS0zYWYzY2U2NDg3MjMiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiI3OTAwMDgyODUwNiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoicHJvZmlsZSBvZmZsaW5lX2FjY2VzcyBlbWFpbCBhcGlfYWNjZXNzIiwiY3VycmVudF91c2VybmFtZSI6Ijc5MDAwODI4NTA2IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJicmFuY2hfaWQiOiIxNCIsInN1YnNfaWQiOiI0NjA3NDg1MiIsInByZWZlcnJlZF91c2VybmFtZSI6Ijc5MDAwODI4NTA2IiwiY2xpZW50X3R5cGUiOiJiMmMifQ.KJER2aAoujFuckpm4Am44iC8jMgtiqJoMf7rOUrr6vT8gOLy-H9wq-GLy-n0ONu8CkIEJHX7Zs8gusqt3c9EHECDwxvGRxmuqt5hxU8X6rDnvtg_hj8oORj0zy3VghhIYIZZ9AZc96tndQQbObBoVfn51cZU50-_Sgrk-NXt0eycUd-Z7sVaPPFdBKcNFqd9VVXI6lQ109i8brvmENkPDMlcrwPHIfUm9xpoB3vaqaa3oTzrFtJFZH2FESYDSai5e78VxxCJhB4yGnyS6EVmFhNHm5IN0k__rVRypJjM6y9JOcBiEENOzMXOUGdprq4Jyn8WhIG2bsjv-ZhxioBDJg")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
                .header("Content-Type", "application/json")
                .when()
                .put("https://chelyabinsk.tele2.ru/api/cart/items?siteId=siteCHELYABINSK")
                .then()
                .log().all()
                .statusCode(200);
//                .body("success", is(true))
//                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }

    @Test
    void number3SearchTest() {

        given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
                .contentType("application/json")
                .body("[{\"item\":{\"type\":\"internetStoreService\",\"catalogId\":{\"productId\":\"prod5630018\",\"skuId\":\"sku4990211\"},\"quantity\":1}}]\"")
                .when()
                .put("https://chelyabinsk.tele2.ru/api/cart/items?siteId=siteCHELYABINSK")
                .then()
                .log().all()
                .statusCode(200);
//                .body("success", is(true))
//                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }
}
