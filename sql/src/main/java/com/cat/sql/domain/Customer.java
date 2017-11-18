package com.cat.sql.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {
    @Id
    private Long id;

    private String name;

    private String notes;

    @Version
    private Long version;
}