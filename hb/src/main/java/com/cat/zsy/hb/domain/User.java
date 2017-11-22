package com.cat.zsy.hb.domain;

import com.cat.zsy.hb.config.config.hibernate.PhpTimeConvert;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "shop_code", referencedColumnName = "shopcode")
    //TODO:Store需要Serializable?
    private Store store;//商店标识

    @Column(name = "user_money")
    private BigDecimal balance;//余额

    @Column(name = "create_time")
    @Convert(converter = PhpTimeConvert.class)
    private LocalDateTime createTime;
}
