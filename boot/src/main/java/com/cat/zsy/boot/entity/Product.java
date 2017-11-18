package com.cat.zsy.boot.entity;

import lombok.Data;

//产品
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String no;//编号

    @Column(unique = true, nullable = false)
    private String name;//名称
    @Column(nullable = false)
    private String unit;//单位
    @Column(nullable = false)
    private int price;//单价
}
