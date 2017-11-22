package com.cat.zsy.hb.jpa;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @param <R> the return type class
 * @param <F> the select from entity class
 */
@FunctionalInterface
public interface QueryCallback<R, F> {

    /**
     * in here,you can set
     * 1:the join search
     * 2:the select from
     * 3:the conditions
     */
    void execute(CriteriaQuery<R> criteria, Root<F> root);

}
