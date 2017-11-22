package com.cat.zsy.hb.repository;

import com.cat.zsy.hb.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager manager;

    public Book find() {
        return manager.find(Book.class, 1L);
    }
}
