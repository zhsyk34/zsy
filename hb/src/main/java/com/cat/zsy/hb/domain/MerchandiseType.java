package com.cat.zsy.hb.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 商品类型
 */
@Entity
@Table(name = "estore_goods_type")
@Data
public class MerchandiseType {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "typename")
    private String name;
}
