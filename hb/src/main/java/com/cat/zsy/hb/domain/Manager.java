package com.cat.zsy.hb.domain;

import com.cat.zsy.hb.config.config.hibernate.PhpTimeConvert;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column(name = "shop_id")
    private String stores;//php-serialize

    @Column(name = "user_money")
    private BigDecimal balance;//余额

    @Column(name = "create_time")

//    @JsonSerialize(using = PhpTimestampDeserializer.class)
//    private long createTime;//注册时间

    @Convert(converter = PhpTimeConvert.class)
    private LocalDateTime createTime;
}
