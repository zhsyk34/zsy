package com.cat.zsy.rest.entity;

import lombok.*;
import lombok.experimental.*;

import javax.xml.bind.annotation.*;
import java.math.*;

@Data
@Accessors(chain = true)

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
}
