package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 商店
 */
@Entity
@Table(name = "estore_shop")
@Data
public class Store {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "shopname")
    private String name;
    @Column(name = "shopcode")
    private String code;
    @Column(name = "addr")
    private String address;
}
