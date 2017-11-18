package com.cat.zsy.mvc.repository;

import org.junit.Test;

public class ManagerRepositoryTest extends InitContext {

    @Test
    public void findAll() throws Exception {
        managerRepository.findAll().forEach(System.out::println);
    }
}