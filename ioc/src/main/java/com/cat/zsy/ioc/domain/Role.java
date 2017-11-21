package com.cat.zsy.ioc.domain;

import dagger.Component;
import lombok.Data;

@Data

@Component
public class Role {
    private long id;
    private String name;
}
