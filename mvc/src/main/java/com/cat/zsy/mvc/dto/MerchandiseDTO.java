package com.cat.zsy.mvc.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MerchandiseDTO {
    private long id;
    private String name;
    private String code;
    private String type;
    private String store;

    private String specification;
    @JsonSerialize
    private BigDecimal price;
}
