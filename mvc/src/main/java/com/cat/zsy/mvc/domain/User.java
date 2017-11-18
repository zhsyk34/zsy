package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estore_user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_nickname")
    private String name;
    @Column(name = "mobile")
    private String phone;

    //TODO
    @Transient
    private String address;//地区

    @Column(name = "shop_code")
    private String storeCode;//商店标识
    @Column(name = "user_money")
    private BigDecimal balance;//余额
//    @Column(name = "create_time")
//    private LocalDateTime createTime;//注册时间
}
