package com.cat.zsy.mvc.controller;

import com.cat.zsy.mvc.repository.MerchandiseRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

abstract class CommonController {
    @Setter(onMethod = @__({@Autowired}))
    protected MerchandiseRepository merchandiseRepository;

//    @PostMapping
//    protected abstract Result<Boolean> create(T t);
//
//    @GetMapping
//    protected abstract Result<Page<T>> retrieve(T t, Pageable pageable);
//
//    @PutMapping
//    protected abstract Result<Boolean> update(T t);
//
//    @DeleteMapping
//    protected abstract Result<Boolean> delete(K k);
}
