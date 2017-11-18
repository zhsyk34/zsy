package com.cat.zsy.mvc.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "estore_order")
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "dno", nullable = false)
    private String no;

    @Column(name = "uid")
    private Long userId;//0表示游客
    @Column(name = "buyer_phone")
    private String phone;
    @Column(name = "shop_id", nullable = false)
    private String storeId;//店铺id

    @Column(name = "allcost")
    private String amount;//订单金额
    @Column(name = "sale")
    private String sale;//优惠金额

    @Column(name = "paystatus")
    private boolean paid;//是否付款

    //TODO
    @Column(name = "paytype")
    private String type;//付款方式

    /**
     * 订单状态0待接单，1准备中，2待取货，3退款中，4已完成，5退单完成，6已取消
     */
    @Column(name = "status")
    private String status;//订单状态

    @Column(name = "addtime")
    private String happen;//下单时间
    @Column(name = "paytime")
    private String payTime;//支付时间

}
