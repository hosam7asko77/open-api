package com.hit.open.api.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  LaptopSortField {
    NAME("name"),ID("id"),RAM("ram"),PRICE("price");
    private final String queryField;
}
