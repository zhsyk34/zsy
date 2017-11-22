package com.cat.zsy.hb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商店
 */
@Entity
@Table(name = "estore_shop")
@Data
//TODO:hibernate bug?
public class Store implements Serializable {
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
