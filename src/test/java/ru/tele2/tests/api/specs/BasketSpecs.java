package ru.tele2.tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class BasketSpecs {
    public static RequestSpecification basketRequestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .contentType(JSON)
            .baseUri("https://chelyabinsk.tele2.ru")
            .basePath("/api");

    public static ResponseSpecification basketResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("token", notNullValue())
            .build();
}