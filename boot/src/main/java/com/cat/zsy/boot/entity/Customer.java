package com.cat.zsy.boot.entity;

import lombok.Data;

//客户
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String no;//编号

    @Column(nullable = false)
    private String company;//公司
    @Column(nullable = false)
    private String name;//联系人
    @Column(nullable = false)
    private String address;//地址
    @Column(nullable = false)
    private String phone;//手机
}
