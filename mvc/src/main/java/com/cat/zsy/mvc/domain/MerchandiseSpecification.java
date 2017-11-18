package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estore_inventory_spec")
@Data
public class MerchandiseSpecification {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private MerchandiseStore MerchandiseStore;

    @Column(name = "spec_name")
    private String specification;

    private BigDecimal price;
}
