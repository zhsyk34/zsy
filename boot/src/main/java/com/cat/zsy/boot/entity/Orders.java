package com.cat.zsy.boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
//@EqualsAndHashCode(exclude = "details")
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String no;//编号

    @ManyToOne
    private Supplier supplier;//供应商

    @ManyToOne
    private Customer customer;//客户

    private int total;//总额
    private int reduce;//优惠

    private int paid;//已付
    private String recorder;//开单员

    //fetch=eager直接抓取,或者需要在同一事务中进行
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orders")
    private Set<Detail> details;

    private LocalDateTime happen;//时间
}
