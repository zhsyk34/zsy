package com.cat.zsy.ioc.domain;

import lombok.Data;

import javax.inject.Inject;

//@Module(
//        injects = {Role.class}
//)
@Data
public class User {
    private long id;
    private String name;

    private Role role;

    @Inject
    public User(Role role) {
        this.role = role;
    }
}
