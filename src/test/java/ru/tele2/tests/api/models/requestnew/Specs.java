package ru.tele2.tests.api.models.requestnew;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
        public static RequestSpecification request = with()
                .baseUri("https://chelyabinsk.tele2.ru")
                .basePath("/api")
                .log().all()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0;" +
                        " Win64; x64) AppleWebKit/537.36 (HTML, like Gecko) Chrome/110.0.0.0 " +
                        "Safari/537.36")
                .contentType(ContentType.JSON)
                .when();

        public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
//            .expectBody(containsString("success"))
                .build();
}
