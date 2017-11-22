package com.cat.zsy.hb.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OdersStoreDTO {
    private final long count;
    private final BigDecimal sale;
    private final Double average;
    private long store;
    private String name;
}
