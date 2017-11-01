package com.cat.zsy.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
}
