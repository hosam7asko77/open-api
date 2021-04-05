package com.hit.open.api.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@Getter
@RequiredArgsConstructor
public class LaptopSort {
    private LaptopSortField field;
    private Order order;
    public Sort getSort(){
        return Sort.by(getOrder().getSortDirection(),getField().getQueryField());
    }
}
