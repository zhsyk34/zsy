package com.cat.zsy.mvc.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-data.xml"})
public class InitContext {

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected MerchandiseRepository merchandiseRepository;
    @Autowired
    protected ManagerRepository managerRepository;

}
