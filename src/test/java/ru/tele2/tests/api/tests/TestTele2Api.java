package ru.tele2.tests.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tele2.tests.api.models.request.CatalogId;
import ru.tele2.tests.api.models.request.Item;
import ru.tele2.tests.api.models.request.MyObjectItem;
import ru.tele2.tests.api.models.respons.ResponseMeta;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static io.restassured.RestAssured.given;
import static ru.tele2.tests.api.models.request.Specs.request;
import static ru.tele2.tests.api.models.request.Specs.responseSpec;

public class TestTele2Api {
	
	@Test
	@DisplayName("Проверка добавления товара в корзину (API)")
	void addingProductBasket() throws JsonProcessingException {
		
		CatalogId catalogId = new CatalogId();
		catalogId.setProductId("prod6480006");
		catalogId.setSkuId("sku5820027");
		
		Item item = new Item();
		item.setType("myObject");
		item.setCatalogId(catalogId);
		item.setQuantity(1);
		
		MyObjectItem myObjectItem = new MyObjectItem();
		myObjectItem.setItem(item);
		
		List<MyObjectItem> myObjectRootList = new ArrayList<>();
		myObjectRootList.add(myObjectItem);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myObjectRootList);
		System.out.println(json);

		ResponseMeta response = (ResponseMeta) given()
				.spec(request)
				.body(json)
				.when()
				.put("/cart/items?siteId=siteCHELYABINSK")
				.then()
				.spec(responseSpec)
				.log().body()
				.extract().as(ResponseMeta.class);

		assertThat(response.getMeta().getStatus()).isEqualTo("OK");
	}

	@Test
	@DisplayName("Проверка удаления товара из корзины (API)")
	void removingProductBasket() throws JsonProcessingException {

		CatalogId catalogId = new CatalogId();
		catalogId.setProductId("prod6480006");
		catalogId.setSkuId("sku5820027");

		Item item = new Item();
		item.setType("myObject");
		item.setCatalogId(catalogId);
		item.setQuantity(-1);

		MyObjectItem myObjectItem = new MyObjectItem();
		myObjectItem.setItem(item);

		List<MyObjectItem> myObjectRootList = new ArrayList<>();
		myObjectRootList.add(myObjectItem);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myObjectRootList);
		System.out.println(json);

		ResponseMeta response = (ResponseMeta) given()
				.spec(request)
				.body(json)
				.when()
				.put("/cart/items?siteId=siteCHELYABINSK")
				.then()
				.spec(responseSpec)
				.log().body()
				.extract().as(ResponseMeta.class);

		assertThat(response.getMeta().getStatus()).isEqualTo("OK");
	}

	@Test
	@DisplayName("Добавление не существующего промокода (API)")
	void addingNonExistingPromoCode() throws JsonProcessingException {

		ResponseMeta response = (ResponseMeta) given()
				.spec(request)
				.body("Tele2")
				.when()
				.put("/cart/promocode?siteId=siteCHELYABINSK")
				.then()
				.log().all()
				.extract().as(ResponseMeta.class);

		assertThat(response.getMeta().getStatus()).isEqualTo("ERROR");
	}
	@Test
    @DisplayName("Проверка ответа со статусом 403 (API)")
    void testUnauthorizedAccess() {
             given()
				.spec(request)
				.when()
                .then()
                .log().all()
                .statusCode(403);
    }
}