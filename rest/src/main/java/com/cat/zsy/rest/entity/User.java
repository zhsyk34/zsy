package com.cat.zsy.rest.entity;

import lombok.*;
import lombok.experimental.*;

import javax.ws.rs.*;
import javax.xml.bind.annotation.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

@Data
@Accessors(chain = true)

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @FormParam("id")
    private long id;
    @FormParam("name")
    private String name;
}
