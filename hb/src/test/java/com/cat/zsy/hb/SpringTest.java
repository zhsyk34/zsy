package com.cat.zsy.hb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-data.xml"})
public class SpringTest {

    @PersistenceUnit
    protected EntityManagerFactory factory;
    @PersistenceContext
    protected EntityManager manager;

    @Test
    public void init() throws Exception {
        System.out.println(factory);
        System.out.println(manager);
    }
}
