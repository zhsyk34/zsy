package com.cat.zsy.hb.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Location {

    private String country;

    private String city;

}