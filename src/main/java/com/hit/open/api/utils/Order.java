package com.hit.open.api.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@Getter
@RequiredArgsConstructor
public enum Order {
    ASC(Sort.Direction.ASC),
    DESC(Sort.Direction.DESC);


    private final Sort.Direction sortDirection;
}