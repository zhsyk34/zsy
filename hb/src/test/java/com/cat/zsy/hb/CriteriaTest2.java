package com.cat.zsy.hb;

import com.cat.zsy.hb.domain.User;
import com.cat.zsy.hb.jpa.QueryTemplate;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

@Transactional
public class CriteriaTest2 extends SpringTest {

    @Test
    public void find2() throws Exception {
        new QueryTemplate<User>() {

            @Override
            public void execute(EntityManager manager, CriteriaQuery<User> criteria) {

            }
        }.findAll();
    }

//    @Test
//    public void multiple() throws Exception {
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//
//        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
//
//        Root<User> root = criteria.from(User.class);
//
//        Path<String> name = root.get(User_.name);
//        Path<String> phone = root.get(User_.phone);
//        criteria.select(builder.array(name, phone));
//
//        Predicate predicate = builder.like(root.get(User_.name), "%人%");
//        criteria.where(predicate);
//
//        List<Object[]> list = manager.createQuery(criteria).getResultList();
//        list.forEach(os -> {
//            for (Object o : os) {
//                System.out.println(o);
//            }
//        });
//    }
//
//    @Test
//    public void multiple2() throws Exception {
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//
//        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
//
//        Root<User> root = criteria.from(User.class);
//
//        Path<String> name = root.get(User_.name);
//        Path<String> phone = root.get(User_.phone);
//        criteria.multiselect(name, phone);//multi select
//
//        Predicate predicate = builder.like(root.get(User_.name), "%人%");
//        criteria.where(predicate);
//
//        List<Object[]> list = manager.createQuery(criteria).getResultList();
//        list.forEach(os -> {
//            for (Object o : os) {
//                System.out.println(o);
//            }
//        });
//    }
//
//    @Test
//    public void multiple3() throws Exception {
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//
//        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
//
//        Root<User> root = criteria.from(User.class);
//
//        Path<String> name = root.get(User_.name);
//        Path<String> phone = root.get(User_.phone);
//        Path<BigDecimal> balance = root.get(User_.balance);
//        criteria.multiselect(name, phone, balance);//multi select
//
//        //参数设置
//        ParameterExpression<String> parameter = builder.parameter(String.class);
//
//        Predicate predicate = builder.like(root.get(User_.name), parameter);
//        criteria.where(predicate);
//
//        TypedQuery<Tuple> query = manager.createQuery(criteria);
//        query.setParameter(parameter, "%人%");
//
//        List<Tuple> list = query.getResultList();
//
//        list.forEach(this::print);
//    }
//
//    @Test
//    public void multiple4() throws Exception {
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//
//        CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
//
//        Root<User> root = criteria.from(User.class);
//
//        Path<String> name = root.get(User_.name);
//        Path<String> phone = root.get(User_.phone);
//        Path<BigDecimal> balance = root.get(User_.balance);
//        criteria.multiselect(name, phone, balance);//multi select
//
//        Predicate predicate = builder.like(root.get(User_.name), "%人%");
//        criteria.where(predicate);
//
//        TypedQuery<Tuple> query = manager.createQuery(criteria);
//
//        List<Tuple> list = query.getResultList();
//
//        list.forEach(this::print);
//    }
//
//    private void print(Tuple tuple) {
//        List<TupleElement<?>> elements = tuple.getElements();
//        for (int i = 0; i < elements.size(); i++) {
//            System.out.print(tuple.get(i) + " ");
//        }
//        System.out.println();
//    }
//
//    @Test
//    public void list() throws Exception {
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<Merchandise> criteriaQuery = builder.createQuery(Merchandise.class);
//        criteriaQuery.from(Merchandise.class);
//
//        TypedQuery<Merchandise> query = manager.createQuery(criteriaQuery);
//
//        query.setFlushMode(FlushModeType.AUTO);
//
//        System.out.println(query.getResultList().size());
//    }
//
//    @Test
//    public void join() throws Exception {
//        CriteriaQuery<OrdersDTO> query = builder.createQuery(OrdersDTO.class);
//
//        Root<Orders> ordersRoot = query.from(Orders.class);
//        Join<Orders, User> userJoin = ordersRoot.join(Orders_.user, JoinType.LEFT);
//
//        query.multiselect(
//                builder.countDistinct(userJoin.get(User_.id)),
//                builder.count(ordersRoot.get(Orders_.id)),
//                builder.sum(ordersRoot.get(Orders_.actual)),
//                builder.avg(ordersRoot.get(Orders_.actual))
//        );
//
//        List<OrdersDTO> list = manager.createQuery(query).getResultList();
//        list.forEach(System.err::println);
//    }
//
//    @Test
//    public void fetch() throws Exception {
//        CriteriaQuery<OrdersDTO> query = builder.createQuery(OrdersDTO.class);
//
//        Root<Orders> ordersRoot = query.from(Orders.class);
//        //TODO
//        Fetch<Orders, User> userFetch = ordersRoot.fetch(Orders_.user);
//
//        query.multiselect(
////                builder.countDistinct(userFetch.fetch(User_.id)),
//                builder.count(ordersRoot.get(Orders_.id)),
//                builder.sum(ordersRoot.get(Orders_.actual)),
//                builder.avg(ordersRoot.get(Orders_.actual))
//        );
//
//        List<OrdersDTO> list = manager.createQuery(query).getResultList();
//        list.forEach(System.err::println);
//    }
//
//    @Test
//    public void join2() throws Exception {
//        CriteriaQuery<MerchandiseDTO> criteria = builder.createQuery(MerchandiseDTO.class);
//
//        Root<MerchandiseSpecification> specificationRoot = criteria.from(MerchandiseSpecification.class);
//
//        Join<MerchandiseSpecification, MerchandiseStore> merchandiseStoreJoin = specificationRoot.join(MerchandiseSpecification_.MerchandiseStore);
//        Join<MerchandiseStore, Merchandise> merchandiseJoin = merchandiseStoreJoin.join(MerchandiseStore_.merchandise);
//        Join<MerchandiseStore, Store> storeJoin = merchandiseStoreJoin.join(MerchandiseStore_.store);
//        Join<Merchandise, MerchandiseType> typeJoin = merchandiseJoin.join(Merchandise_.type);
//
//        criteria.multiselect(
//                merchandiseJoin.get(Merchandise_.id),
//                merchandiseJoin.get(Merchandise_.name),
//                merchandiseJoin.get(Merchandise_.code),
//                typeJoin.get(MerchandiseType_.name),
//                storeJoin.get(Store_.name),
//                specificationRoot.get(MerchandiseSpecification_.specification),
//                specificationRoot.get(MerchandiseSpecification_.price)
//        );
//
//        criteria.where(builder.like(merchandiseJoin.get(Merchandise_.name), "%雪碧%"));
//        criteria.orderBy();
//
//        TypedQuery<MerchandiseDTO> query = manager.createQuery(criteria);
////        query.setFirstResult().setMaxResults();
//
//        List<MerchandiseDTO> list = query.getResultList();
//        list.forEach(System.err::println);
//    }

}
