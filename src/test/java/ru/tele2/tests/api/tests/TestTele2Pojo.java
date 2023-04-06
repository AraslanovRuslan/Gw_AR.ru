package ru.tele2.tests.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.tele2.tests.api.models.requestnew.CatalogId;
import ru.tele2.tests.api.models.requestnew.Item;
import ru.tele2.tests.api.models.requestnew.MyObjectItem;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static ru.tele2.tests.api.models.requestnew.Specs.request;
import static ru.tele2.tests.api.models.requestnew.Specs.responseSpec;

public class TestTele2Pojo {
	
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
		
		
	given()
			    .spec(request)
			    .body(json)
				.when()
				.put("/cart/items?siteId=siteCHELYABINSK")
				.then()
			    .spec(responseSpec)
			    .log().body();
	
	}
	
}

//	given()
//				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0;" +
//						" Win64; x64) AppleWebKit/537.36 (HTML, like Gecko) Chrome/110.0.0.0 " +
//						"Safari/537.36")
//						.contentType(JSON)
//						.body(json)
//						.when()
//						.put("https://chelyabinsk.tele2.ru/api/cart/items?siteId=siteCHELYABINSK")
//						.then()
//						.log().all()
//						.statusCode(200)
//						.body("meta.status", equalTo("OK"));
//
//						}