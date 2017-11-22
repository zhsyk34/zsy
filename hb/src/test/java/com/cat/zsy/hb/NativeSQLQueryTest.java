package com.cat.zsy.hb;

import com.cat.zsy.hb.domain.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.BooleanType;
import org.hibernate.type.LongType;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class NativeSQLQueryTest extends SpringTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = manager.unwrap(Session.class);
    }

    @Test
    public void test1() throws Exception {
        Query query = manager.createNativeQuery("SELECT * FROM estore_user");
        List<Object[]> list = query.getResultList();
        list.forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        Query query = manager.createNativeQuery("SELECT user_type FROM estore_user LIMIT 10");
        List list = query.getResultList();
        list.forEach(System.out::println);
    }

    @Test
    public void test3() throws Exception {
        NativeQuery query = session.createNativeQuery("SELECT * FROM estore_user LIMIT 10");

        query.addScalar("user_type", BooleanType.INSTANCE);
        query.addScalar("mobile", LongType.INSTANCE);

        List<Object[]> list = query.list();
        for (Object[] os : list) {
            for (Object o : os) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test4() throws Exception {
        NativeQuery query = session.createNativeQuery("SELECT * FROM estore_user LIMIT 10", User.class);
        query.list().forEach(System.err::println);
    }

    @Test
    public void test5() throws Exception {
        NativeQuery query = session.createNativeQuery("SELECT * FROM estore_user LIMIT 10");
        query.addEntity(User.class);
        query.list().forEach(System.err::println);
    }
}
