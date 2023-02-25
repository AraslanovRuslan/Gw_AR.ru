package ru.tele2.tests.api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketItemModel {
    private String productId;
    private String skuId;
    private String quantity;
}
