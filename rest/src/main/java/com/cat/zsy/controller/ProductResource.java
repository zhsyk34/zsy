package com.cat.zsy.controller;

import com.cat.zsy.dto.Result;
import com.cat.zsy.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GET
    public Result<List<Product>> list() {
        Product product = new Product().setId(100).setName("SanMao").setPrice(new BigDecimal(9.99));
        return Result.success(Collections.singletonList(product));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Result<Boolean> save(Product product) {
        logger.debug("save product:{}", product);
        return Result.success("save", true);
    }

    @PUT
    public Result<Boolean> update(Product product) {
        logger.debug("update product:{}", product);
        return Result.success("update", true);
    }

    @PATCH
    public Result<Boolean> merge(Product product) {
        logger.debug("merge product:{}", product);
        return Result.success("merge", true);
    }

    @DELETE
    @Path("{id}")
    public Result<Boolean> delete(@PathParam("id") long id) {
        return Result.success("delete success:" + id, true);
    }
}
