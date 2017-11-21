package com.cat.zsy.hb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Publisher {

    private String name;

//    private Location location;

}