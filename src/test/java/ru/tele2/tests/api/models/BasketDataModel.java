package ru.tele2.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketDataModel {
    private BasketItemsListModel type;
    private String item;
}
