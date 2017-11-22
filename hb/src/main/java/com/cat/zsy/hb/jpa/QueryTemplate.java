package com.cat.zsy.hb.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface QueryTemplate<R> {

    default List<R> findAll(EntityManager manager, Class<R> result, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<R> criteria = builder.createQuery(result);

        this.execute(manager, criteria);

//        sort.stream().forEach(o -> criteria.orderBy(build(builder, root, o)));

        TypedQuery<R> query = manager.createQuery(criteria);

        Optional.ofNullable(pageable).ifPresent(p -> query.setFirstResult(p.getPageNumber()).setMaxResults(p.getPageSize()));

        return query.getResultList();
    }

    default Order build(CriteriaBuilder builder, Path<?> path, Sort.Order order) {
        Path<?> field = path.get(order.getProperty());
        return order.getDirection() == Direction.ASC ? builder.asc(field) : builder.desc(field);
    }

    void execute(EntityManager manager, CriteriaQuery<R> criteria);
}
