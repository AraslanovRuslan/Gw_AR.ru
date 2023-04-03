package ru.tele2.tests.api.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Item {
    public String type;
    public CatalogId catalogId;
    public Integer quantity;

    // getters и setters
}
