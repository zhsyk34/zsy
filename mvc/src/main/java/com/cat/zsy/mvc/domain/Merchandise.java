package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 商品
 */
@Entity
@Table(name = "estore_goods")
@Data
public class Merchandise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Column(name = "goodscode")
    private String code;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private MerchandiseType type;
}
