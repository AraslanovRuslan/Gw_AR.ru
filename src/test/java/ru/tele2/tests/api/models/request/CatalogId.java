package ru.tele2.tests.api.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CatalogId {
    private String productId;
    private String skuId;

    // getters и setters
}
