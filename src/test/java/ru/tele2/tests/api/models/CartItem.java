package ru.tele2.tests.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Item item;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String type;
        private CatalogId catalogId;
        private int quantity;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CatalogId {
        private String productId;
        private String skuId;
    }
}
