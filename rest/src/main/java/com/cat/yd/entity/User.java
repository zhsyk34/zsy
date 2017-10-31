package com.cat.yd.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

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
