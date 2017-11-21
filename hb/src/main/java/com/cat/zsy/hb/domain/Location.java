package com.cat.zsy.hb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Location {

    private String country;

    private String city;

}