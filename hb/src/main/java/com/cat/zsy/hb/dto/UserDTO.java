package com.cat.zsy.hb.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDTO {
    /*user*/
    private String name;
    private String phone;
    private String address;
    private String createTime;
    private BigDecimal balance;

    /*access*/
    private int count;

    /*orders*/
    private int payCount;
    private BigDecimal paySum;
    private BigDecimal payAvg;

}
