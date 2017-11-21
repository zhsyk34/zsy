package com.cat.zsy.hb;

import com.cat.zsy.hb.domain.Book;
import org.junit.*;

import javax.persistence.*;

//https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
public class PersonTest {

    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private EntityTransaction transaction;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.err.println("-------beforeClass----------");
        factory = Persistence.createEntityManagerFactory("hibernate");
        manager = factory.createEntityManager();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.err.println("-------afterClass----------");

        manager.close();
        factory.close();
    }

    @Before
    public void before() throws Exception {
        System.err.println("-------before----------");
        transaction = manager.getTransaction();
        transaction.begin();
    }

    @After
    public void after() throws Exception {
        System.err.println("-------after----------");
        transaction.commit();
    }

    @Test
    public void init() throws Exception {

    }

    @Test
    public void first() throws Exception {
        manager.find(Book.class, 1L);
    }
}
