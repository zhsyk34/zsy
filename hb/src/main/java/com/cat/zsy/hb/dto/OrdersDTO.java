package com.cat.zsy.hb.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdersDTO {
    private final long users;
    private final long orders;
    private final BigDecimal sale;
    private final Double average;
}
