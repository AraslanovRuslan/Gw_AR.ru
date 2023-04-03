package ru.tele2.tests.api.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestItem {
    @JsonProperty("item")
    private Item item;
}

