package com.cat.zsy.hb.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Publisher {

    @Column(name = "publisher_name")
    private String name;

//    private Location location;

}