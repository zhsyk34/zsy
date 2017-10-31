package com.cat.yd.route;

import com.cat.yd.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Singleton
@Path("/users")
public class UserResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> list() {
        logger.debug("list----------------");
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int id = new Random().nextInt(100);
            list.add(new User().setId(id).setName("name" + id));
        }
        return list;
    }

    @GET
    @Path("{id}")
    public User find(@PathParam("id") long id) {
        logger.debug("find----------------");
        return new User().setId(id).setName("name" + id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String create(@BeanParam User user) {
        logger.debug("create----------------");
        logger.debug("user:{}", user);
        return "insert success";
    }

    @PUT
    public String update(@BeanParam User user) {
        logger.debug("update----------------");
        logger.debug("user:{}", user);
        return "update all success";
    }

    @PATCH
    public String update2(@BeanParam User user) {
        logger.debug("update2----------------");
        logger.debug("user:{}", user);
        return "update part success";
    }

    //for @XmlAccessorType(XmlAccessType.FIELD)
    @PATCH
    @Path("/update")
    public String update3(User user) {
        logger.debug("update3----------------");
        logger.debug("user:{}", user);
        return "update part by json success";
    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") long id) {
        logger.debug("delete----------------");
        return "delete success";
    }

    @GET
    @Path("test")
    public String search(@QueryParam("name") String name) {
        logger.debug("search----------------");
        return "name:" + name;
    }

    @GET
    @Path("test/{id}/score")
    public String search2(@PathParam("id") long id, @QueryParam("name") String name) {
        logger.debug("search2----------------");
        return "id:" + id + ",name:" + name;
    }

    @GET
    @Path("info")
    public String get(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        return null;
    }
//    @GET
//    @Path("test")
//    public String search2() {
//        logger.debug("search----------------");
//        return "name:";
//    }

}
