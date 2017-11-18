package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estore_admin")
@Data
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_truename")
    private String name;
    @Column(name = "mobile")
    private String phone;
    @Column(name = "user_address")
    private String address;

    @Column(name = "user_type")
    private int type;
    //php-serialize
    @Column(name = "shop_id")
    private String stores;

    @Column(name = "user_money")
    private BigDecimal balance;//余额

    @Column(name = "create_time")
//    @JsonSerialize(using = )
    private long createTime;//注册时间

}
